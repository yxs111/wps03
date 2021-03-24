package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LeftMenuPanel02 extends JPanel {
    private JTextArea jTextArea;
    private Map<String, JPanel> panels = new HashMap<>();
    public LeftMenuPanel02() {
        this.setLayout(new BorderLayout());
        jTextArea = new JTextArea();
        jTextArea.setPreferredSize(new Dimension(350, 300));
        this.add(jTextArea);
    }
}
