package chap14;
/*
 *   chap14
 *   Author：fjs
 *   2022-05-09
 *   10:48
 */


import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class demo1 {
    public static void main(String[] args) {
        JPanel jPanel = new JPanel();
//        jPanel.paint();
        JFrame win = new JFrame();
        win.setSize(400,400);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MyCanvas myCanvas = new MyCanvas();
        AffineTransform trans = new AffineTransform();
        trans.rotate(60,50,50);

        win.add(new MyCanvas());
        win.setVisible(true);
    }
}

class MyCanvas extends JPanel {
    public void paint(Graphics g) {
        super.paint(g);
        //类型转换
        Graphics2D g_2d = (Graphics2D) g;
        Arc2D arc = new Arc2D.Double(0,0,100,100,-90,-180,Arc2D.PIE); //饼形弧线
        g_2d.setColor(Color.black);
        g_2d.fill(arc); //用黑色画出饼弧
        g_2d.setColor(Color.white);
        arc.setArc(0,0,100,100,-90,180,Arc2D.PIE);
        g_2d.fill(arc);

        arc.setArc(25,0,50,50,90,180,Arc2D.PIE);
        g_2d.fill(arc);

        arc.setArc(25,50,50,50,90,-180,Arc2D.PIE);
        g_2d.setColor(Color.black);
        g_2d.fill(arc);

        Ellipse2D ellipse = new Ellipse2D.Double(40,15,20,20);
        g_2d.fill(ellipse);
        ellipse.setFrame(40,65,20,20);
        g_2d.setColor(Color.white);
        g_2d.fill(ellipse);
    }
}
