package com.company;

import com.wps.api.tree.ex.DocumentWindowEx;
import com.wps.api.tree.wpp.*;
import com.wps.api.tree.wpp.Shape;
import com.wps.runtime.utils.Platform;
import com.wps.runtime.utils.WpsArgs;
import sun.awt.WindowIDProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.peer.ComponentPeer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import static com.wps.api.tree.wpp.MsoAutoShapeType.msoShapeIsoscelesTriangle;
import static com.wps.api.tree.wpp.MsoPresetTexture.msoTextureWovenMat;

/**
 * Project              :   Java API Examples
 * Comments             :   WPS演示标签页面，包含一个左侧标签栏（LeftMenuPanel）和右侧的wps显示区域（OfficePanel）
 * JDK version used     :   JDK1.8
 * Author               :   Kingsoft
 * Create Date          :   2019-12-09
 * Version              :   1.0
 * Item序列都是从0开始
 */
public class WppMainPanel extends JPanel {

    private LeftMenuPanel menuPanel;
    private OfficePanel officePanel;

    private Application app = null;

    public WppMainPanel() {
        this.setLayout(new BorderLayout());
        menuPanel = new LeftMenuPanel();
        officePanel = new OfficePanel();
        this.add(menuPanel, BorderLayout.WEST);
        this.add(officePanel, BorderLayout.CENTER);
        initMenu();
        // initRibbon();
        //initFrameListener();
    }

    private void initMenu(){

        WppUtil wppUtil = new WppUtil();

        BigDecimalUtil bigDecimalUtil = new BigDecimalUtil();
        menuPanel.addButton("常用", "打开试题", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Canvas client = officePanel.getCanvas();
                if (app != null) {
                    app.get_ActivePresentation().Close();
                    // JOptionPane.showMessageDialog(client, "已经初始化过，不需要重新初始化！");
                    app.get_Presentations().Add(MsoTriState.msoTrue);
                    return;
                }

                long nativeWinId = 0;
                try {
                    if (Platform.isWindows()) {
                        ComponentPeer peer = client.getPeer();
                        Class<?> clsCanvasPeer = Class.forName("sun.awt.windows.WComponentPeer");
                        Method getHWnd = clsCanvasPeer.getDeclaredMethod("getHWnd");
                        getHWnd.setAccessible(true);

                        nativeWinId = (long)getHWnd.invoke(peer);
                        System.out.println("wppid:"+nativeWinId);
                    } else {
                        WindowIDProvider pid = (WindowIDProvider) client.getPeer();
                        nativeWinId = pid.getWindow();
                    }
                } catch (NoSuchMethodException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException | InvocationTargetException ex) {
                    ex.printStackTrace();
                }

                WpsArgs args = WpsArgs.ARGS_MAP.get(WpsArgs.App.WPP);
       //        args.setPath("C:/Program Files (x86)/Microsoft Office"); //手动指定的wpp程序路径（默认调用/usr/bin/wpp）
                args.setWinid(nativeWinId);
                args.setHeight(client.getHeight());
                args.setWidth(client.getWidth());
    //            args.setCrypted(false); //wps2016需要关闭加密
                app = ClassFactory.createApplication();
                app.put_Visible(MsoTriState.msoTrue);

                 // 初始化完成之后新建ppt
                app.get_Presentations().Add(MsoTriState.msoTrue);
            }
        });


        menuPanel.addArea("常用","text",wppUtil.wppRequirement);

        menuPanel.addButton("常用", "提交", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                BigDecimal subjectOne = wppUtil.subjectOne(app);
                BigDecimal subjectTwo = wppUtil.subjectTwo(app);
                BigDecimal subjectThree = wppUtil.subjectThree(app);
                BigDecimal subjectFour = wppUtil.subjectFour(app);
                BigDecimal subjectFive = wppUtil.subjectFive(app);
                BigDecimal subjectSix = wppUtil.subjectSix(app);
                BigDecimal subjectSeven = wppUtil.subjectSeven(app);
                BigDecimal subjectEight = wppUtil.subjectEight(app);
                BigDecimal subjectNine = wppUtil.subjectNine(app);
                BigDecimal subjectTen = wppUtil.subjectTen(app);
                BigDecimal max = bigDecimalUtil.addTen(subjectOne,subjectTwo,subjectThree,subjectFour,subjectFive,subjectSix,subjectSeven,subjectEight,subjectNine,subjectTen);

                menuPanel.updteText("test","分数："+max);
                app.get_ActivePresentation().SaveAs("C:/Users/001/Desktop/ppt", PpSaveAsFileType.ppSaveAsPresentation, MsoTriState.msoTrue);
                String path = app.get_ActivePresentation().get_FullName();
                System.out.println(path.replaceAll("\\\\","/"));
                 //System.out.println(path);


            }
        });



        menuPanel.addArea("常用","text","提交后输出区域");

        menuPanel.addButton("常用", "关闭", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.get_ActivePresentation().Close();
            }
        });


    }


}
