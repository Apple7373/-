package algorithm;
/*
 *   algorithm
 *   Author：fjs
 *   2022-09-25
 *   14:28
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PoliceListener implements ActionListener {

	ShowLayout win;
	// 设置窗口
	public void setView(ShowLayout win) {
		this.win = win;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == win.jb) {
			// 点击鼠标了
			win.panelGrid.flag = 1;
			win.ans.setText("the ans = " + win.panelGrid.ans);
		}
	}
}
