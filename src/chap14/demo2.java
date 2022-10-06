package chap14;
/*
 *   chap14
 *   Author：fjs
 *   2022-05-09
 *   11:12
 */


import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.concurrent.ForkJoinPool;

public class demo2 {
    public static void main(String[] args) {
        JFrame win1 = new JFrame();
        win1.setSize(900,600);
        win1.add(new MyCanvs());
        win1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win1.setVisible(true);
    }
}

class MyCanvs extends JPanel {
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g_2d = (Graphics2D) g;
        Ellipse2D ellipse = new Ellipse2D.Double(450,300,300,200);
        AffineTransform trans = new AffineTransform();
        for (int i = 1; i < 24; i++) {
            trans.translate(i*3,i*2);
            trans.rotate(i*1.0*Math.PI / 180, 430 ,330);
            trans.scale(0.5,0.5);
            g_2d.setTransform(trans);
            g_2d.draw(ellipse);
        }
    }
}
