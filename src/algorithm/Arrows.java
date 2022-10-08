package algorithm;
/*
 *   algorithm
 *   Author：fjs
 *   2022-09-25
 *   11:17
 */


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Arrows extends JPanel { // 箭头
	int x, y;
	Arrows(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g_2d = (Graphics2D)g;
		g_2d.setStroke(new BasicStroke(3.0f));
		Line2D L = new Line2D.Double(x,y,x,y + 50);
		Line2D L2 = new Line2D.Double(x,y+50, x-8, y+42);
		Line2D L3 = new Line2D.Double(x,y+50, x+8, y+42);

		g_2d.setColor(Color.red);
		g_2d.draw(L2);
		g_2d.draw(L3);
		g_2d.draw(L);
	}
}
