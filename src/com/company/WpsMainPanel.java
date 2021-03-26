package com.company;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import com.sun.jna.platform.win32.COM.util.annotation.ComObject;
import com.wps.api.tree.ex.WindowEx;
import com.wps.api.tree.ex._ApplicationEx;
import com.wps.api.tree.ex._DocumentEx;
import com.wps.api.tree.kso.*;
import com.wps.api.tree.kso.events._CommandBarButtonEvents;
import com.wps.api.tree.wps.*;
import com.wps.api.tree.wps.ClassFactory;
import com.wps.api.tree.wps.Font;
import com.wps.api.tree.wps.KsoOfdServiceProviderType;
import com.wps.api.tree.wps.events.ApplicationEvents4;
import com.wps.runtime.WpsComObject;
import com.wps.runtime.utils.Platform;
import com.wps.runtime.utils.WpsArgs;
import com4j.EventCookie;
import com4j.Holder;
import com4j.Variant;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.awt.WindowIDProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.peer.ComponentPeer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.System;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.HashMap;

import static com.wps.api.tree.wps.WdCharacterCase.wdTitleSentence;
import static com.wps.api.tree.wps.WdCompareDestination.wdCompareDestinationNew;
import static com.wps.api.tree.wps.WdGranularity.wdGranularityWordLevel;
import static com.wps.api.tree.wps.WdHeaderFooterIndex.wdHeaderFooterFirstPage;
import static com.wps.api.tree.wps.WdHeaderFooterIndex.wdHeaderFooterPrimary;
import static com.wps.api.tree.wps.WdInformation.*;


/**
 * Project              :   Java API Examples
 * Comments             :   WPS文字标签页面，包含一个左侧标签栏（LeftMenuPanel）和右侧的wps显示区域（OfficePanel）
 * JDK version used     :   JDK1.8
 * Author               :   Kingsoft
 * Create Date          :   2019-12-09
 * Version              :   1.0
 */
public class WpsMainPanel extends JPanel {

   static private LeftMenuPanel menuPanel;
   static private OfficePanel officePanel;
   static private Application app = null;
   static private EventCookie cookie = null;
   static private EventCookie cookie2 = null;
   private static Logger logger = LoggerFactory.getLogger(WpsMainPanel.class);
   static private CommandBarControl control = null;
   static private JTextArea jTextArea;
   static private JPanel panel;
    static private JFrame jf;
   private CharUitl charUitl;
   private ExamPanel examPanel;


    public WpsMainPanel() {
        this.setLayout(new BorderLayout());
        menuPanel = new LeftMenuPanel();
        officePanel = new OfficePanel();
        this.add(menuPanel, BorderLayout.WEST);
        this.add(officePanel, BorderLayout.CENTER);
        initNormalMenu();           //常用接口




    }

    public static String getPath(String title, int type){
        FileDialog dialog = new FileDialog((JFrame)null, title, type);
        dialog.setVisible(true);
        if(dialog.getDirectory() == null || dialog.getFile() == null)
            throw new RuntimeException("选择的文件不能为空!");
        return dialog.getDirectory() + dialog.getFile();
    }


    private void initWindow(){
        new WpsWindow();
    }

