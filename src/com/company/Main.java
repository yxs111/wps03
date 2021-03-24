package com.company;

import com.wps.api.tree.wps.Application;
import com.wps.api.tree.wps.ClassFactory;
import com.wps.runtime.utils.Platform;
import com.wps.runtime.utils.WpsArgs;
import com4j.Variant;
import sun.awt.WindowIDProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.peer.ComponentPeer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {



    private ExamPanel examPanel;
    public static void main(String[] args) {
	// write your code here
        /*SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {*/


                JFrame mainFrame = new JFrame();


                mainFrame.setTitle("WPS JAVA接口调用演示");                       //设置显示窗口标题
                mainFrame.setSize(1524, 768);                           //设置窗口显示尺寸
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //置窗口是否可以关闭
                mainFrame.setResizable(false);//禁止缩放
                JPanel panel = new JPanel();
                // 添加面板
                mainFrame.add(panel);
                /*
                 * 调用用户定义的方法并添加组件到面板
                 */
                //LeftMenuPanel.area("常用","试题","aaaa",true);
                JTabbedPane tabbedPane = new JTabbedPane();

               // tabbedPane.add(new ExamPanel("http://1xexam.jiuhuax.com/login/index2"), "演示");
                tabbedPane.add(new WpsWindow(),"WPSwindow");
                tabbedPane.add(new WpsMainPanel(), "WPS文字");

                //tabbedPane.add(new EtMainPanel(), "WPS表格");
                tabbedPane.add(new WppMainPanel(), "WPS演示");


                mainFrame.add(tabbedPane);
                mainFrame.setVisible(true);                                     //设置窗口是否可见
                //mainFrame.setContentPane(panel);



        /*    }
        });*/
    }


}
