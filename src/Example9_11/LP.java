package Example9_11;
/*
 *   Example9_11
 *   Author：fjs
 *   2022-04-24
 *   10:59
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class LP extends JLayeredPane implements MouseListener, MouseMotionListener {
    JButton buttonTom, buttonJerry;
    int x, y, a, b, x0, y0;

    LP() {
        buttonTom = new JButton("用鼠标拖动Tom");
        buttonTom.addMouseListener(this);
        buttonTom.addMouseMotionListener(this);
        buttonJerry = new JButton("用鼠标拖动Jerry");
        buttonJerry.addMouseListener(this);
        buttonJerry.addMouseMotionListener(this);
        setLayout(new FlowLayout());
        add(buttonTom, JLayeredPane.DEFAULT_LAYER);
        add(buttonJerry, JLayeredPane.DEFAULT_LAYER);
    }

    public void mousePressed(MouseEvent e) {
        JComponent con = (JComponent) e.getSource();
        setLayer(con, JLayeredPane.DRAG_LAYER);
        a = con.getBounds().x;
        b = con.getBounds().y;

        //开始按住鼠标，记录此时的初始位置
        x0 = e.getX();
        y0 = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
        JComponent com = null;
        com = (JComponent) e.getSource();
        setLayer(com, JLayeredPane.DEFAULT_LAYER);
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        Component com = null;
        if (e.getSource() instanceof Component) {
            com = (Component) e.getSource();
            a = com.getBounds().x;
            b = com.getBounds().y;
            x = e.getX();
            y = e.getY();
            b += y;
            a += x;
            com.setLocation(a - x0, b - y0);
        }
    }
}
