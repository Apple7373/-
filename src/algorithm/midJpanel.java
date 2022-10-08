package algorithm;
/*
 *   algorithm
 *   Author：fjs
 *   2022-10-08
 *   8:58
 */


import javax.swing.*;
import java.awt.*;

public class midJpanel extends JFrame{
	PanelGridLayout panelGrid;
	public JButton jb;
	public JButton MaxSum;
	PoliceListener listener;
	midJpanel() {
		jb = new JButton("下一步");

		MaxSum = new JButton();
		listener = new PoliceListener(); // 鼠标监听器
		panelGrid = new PanelGridLayout();
		Thread a = new Thread(panelGrid);
		a.start();

		setLayout(new BorderLayout());
		//this.setBounds(400,200,1500,1500);
		add(panelGrid, BorderLayout.CENTER);

		add(MaxSum, BorderLayout.NORTH);
		// ans.addActionListener(listener);
		add(jb, BorderLayout.SOUTH);
		listener.setView(this);
		jb.addActionListener(listener);  // jb添加监视器

		setBounds(10, 10, 570, 390);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		validate();
	}
}
