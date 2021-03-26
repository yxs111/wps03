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

                System.out.println(s4);
                // 创建新的工作表
                etUtil.ifText(app);





            }
        });





        menuPanel.addArea("常用","text",etUtil.etRequirement);
        menuPanel.addButton("常用", "提交", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // 工作表个数
                int i = app.get_Worksheets().get_Count();
                String sheetName = app.get_ActiveWorkbook().get_ActiveSheet().get_Name();
                System.out.println(sheetName);

                // 获得单元格内字体样式名称
                String s = app.get_ActiveCell().get_Font().get_Name().toString();

                // 获取单元格函数
                Object omacth =  app.get_ActiveCell().get_FormulaArray();
                String smacth = omacth.toString();

                // 返回选定单元格内的文本
                Object oContentText =  app.get_ActiveCell().get_Text();
                String sContentText = oContentText.toString();

                // 返回区域内单元格的个数
                int excount = app.get_Cells().get_Range("A1","E8").get_Count();

                // 获取指定单元格内的函数
                Object of = app.get_Columns().get_Range("A1","a1").get_FormulaArray();
                System.out.println(of);



                menuPanel.updteText("test","选定单元格的字体样式："+s+"\n"+"选定单元格内的文本："+sContentText+"\n"+"A1单元格内的函数："+of+
                        "\n"+"选定单元格内的函数："+smacth);
            }
        });

        menuPanel.addArea("常用","text","提交后输出区域");



        menuPanel.addButton("常用", "关闭", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.get_ActiveWorkbook().Close(false, Variant.getMissing(), Variant.getMissing(), DEFAULT_LCID);
            }
        });

       /* menuPanel.addButton("常用", "获取版本", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String version = String.valueOf(app.get_Build(DEFAULT_LCID));
                JOptionPane.showMessageDialog(null, version);
            }
        });*/
    }


    private void initRibbon(){

        /*menuPanel.addButton("功能区", "隐藏/显示-功能区", new ActionListener() {
            private boolean visible = false;
            @Override
            public void actionPerformed(ActionEvent e) {
            	// windows企业版要2020年11月以后的版本才支持IWindowEx接口
                com.wps.api.tree.et.Window win = app.get_ActiveWindow();
                IWindowEx winEx = win.queryInterface(IWindowEx.class);
                winEx.put_ShowRibbon(visible);
                visible = !visible;
            }
        });

        menuPanel.addButton("功能区", "禁用/启用-剪切按钮", new ActionListener() {
            private boolean enabled = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                // windows企业版要2020年11月以后的版本才支持SetEnabledMso函数
                app.get_CommandBars().SetEnabledMso("Cut", enabled);
                enabled = !enabled;
            }
        });*/

        /*menuPanel.addButton("功能区", "隐藏/显示-剪切按钮", new ActionListener() {
            private boolean visible = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                // windows企业版要2020年11月以后的版本才支持SetVisibleMso函数
                app.get_CommandBars().SetVisibleMso("Cut", visible);
                visible = !visible;
            }
        });*/
    }

    /*private void initFrameListener() {
        if (!Platform.isWindows())
            return;

        final JPanel thiz = this;
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame p = (JFrame) SwingUtilities.getWindowAncestor(thiz);
                p.addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowClosing(WindowEvent arg0) {
                        if (app != null) {
                            app.Quit();
                        }
                    }
                });
            }
        });
    }*/
}
