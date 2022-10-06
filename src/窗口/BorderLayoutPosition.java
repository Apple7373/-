package 窗口;
/*
 *   窗口
 *   Author：fjs
 *   2022-04-25
 *   19:52
 */


import javax.swing.*;
import java.awt.*;
import java.io.StringReader;

public class BorderLayoutPosition extends JFrame {
  String[] border = { BorderLayout.CENTER, BorderLayout.NORTH, BorderLayout.SOUTH,
    BorderLayout.WEST, BorderLayout.EAST};
  String[] buttonName = { "center", "north", "south", "west", "east"};
  public BorderLayoutPosition() {
    setTitle("边界布局管理器");
    Container c = getContentPane();
    setLayout(new BorderLayout());
    for (int i = 0; i < border.length; i++) {
      c.add(border[i], new JButton(buttonName[i]));
    }

    setSize(350, 220);
    setVisible(true);

    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
  }
  public static void main(String[] args) {
    new BorderLayoutPosition();
  }
}
