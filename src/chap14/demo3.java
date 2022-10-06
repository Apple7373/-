package chap14;
/*
 *   chap14
 *   Author：fjs
 *   2022-05-09
 *   11:30
 */


import org.xml.sax.helpers.AttributeListImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class demo3 {
    public static void main(String[] args) {
        JFrame win = new JFrame();
        win.setSize(1000,600);
        win.add(new CanvasMoon());
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win.setVisible(true);
    }
}

class CanvasMoon extends JPanel {
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g_2d = (Graphics2D) g;
        Rectangle rect = new Rectangle(0,0,500,300);
        g_2d.setColor(Color.black);
        g_2d.fill(rect);

        Ellipse2D moon = new Ellipse2D.Double(100,100,200,200);
        Ellipse2D earth = new Ellipse2D.Double(170,100,320,320);
        Area moonArea = new Area(moon);
        Area eatthArea = new Area(earth);

        g_2d.setColor(Color.white);
    }
}

