package algorithm;
/*
 *   algorithm
 *   Author：fjs
 *   2022-10-08
 *   14:54
 */


import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame {
	JButton jb1;
	JButton jb2;
	PoliceListener pl;
	Layout() {
		pl = new PoliceListener();
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.CENTER);
		setLayout(fl);
		add(new JButton("请选择算法"));
		jb1 = new JButton("暴力算法");
		jb2 = new JButton("动态规划算法");

		add(jb1);
		add(jb2);
		pl.setView(this);
		jb1.addActionListener(pl);
		jb2.addActionListener(pl);
		setBounds(450,200,450,450);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
