package com.company;

import com.wps.api.tree.wps.Application;
import com.wps.api.tree.wps.ClassFactory;
import com.wps.runtime.utils.Platform;
import com.wps.runtime.utils.WpsArgs;
import com4j.Variant;
import sun.awt.WindowIDProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.peer.ComponentPeer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WpsWindow extends  JPanel{

    static private LeftMenuPanel menuPanel;
    static private OfficePanel officePanel;
    static private Application app = null;


    public   WpsWindow(){
        // write your code here


                JFrame mainFrame = new JFrame();

                mainFrame.setLayout(new BorderLayout());
               // menuPanel = new LeftMenuPanel();
                officePanel = new OfficePanel();
               // mainFrame.add(menuPanel, BorderLayout.WEST);
                mainFrame.add(officePanel, BorderLayout.CENTER);                 //设置显示窗口标题
                mainFrame.setSize(500, 400);                           //设置窗口显示尺寸
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //置窗口是否可以关闭
                mainFrame.setResizable(true);//禁止缩放

                mainFrame.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {

                        Canvas client = officePanel.getCanvas();
                        if (app != null) {
                            if(null != app.get_ActiveWindow()){
                                JOptionPane.showMessageDialog(client, "已经初始化过，不需要重新初始化！");
                                return;
                            }
                        }
                        long nativeWinId = 0;

                        try {
                            if (Platform.isWindows()) {
                                ComponentPeer peer = client.getPeer();
                                Class<?> clsCanvasPeer = Class.forName("sun.awt.windows.WComponentPeer");
                                Method getHWnd = clsCanvasPeer.getDeclaredMethod("getHWnd");
                                getHWnd.setAccessible(true);

                                nativeWinId = (long)getHWnd.invoke(peer);

                                System.out.println(nativeWinId);
                            } else {
                                WindowIDProvider pid = (WindowIDProvider) client.getPeer();

                                Class<?> clsCanvasPeer = Class.forName("sun.awt.X11.XEmbedCanvasPeer");
                                Method removeXEmbedDropTarget = clsCanvasPeer.getDeclaredMethod("removeXEmbedDropTarget");
                                removeXEmbedDropTarget.setAccessible(true);
                                removeXEmbedDropTarget.invoke(pid);

                                Method detachChiled = clsCanvasPeer.getDeclaredMethod("detachChild");
                                detachChiled.setAccessible(true);
                                Method isXEmbedActive = clsCanvasPeer.getDeclaredMethod("isXEmbedActive");
                                isXEmbedActive.setAccessible(true);
                                Boolean isActive = (Boolean) isXEmbedActive.invoke(pid);
                                if(isActive){
                                    detachChiled.invoke(pid);
                                }

                                nativeWinId = pid.getWindow();
                            }
                        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }

                        WpsArgs args = WpsArgs.ARGS_MAP.get(WpsArgs.App.WPS);
                        //args.setPath("/home/wps/workspace/wps_2016/build_debug/WPSOffice/office6/wps"); //手动指定的wps程序路径（默认调用/usr/bin/wps）
                        //args.setPath("D:\\桌面软件安装\\爱奇艺\\Kingsoft\\WPS Office\\ksolaunch.exe"); //手动指定的wps程序路径（默认调用/usr/bin/wps）
                        //args.setPath("C:\\Users\\001\\Desktop\\年会.docx"); //手动指定的wps程序路径（默认调用/usr/bin/wps）
                        args.setWinid(nativeWinId);
                        args.setHeight(client.getHeight());
                        args.setWidth(client.getWidth());
                        app = ClassFactory.createApplication();
                        app.put_Visible(true);

                        app.get_Documents().Add(Variant.getMissing(), Variant.getMissing(), Variant.getMissing(), Variant.getMissing());


                    }

                    @Override
                    public void windowClosing(WindowEvent e) {

                    }

                    @Override
                    public void windowClosed(WindowEvent e) {


                    }

                    @Override
                    public void windowIconified(WindowEvent e) {

                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {

                    }

                    @Override
                    public void windowActivated(WindowEvent e) {


                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {

                    }
                });
                // tabbedPane.add(new ExamPanel("http://1xexam.jiuhuax.com/login/index2"), "演示");
                //tabbedPane.add(new WpsWindow(),"WPSwindow");


                //mainFrame.add(tabbedPane);
                mainFrame.setVisible(true);                                     //设置窗口是否可见
                //mainFrame.setContentPane(panel);



            }



}


