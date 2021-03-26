package com.company;

import com.wps.api.tree.ex.DocumentWindowEx;
import com.wps.api.tree.wpp.*;
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
    //            args.setPath("/home/wps/workspace/wps_2016/build_debug/WPSOffice/office6/wpp"); //手动指定的wpp程序路径（默认调用/usr/bin/wpp）
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

                // 获取演示文稿中PPT总张数
                int i = app.get_ActivePresentation().get_Slides().get_Count();


               // float s = app.get_ActivePresentation().get_Slides().Item(2).get_Master().get_TextStyles().Item(PpTextStyleType.ppBodyStyle).get_Levels().Item(1).get_Font().get_Size();

                // 获取指定幻灯片的标题内容（Item中为第几张幻灯片）
                String sTitle = app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().get_Title().get_TextFrame().get_TextRange().get_Text();

                // 获取指定幻灯片的标题内容的字体样式（Item中为第几张幻灯片）
                String fontStyle = app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().get_Title().get_TextFrame().get_TextRange().get_Font().get_Name();
                float fontSize = app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().get_Title().get_TextFrame().get_TextRange().get_Font().get_Size();
                String fontBold = app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().get_Title().get_TextFrame().get_TextRange().get_Font().get_Bold().name();


                // 获取指定幻灯片的背景填充样式（Item中为第几张幻灯片）可以获取name也可以获取comEnumValue背景所代表的值
                // app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().Item(1).get_Fill().PresetTextured(msoTextureWovenMat);
                String presetStyle = app.get_ActivePresentation().get_Slides().Item(1).get_Background().get_Fill().get_PresetTexture().name();


                // 获取指定幻灯片的文本内容（第一个Item中为第几张幻灯片，第二个Item为第几个文本框）
                String contentText = app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().Item(2).get_TextFrame().get_TextRange().get_Text();

                System.out.println();
                menuPanel.updteText("test","第一张幻灯片的标题为："+sTitle+
                        "\n"+ "第一张幻灯片的标题的字体样式:"+"\n"+ fontStyle+
                        "\n"+"第一张幻灯片的标题的字体大小:"+"\n"+ fontSize+
                        "\n"+"第一张幻灯片的标题的字体加粗为:"+"\n"+ fontBold+
                        "\n"+"第一张幻灯片的背景填充为:"+"\n"+ presetStyle+
                        "\n"+"第一张幻灯片的第二个文本框内容为："+"\n"+ contentText
                );
            }
        });


        menuPanel.addArea("常用","text","提交后输出区域");

        menuPanel.addButton("常用", "关闭", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.get_ActivePresentation().Close();
            }
        });

        menuPanel.addButton("常用", "获取版本", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String version = app.get_Build();
                JOptionPane.showMessageDialog(null, version);
            }
        });
    }


    /*private void initRibbon(){

        menuPanel.addButton("功能区", "隐藏/显示-功能区", new ActionListener() {
            private boolean visible = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                // windows企业版要2020年11月以后的版本才支持IWindowEx接口
                DocumentWindow win = app.get_ActiveWindow();
                DocumentWindowEx winEx = win.queryInterface(DocumentWindowEx.class);
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
        });

        menuPanel.addButton("功能区", "隐藏/显示-剪切按钮", new ActionListener() {
            private boolean visible = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                // windows企业版要2020年11月以后的版本才支持SetVisibleMso函数
                app.get_CommandBars().SetVisibleMso("Cut", visible);
                visible = !visible;
            }
        });
    }*/

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
