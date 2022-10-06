package 窗口;
/*
 *   窗口
 *   Author：apple777
 *   2022-04-23
 *   21:12
 */

import javax.swing.*;

public class demo2 {
    public static void main(String[] args) {
        WindowMenu win = new WindowMenu("带菜单的窗口", 20, 30, 600, 290);
    }
}

class WindowMenu extends JFrame {
    JMenuBar manubar;
    JMenu menuFruit;
    JMenuItem bananaItem, pearItem;
    JMenu appleMenu;
    JMenuItem reaAppleItem, yellowAppleItem;

    public WindowMenu() {}

    public WindowMenu(String s, int x, int y, int w, int h) {
        init(s);
        setLocation(x, y);
        setSize(w, h);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    void init(String s) {
        setTitle(s);
        manubar = new JMenuBar();
        menuFruit = new JMenu("水果菜单");
        bananaItem = new JMenuItem("香蕉");
        bananaItem.setIcon(new ImageIcon("d:\\xiangjiao.png"));
        pearItem = new JMenuItem("甜梨");
        pearItem.setIcon(new ImageIcon("d:\\li.png"));
        appleMenu = new JMenu("苹果");
        reaAppleItem = new JMenuItem("红苹果");
        reaAppleItem.setIcon(new ImageIcon("d:\\hongpingguo.png"));
        yellowAppleItem = new JMenuItem("黄苹果");
        yellowAppleItem.setIcon(new ImageIcon("d:\\huangpingguo.png"));

        menuFruit.add(bananaItem);
        menuFruit.add(pearItem);
        menuFruit.addSeparator();
        menuFruit.add(appleMenu);
        appleMenu.add(reaAppleItem);
        appleMenu.add(yellowAppleItem);

        manubar.add(menuFruit);
        setJMenuBar(manubar); //在窗口中放置菜单条
    }
}
