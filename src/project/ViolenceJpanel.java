package project;
/*
 *   algorithm
 *   Author：fjs
 *   2022-09-25
 *   11:17
 */

import javax.swing.*;
import java.awt.*;

class ViolenceJpanel extends JFrame {

	ViolenceMethod panelGrid;
	public JButton jb;
	public JButton MaxSum;
	public JButton curSum;
	PoliceListener listener;
	JPanel j;
	ViolenceJpanel() {
		curSum = new JButton("curSum = ");
		jb = new JButton("下一步");
		MaxSum = new JButton("Maxsum = ");
		listener = new PoliceListener(); // 鼠标监听器
		panelGrid = new ViolenceMethod();
		Thread a = new Thread(panelGrid);
		a.start();

		setLayout(new BorderLayout());
		j = new JPanel();
		j.setLayout(new GridLayout(1,2));
		j.add(curSum);
		j.add(MaxSum);
		add(j, BorderLayout.NORTH);
		//this.setBounds(400,200,1500,1500);
		add(panelGrid, BorderLayout.CENTER);

//		add(ans, BorderLayout.NORTH);
		// ans.addActionListener(listener);
//		add(curSum, BorderLayout.SOUTH);
		add(jb, BorderLayout.SOUTH);
		listener.setView(this);
		jb.addActionListener(listener);  // jb添加监视器

		setBounds(10, 10, 570, 390);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		validate();
	}
}
