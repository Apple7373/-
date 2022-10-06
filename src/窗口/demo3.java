package 窗口;
/*
 *   窗口
 *   Author：apple777
 *   2022-04-23
 *   21:49
 */

import java.awt.*;
import java.util.zip.GZIPOutputStream;
import javax.swing.*;

public class demo3 {
    public static void main(String[] args) {
        ComponetInWindow win = new ComponetInWindow();
        win.setBounds(100, 100, 450, 260);
        win.setTitle("常用组件");
    }
}

class ComponetInWindow extends JFrame {
    JCheckBox checkBox1, checkBox2;  //复选框
    JRadioButton radioM, radioF;    //单选按钮
    ButtonGroup group;
    JComboBox<String> comboBox;

    public ComponetInWindow() {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {
        setLayout(new FlowLayout());
        comboBox = new JComboBox<String>();
        checkBox1 = new JCheckBox("喜欢音乐");
        checkBox2 = new JCheckBox("喜欢旅游");

        group = new ButtonGroup();
        radioM = new JRadioButton("男");
        radioF = new JRadioButton("女");

        group.add(radioM);
        group.add(radioF);
        add(checkBox1);
        add(checkBox2);
        add(radioM);
        add(radioF);
        comboBox.addItem("音乐天地");
        comboBox.addItem("武术天地");
        add(comboBox);
    }
}
