package algorithm;
/*
 *   algorithm
 *   Author：fjs
 *   2022-09-25
 *   11:16
 */

import javax.swing.*;

public class PanelNullLayout extends JPanel {
  JButton button;
  JTextField text;
  PanelNullLayout() {
    setLayout(null);
    button = new JButton("确定");
    text = new JTextField();
    add(text);
    add(button);
    text.setBounds(100,30,90,30);
    button.setBounds(190,30,66,30);
  }
}