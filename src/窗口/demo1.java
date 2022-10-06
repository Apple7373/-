package 窗口;
/*
 *   窗口
 *   Author：apple777
 *   2022-04-23
 *   20:49
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.jar.JarEntry;

public class demo1 {
    public static void main(String[] args) {
        new ShowLayout();
    }
}

class ShowLayout extends JFrame {
    JButton jButton;
    JButton jButton1;
    JTextArea area;
    public ShowLayout() {
        jButton = new JButton("北京");
        jButton1 = new JButton("上海");

        jButton.setBounds(20,20,10,50);
        jButton.setSize(50,50);
//        area = new JTextArea();
//        area.setText("北京欢迎你!");
//        JPanel jPanel = new JPanel();
//        jPanel.setLayout(new BorderLayout());
//        jPanel.add(jButton,BorderLayout.CENTER);
//        JScrollPane jScrollPane = new JScrollPane(area);
//        jPanel.add(jScrollPane, BorderLayout.NORTH);
//
//
//        //JPanel jPanel = new JPanel();
//        JTabbedPane jtab = new JTabbedPane();
//        jtab.add("one",jPanel);
//        jtab.add("two",jButton1);
//        setLayout(new BorderLayout());
//        jButton.setText("北京");
//        jButton1.setText("上海");

       // JSplitPane jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jButton,jButton1);
        add(jButton,BorderLayout.NORTH);
       // add(jButton1, BorderLayout.NORTH);
        setSize(300,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }
}
