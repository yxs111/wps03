package com.company;

import com.wps.api.tree.et.Application;
import com.wps.api.tree.et.ClassFactory;
import com.wps.runtime.utils.Platform;
import com.wps.runtime.utils.WpsArgs;
import com4j.Variant;
import sun.awt.WindowIDProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.ComponentPeer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * Project              :   Java API Examples
 * Comments             :   WPS表格标签页面，包含一个左侧标签栏（LeftMenuPanel）和右侧的wps显示区域（OfficePanel）
 * JDK version used     :   JDK1.8
 * Author               :   Kingsoft
 * Create Date          :   2019-12-09
 * Version              :   1.0
 */

public class EtMainPanel extends JPanel {

    private LeftMenuPanel menuPanel;
    private OfficePanel officePanel;
    private Application app = null;
    private static final int DEFAULT_LCID = 2052; //默认的lcid,遇到有lcid的接口传这个就可以.

    public EtMainPanel() {
        this.setLayout(new BorderLayout());
        menuPanel = new LeftMenuPanel();
        officePanel = new OfficePanel();
        this.add(menuPanel, BorderLayout.WEST);
        this.add(officePanel, BorderLayout.CENTER);
        initMenu();
       // initRibbon();
      //  initFrameListener();
    }

    private void initMenu(){

        ETUtil etUtil = new ETUtil();
        menuPanel.addButton("常用", "打开试题", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Canvas client = officePanel.getCanvas();
                if (app != null) {
                    app.get_ActiveWorkbook().Close(false, Variant.getMissing(), Variant.getMissing(), DEFAULT_LCID);
                    // JOptionPane.showMessageDialog(client, "已经初始化过，不需要重新初始化！");
                    app.get_Workbooks().Add(Variant.getMissing(), DEFAULT_LCID);
                    app.get_ActiveWorkbook().get_ActiveSheet().put_Name("题4");
                    // 创建新的工作表
                    etUtil.ifText(app);

                    return;
                }

                long nativeWinId = 0;

                try {
                    if (Platform.isWindows()) {
                        ComponentPeer peer = client.getPeer();
                        Class clsCanvasPeer = Class.forName("sun.awt.windows.WComponentPeer");
                        Method getHWnd = clsCanvasPeer.getDeclaredMethod("getHWnd");
                        getHWnd.setAccessible(true);

                        nativeWinId = (long)getHWnd.invoke(peer);

                        System.out.println("exid:"+nativeWinId);
                    } else {
                        WindowIDProvider pid = (WindowIDProvider) client.getPeer();
                        nativeWinId = pid.getWindow();
                    }
                } catch (NoSuchMethodException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException | IllegalAccessException ex) {
                    ex.printStackTrace();
                }

                WpsArgs args = WpsArgs.ARGS_MAP.get(WpsArgs.App.ET);
                args.setWinid(nativeWinId);
                args.setHeight(client.getHeight());
                args.setWidth(client.getWidth());
//              args.setCrypted(false); //wps2016需要关闭加密
                app =  ClassFactory.createApplication();
                app.put_Visible(DEFAULT_LCID, true);

                // 初始化工作蒲完成之后新建工作表
                app.get_Workbooks().Add(Variant.getMissing(), DEFAULT_LCID);
                app.get_ActiveWorkbook().get_ActiveSheet().put_Name("题4");
                String s4 = app.get_ActiveWorkbook().get_ActiveSheet().get_Name();

                // 创建新的工作表
                etUtil.ifText(app);



            }
        });

        menuPanel.addArea("常用","text",etUtil.etRequirement);
        menuPanel.addButton("常用", "提交", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                BigDecimal subjectOne = etUtil.subjectOne(app);
                BigDecimal subjectTwo = etUtil.subjectTow(app);
                BigDecimal subjectThree = etUtil.subjectThree(app);

                menuPanel.updteText("test","第一题分数：" + subjectOne + "\n"+
                                                        "第二题分数：" + subjectTwo +"\n"+
                                                        "第三题分数：" + subjectThree +"\n"+
                                                        "第四题分数：" +"");
            }
        });

        menuPanel.addArea("常用","text","提交后输出区域");
    }

}