    private void initNormalMenu(){
        //new WpsWindow();

        WpsUtil wpsUtil = new WpsUtil();


        menuPanel.addButton("常用", "打开试题", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Canvas client = officePanel.getCanvas();
                if (app != null) {
                    if(null != app.get_ActiveWindow()){
                        // app.get_ActiveDocument().Close(false, Variant.getMissing(), Variant.getMissing());
                        // JOptionPane.showMessageDialog(client,"已经初始化过，不需要重新初始化！");
                        app.get_ActiveDocument().get_Content().put_Text(wpsUtil.wpsContentText);
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

                        System.out.println("wpsid:"+nativeWinId);
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
//                args.setCrypted(false); //wps2016需要关闭加密
                app = ClassFactory.createApplication();
                app.put_Visible(true);
                // // 初始化完成之后新建文档
                app.get_Documents().Add(Variant.getMissing(), Variant.getMissing(), Variant.getMissing(), Variant.getMissing());

                app.get_ActiveDocument().get_Content().put_Text(wpsUtil.wpsContentText);

            }
        });


        /*menuPanel.addButton("常用", "创建新文档", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.get_Documents().Add(Variant.getMissing(), Variant.getMissing(), Variant.getMissing(), Variant.getMissing());
            }
        });*/



        /*
        menuPanel.addButton("常用", "关闭", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.get_ActiveDocument().Close(false, Variant.getMissing(), Variant.getMissing());

            }
        });
        */

        menuPanel.addArea("常用","123",wpsUtil.wpsRequirement);


        menuPanel.addButton("常用","提交" , new ActionListener(){

            public void actionPerformed(ActionEvent e){
                /*// 获取全部文本内容
                String text = app.get_ActiveDocument().get_Content().get_Text();

                // 获取全部文本颜色
                //String color = app.get_ActiveDocument().get_Content().get_Font().get_Color().name();

                // 获取全部文本字体大小
                Float fontSize = app.get_ActiveDocument().get_Content().get_Font().get_Size();

                // 获取文本字符串间距
                Float spacing = app.get_ActiveDocument().get_Content().get_Font().get_Spacing();

                // 待定：段落文本对齐方式(error：始终类型不匹配)
                String s = app.get_ActiveDocument().get_Paragraphs().get_Alignment().name();


                Section item = app.get_ActiveDocument().get_Sections().Item(1);
                int se = app.get_ActiveDocument().get_Sections().get_Count();
                //判断页眉是否存在
                boolean exists = item.get_Headers().Item(WdHeaderFooterIndex.wdHeaderFooterPrimary).get_Exists();

                System.out.println(exists);
               // 获取页眉内容
                String text1 = item.get_Headers().Item(WdHeaderFooterIndex.wdHeaderFooterPrimary).get_Range().get_Text().trim();

                System.out.println(text1);

                String nameFarEast2 =item.get_Headers().Item(WdHeaderFooterIndex.wdHeaderFooterPrimary).get_Range().get_Font().get_NameFarEast();
                Float size = item.get_Headers().Item(WdHeaderFooterIndex.wdHeaderFooterPrimary).get_Range().get_Font().get_Size();
                System.out.println(size);
                String name = item.get_Headers().Item(WdHeaderFooterIndex.wdHeaderFooterPrimary).get_Range().get_ParagraphFormat().get_Alignment().name();
                if(name.equals("wdAlignParagraphCenter")){
                    name = "居中";
                }else{
                    name = "no";
                }



                // 文档中有多少段落（获取值比实际段落值多一）
                int outLineCount = app.get_ActiveDocument().get_Content().get_Paragraphs().get_Count();
                String paragraphsCount = app.get_ActiveDocument().get_Content().get_Paragraphs().Item(2).toString();
                System.out.println(paragraphsCount);
                System.out.println(outLineCount);
                String textContent = app.get_ActiveDocument().get_Content().get_Paragraphs().Item(2).get_Range().get_Text();
                System.out.println(textContent);


                // 指定段落字体大小
                float titleStyle =  app.get_ActiveDocument().get_Content().get_Paragraphs().Item(1).get_Range().get_Font().get_Size();

                // 获取标题等级
                String titleName =  app.get_ActiveDocument().get_Content().get_Paragraphs().Item(41).get_OutlineLevel().name();
                String titleText =  app.get_ActiveDocument().get_Content().get_Paragraphs().Item(43).get_Range().get_Text();
                //System.out.println(outLineLevel);
                System.out.println(titleText);
                String text1 = app.get_ActiveDocument().get_Sections().Item(1).get_Headers().Item(WdHeaderFooterIndex.wdHeaderFooterPrimary).get_Range().get_Text().trim();

                // 返回文档中总共有几页
                Object s = app.get_ActiveDocument().get_Sections().Item(1).get_Footers().Item(WdHeaderFooterIndex.wdHeaderFooterPrimary).get_Range().get_Information(wdNumberOfPagesInDocument);


                String text1 = app.get_ActiveDocument().get_Sections().Item(1).get_Footers().Item(WdHeaderFooterIndex.wdHeaderFooterPrimary).get_Range().get_Text().trim();
                Object s = app.get_ActiveDocument().get_Sections().Item(1).get_Footers().Item(WdHeaderFooterIndex.wdHeaderFooterPrimary).get_Range().get_Information(wdActiveEndPageNumber);
                Object s1 = app.get_ActiveDocument().get_Sections().Item(1).get_Footers().Item(WdHeaderFooterIndex.wdHeaderFooterPrimary).get_Range().get_Information(wdActiveEndAdjustedPageNumber);
                Object s3 = app.get_ActiveDocument().get_Sections().Item(1).get_Footers().Item(WdHeaderFooterIndex.wdHeaderFooterPrimary).get_Range().get_Information(wdActiveEndAdjustedPageNumber);
                WdPageNumberStyle s2 = app.get_ActiveDocument().get_Sections().Item(1).get_Footers().Item(wdHeaderFooterPrimary).get_PageNumbers().get_NumberStyle();
                System.out.println(s.toString()+":"+s1.toString() +":"+ text1 +":"+s2 );*/
                double headerFoot = wpsUtil.headerFootStyle(app);
               double titleCount = wpsUtil.titleContentTextStyle(app);



                menuPanel.updteText("xxx","分数为："+(headerFoot+titleCount));
            }
        });

        menuPanel.addArea("常用","234","结果");

        /*menuPanel.addButton("理论", "理论试题", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                examPanel.openForm("http://1xexam.jiuhuax.com/login/index2","hello swing");
            }
        });*/

//        menuPanel.addButton("常用", "提交", new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String text = app.get_ActiveDocument().get_Content().get_Text();
//                menuPanel.addFileArea(text);
//                menuPanel.addArea("123","123",text);
//            }
//
//        });



//        menuPanel.addButton("常用", "获取文本内容", new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                String text = app.get_ActiveDocument().get_Content().get_Text();
//
//                text.replace("/[\r]/g","\r\n");
//                JOptionPane.showMessageDialog(null, "<html><body><p style='width: 200px;'>"+text+"</p></body></html>");//文本内容折行显示
//            }
//        });

//        menuPanel.addButton("常用", "判断", new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                String text = app.get_ActiveDocument().get_Content().get_Text();
//                Float text2 = app.get_ActiveDocument().get_Content().get_Font().get_Size();
//                text.replace("/[\r]/g","\r\n");
//                //String a = "111";
//                if (text != null && text.equals("111")){
//
//
//                    JOptionPane.showMessageDialog(null,"<html><body><p style='width: 200px;'>"+true+"</p></body></html>");
//
//                }else {
//                    JOptionPane.showMessageDialog(null,"<html><body><p style='width: 200px;'>"+false+"</p></body></html>");
//                }
//
//            }
//        });

//        menuPanel.addButton("常用", "获取所输入的文字是否正确", new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                String version = app.get_Build();
////                JOptionPane.showMessageDialog(null, version);
////                //返回字符串的副本，忽略前导空白和尾部空白。
//                String text = app.get_ActiveDocument().get_Content().get_Text().trim();
//                if (text.equals("123456")){
//                    JOptionPane.showMessageDialog(null,true);
//                    return;
//                }
//                JOptionPane.showMessageDialog(null,false);
//            }
//        });




//        menuPanel.addButton("常用", "获取文本内容字体大小", new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Float text = app.get_ActiveDocument().get_Content().get_Font().get_Size();
//                JOptionPane.showMessageDialog(null, "<html><body><p style='width: 200px;'>"+text+"</p></body></html>");//文本内容折行显示
//            }
//        });


  /*      menuPanel.addButton("常用", "获取文本内容字体颜色", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             WdColor  text = app.get_ActiveDocument().get_Content().get_Font().get_Color();
                JOptionPane.showMessageDialog(null, "<html><body><p style='width: 200px;'>"+text+"</p></body></html>");//文本内容折行显示
            }
        });*/
       // menuPanel.addArea("常用", "设置正文字体为宋体","wpscaozuodldlldl");
     //   jTextArea = new JTextArea(10, 10);

     //   menuPanel.add(jTextArea);


    }



}
