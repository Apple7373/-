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

//	Object win;
	midJpanel mj = null;
	ShowLayout sl = null;

	// 设置窗口
	public void setView(Object obj) {
		if (obj instanceof midJpanel) {
			this.mj = (midJpanel) obj;
		}
		else if (obj instanceof ShowLayout) {
			this.sl = (ShowLayout) obj;
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (mj != null) {
			if (e.getSource() == mj.jb) {
				// 点击鼠标了
				mj.panelGrid.flag = 1;
				mj.MaxSum.setText("the ans = " + mj.panelGrid.ans);
			}
		}
		else if (sl != null) {
//			pass
			if (e.getSource() == sl.jb) {
				System.out.println("除法鼠标事件");
				sl.panelGrid.flag = 1;
				System.out.println("panelGrid中flag = " + sl.panelGrid.flag);
				sl.curSum.setText("curSum = " + sl.panelGrid.curSum);
			}
		}
	}
}
