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

import java.math.BigDecimal;
import java.util.HashMap;

import static com.wps.api.tree.wps.WdCharacterCase.wdTitleSentence;
import static com.wps.api.tree.wps.WdCompareDestination.wdCompareDestinationNew;
import static com.wps.api.tree.wps.WdGranularity.wdGranularityWordLevel;
import static com.wps.api.tree.wps.WdHeaderFooterIndex.wdHeaderFooterFirstPage;
import static com.wps.api.tree.wps.WdHeaderFooterIndex.wdHeaderFooterPrimary;
import static com.wps.api.tree.wps.WdInformation.*;
import static com.wps.api.tree.wps.WdPageNumberStyle.wdPageNumberStyleNumberInCircle;


/**
 * Project              :   Java API Examples
 * Comments             :   WPS???????????????????????????????????????????????????LeftMenuPanel???????????????wps???????????????OfficePanel???
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
        initNormalMenu();           //????????????




    }

    public static String getPath(String title, int type){
        FileDialog dialog = new FileDialog((JFrame)null, title, type);
        dialog.setVisible(true);
        if(dialog.getDirectory() == null || dialog.getFile() == null)
            throw new RuntimeException("???????????????????????????!");
        return dialog.getDirectory() + dialog.getFile();
    }


    private void initWindow(){
        new WpsWindow();
    }

    private void initNormalMenu(){
        //new WpsWindow();

        WpsUtil wpsUtil = new WpsUtil();

        BigDecimalUtil count = new BigDecimalUtil();

        menuPanel.addButton("??????", "????????????", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Canvas client = officePanel.getCanvas();
                if (app != null) {
                    if(null != app.get_ActiveWindow()){
                        // app.get_ActiveDocument().Close(false, Variant.getMissing(), Variant.getMissing());
                        // JOptionPane.showMessageDialog(client,"????????????????????????????????????????????????");
                        app.get_ActiveDocument().get_Content().put_Text(wpsUtil.wpsContentText);
                        // ????????????????????????????????????0??????
                        app.get_ActiveDocument().get_Sections().Item(1).get_Footers().Item(wdHeaderFooterPrimary).get_PageNumbers().put_NumberStyle(wdPageNumberStyleNumberInCircle);
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
                //args.setPath("/home/wps/workspace/wps_2016/build_debug/WPSOffice/office6/wps"); //???????????????wps???????????????????????????/usr/bin/wps???
                //args.setPath("D:\\??????????????????\\?????????\\Kingsoft\\WPS Office\\ksolaunch.exe"); //???????????????wps???????????????????????????/usr/bin/wps???
                //args.setPath("C:\\Users\\001\\Desktop\\??????.docx"); //???????????????wps???????????????????????????/usr/bin/wps???
                //args.setPath("C:/Program Files (x86)/Microsoft Office");
                args.setWinid(nativeWinId);
                args.setHeight(client.getHeight());
                args.setWidth(client.getWidth());
//                args.setCrypted(false); //wps2016??????????????????
                app = ClassFactory.createApplication();
                app.put_Visible(true);
                // // ?????????????????????????????????
                app.get_Documents().Add(Variant.getMissing(), Variant.getMissing(), Variant.getMissing(), Variant.getMissing());

                app.get_ActiveDocument().get_Content().put_Text(wpsUtil.wpsContentText);

                // ??????????????????????????????????????????
                app.get_ActiveDocument().get_Sections().Item(1).get_Footers().Item(wdHeaderFooterPrimary).get_PageNumbers().put_NumberStyle(wdPageNumberStyleNumberInCircle);

            }
        });


        menuPanel.addArea("??????","123",wpsUtil.wpsRequirement);


        menuPanel.addButton("??????","??????" , new ActionListener(){

            public void actionPerformed(ActionEvent e){


                BigDecimal headerFoot = wpsUtil.headerFootStyle(app);
                BigDecimal titleCount = wpsUtil.titleContentTextStyle(app);
                BigDecimal firstPage = wpsUtil.firstPage(app);
                BigDecimal max =  count.addThree(headerFoot,titleCount,firstPage);

                menuPanel.updteText("xxx","????????????"+max);
            }
        });

        menuPanel.addArea("??????","234","??????");


    }



}
