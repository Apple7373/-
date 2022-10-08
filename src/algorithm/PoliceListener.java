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
	Layout ly = null;
	// 设置窗口
	public void setView(Object obj) {
		if (obj instanceof midJpanel) {
			this.mj = (midJpanel) obj;
		}
		else if (obj instanceof ShowLayout) {
			this.sl = (ShowLayout) obj;
		}
		else if (obj instanceof Layout) {
			this.ly = (Layout) obj;
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
				sl.MaxSum.setText("MaxSum = " + sl.panelGrid.MaxSum);
			}
		}
		else if (ly != null) {
			if (e.getSource() == ly.jb1) {
				System.out.println("发生鼠标");
				ShowLayout show = new ShowLayout();
				show.setBounds(400,100, 900,600);
			}
			else if (e.getSource() == ly.jb2) {
				System.out.println("发生鼠标");
				midJpanel mj01 = new midJpanel();
				mj01.setBounds(400,100,900,600);
			}
		}
	}
}
