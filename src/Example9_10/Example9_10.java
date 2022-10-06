package Example9_10;
/*
 *   Example9_10
 *   Author：fjs
 *   2022-04-24
 *   10:08
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Example9_10 {
    public static void main(String[] args) {
        WindowMouse win = new WindowMouse();
        win.setTitle("处理鼠标事件");
        win.setBounds(10, 10, 460, 360);
    }
}

class MousePlice implements MouseListener {
    WindowMouse view;

    public void setView(WindowMouse view) {
        this.view = view;
    }

    public void mousePressed(MouseEvent e) {
        if (e.getSource() == view.button1 && e.getButton() == MouseEvent.BUTTON1) {

            WindowMouse win2 = new WindowMouse();
            win2.setTitle("创建一个新窗口");
            win2.setBounds(20, 20, 300, 300);
        } else if (e.getSource() == view.button2 && e.getButton() == MouseEvent.BUTTON1) {
            view.area.append("在按钮上按下鼠标左键\n");
            view.area.append(e.getX() + "," + e.getY() + "\n");
        } else if (e.getSource() == view && e.getButton() == MouseEvent.BUTTON1) {
            view.area.append("在窗体中按下鼠标左键\n");
            view.area.append(e.getX() + "," + e.getY() + "\n");
        }
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton && e.getSource() != view.button1) {
            view.area.append("\n鼠标进入按钮，位置：" + e.getX() + "," + e.getY() + "\n");
        }
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() >= 2) {
            view.area.setText("鼠标连击\n");    //重新设置文本 更新
        }
    }
}

class WindowMouse extends JFrame {
    JButton button1, button2;
    JTextArea area;
    MousePlice police;

    WindowMouse() {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        setLayout(new FlowLayout());
        area = new JTextArea(10, 28);
        Font font = new Font("宋体", Font.PLAIN, 15);
        area.setFont(font);
        police = new MousePlice();
        //police.setView(this);        //将当前窗口传递给police组合的窗口

        //button1 创建一个新的对话框
        button1 = new JButton("创建新窗口");
        button1.addMouseListener(police);
        addMouseListener(police);
        add(button1);

        button2 = new JButton("   按钮   ");
        button2.addMouseListener(police);
        add(button2);

        add(new JScrollPane(area));
    }
}