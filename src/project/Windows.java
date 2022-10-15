package project;
/*
 *   algorithm
 *   Author：fjs
 *   2022-10-08
 *   14:54
 */


import javax.swing.*;
import java.awt.*;

public class Windows extends JFrame {
	JButton jb1;
	JButton jb2;
	JButton jb3;
	PoliceListener pl;
	Windows() {

		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints c = null;


		jb1 = new JButton("暴力算法");
		jb2 = new JButton("动态规划算法");
		jb3 = new JButton("请选择演示算法");


		// jb3
		c = new GridBagConstraints();
		c.ipady = 4;
		c.ipadx = 50;
		c.insets = new Insets(5,5,5,5);
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		gridBag.addLayoutComponent(jb3, c);

		// jb1
		c = new GridBagConstraints();
		c.ipady = 4;
		c.ipadx = 50;
		c.insets = new Insets(5,5,5,5);
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.CENTER;
		// gridbag中设计组件
		gridBag.addLayoutComponent(jb1, c);

		// jb2
		c = new GridBagConstraints();
		c.insets = new Insets(5,5,5,5);
		c.ipady = 4;
		c.ipadx = 50;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.CENTER;
		gridBag.addLayoutComponent(jb2, c);


		// 将gridbag加入到jpanel中
		JPanel panel = new JPanel(gridBag);
		// 将组件加入到panel中显示 这里必须要加入 不能之加入到gridbag中
		panel.add(jb3);
		panel.add(jb1);
		panel.add(jb2);

		setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);

		pl = new PoliceListener();
		pl.setView(this);
		jb1.addActionListener(pl);
		jb2.addActionListener(pl);
		setBounds(450,200,450,450);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
