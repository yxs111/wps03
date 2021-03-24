package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Project              :   Java API Examples
 * Comments             :   界面左侧第一列标签栏，栏中每一个标签按钮对应一类接口，切换标签时，切换第二列标签栏中对应的接口按钮。维护一个Map，创建时标签数量和内容从Map中动态获取
 * JDK version used     :   JDK1.8
 * Author               :   Kingsoft
 * Create Date          :   2019-12-09
 * Version              :   1.0
 */
public class LeftMenuPanel extends JPanel {
 ;
    private JTabbedPane tabbedPane;
    private JTextArea jTextArea;
    private Map<String, JPanel> panels = new HashMap<>();
    private SpringLayout layout =null;
    private int areaindex = 0;
    private int btnindex = 0;
    public LeftMenuPanel() {
        this.setLayout(new BorderLayout());
        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(300, 0));
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);
        this.add(tabbedPane);
    }

    public void addButton(String category, String name, ActionListener listener, boolean enable){
        JPanel panel = null;
        if(panels.containsKey(category)){
            panel = panels.get(category);
        }else{
            panel = new JPanel();
            panel.setLayout(new GridLayout(30,2, 0, 0));
            tabbedPane.add(category, panel);
            panels.put(category, panel);
        }
        JButton button = new JButton(name);
        button.setEnabled(enable);
        button.addActionListener(listener);
        if(layout == null ) {
            layout = new SpringLayout();
            panel.setLayout(layout);
        }

        SpringLayout.Constraints labelCons = layout.getConstraints(button);  // 从布局中获取指定组件的约束对象（如果没有，会自动创建）
        labelCons.setX(Spring.constant(5));
        labelCons.setY(Spring.constant(5+btnindex));
        labelCons.setConstraint(
                SpringLayout.EAST ,Spring.sum(
                        labelCons.getConstraint(SpringLayout.WEST  ),
                        Spring.constant(230)
                )
        );
        btnindex+=30;

        panel.add(button);
    }

    public   void area(String category, String name, String text, boolean enable){

        JPanel panel = new JPanel();
        JFrame jf = new JFrame();



        jTextArea = new JTextArea(text,20,20);
       // System.out.println(jTextArea.getText());


//        jTextArea.setForeground(Color.red);
//        Font f = new Font("华文彩云",Font.BOLD,20);
//        jTextArea.setFont(f);
//        jTextArea.setEnabled(enable);



        //String changedText = jTextArea.getText();

         panel.add(jTextArea);
         jf.setContentPane(panel);
         //jf.setVisible(true);


         if(panels.containsKey(category)){
             panel = panels.get(category);
         }
         if(layout == null ) {
             layout = new SpringLayout();
             panel.setLayout(layout);
         }

        SpringLayout.Constraints labelCons = layout.getConstraints(jTextArea);  // 从布局中获取指定组件的约束对象（如果没有，会自动创建）
        labelCons.setX(Spring.constant(5));
        labelCons.setY(Spring.constant(5+btnindex));
        btnindex+=300;

        labelCons.setConstraint(
                SpringLayout.SOUTH,Spring.sum(
                        labelCons.getConstraint(SpringLayout.NORTH ),
                        Spring.constant(290)
                )
        );

        //jTextArea.setEnabled(enable);
        jTextArea.setLineWrap(true);
        //Dimension size = new Dimension (100,300);
        //jTextArea.setMinimumSize( size);
        //jTextArea.append(changedText);
        panel.add(jTextArea);


    }

    public void updteText(String name,String text )
    {
        jTextArea.setText(text);
    }

    public void addButton(String category, String name, ActionListener listener){
        this.addButton(category,name,listener,true);
    }

    public void addArea(String category, String name,String text){
        this.area(category,name, text, true);
    }


     //获取文字尺寸
     public   void area2(String category, String name, float size2, boolean enable){

         JPanel panel = new JPanel();
         JFrame jf = new JFrame();

         jTextArea = new JTextArea( 20,20);

         jTextArea.getFont().getSize();
         panel.add(jTextArea);
         jf.setContentPane(panel);


         if(panels.containsKey(category)){
             panel = panels.get(category);
         }

         jTextArea.setLineWrap(true);

         panel.add(jTextArea);


     }



     public void addArea2(String category, String name,float size){
         this.area2(category,name, size, true);
     }


     //弹窗
//  public void addFileArea(String string, boolean enable){
//
//        JFrame jf = new JFrame();
//        JPanel panel  = new JPanel();
//        jf.setSize(250, 250);
//        jf.setLocationRelativeTo(null);
//        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        jTextArea = new JTextArea(string,20,20);
//        System.out.println(jTextArea.getText());
//
//        jTextArea.setForeground(Color.red);
//        Font f = new Font("华文彩云",Font.BOLD,20);
//        jTextArea.setFont(f);
//        jTextArea.setEnabled(enable);
//
//        panel.add(jTextArea);
//        jf.setContentPane(panel);
//        jf.setVisible(true);
//
//    }
//    public void addFileArea(String string){
//        this.addFileArea(string,true);
//    }



}
