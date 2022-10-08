package algorithm;
/*
 *   algorithm
 *   Author：fjs
 *   2022-09-25
 *   11:15
 */


import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class PanelGridLayout extends JPanel implements Runnable {
	public int flag = 0; // 单步调试
	int[] a;
	int[] f;
	public int n = 9;
	Arrows[][] jp;
	Label[][] label;
	int ans; // 最终答案
	Vector<Integer> idx;

	PanelGridLayout() {
		// 算法
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入数据的个数：");
		n = sc.nextInt();
//		a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		a = new int[n];
		f = new int[n];

		// 算法实现
		System.out.println("请依次输入每个数：");
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		Arrays.fill(f, 0);

		int row = 4;  // 行数就是四行 固定的 两个行显示数据 两个显示箭头
		int col = n;  // 列数就是 数组的长度
		GridLayout grid = new GridLayout(row, col, 1, 10);
		setLayout(grid);
		jp = new Arrows[4][col];
		label = new Label[4][col];
		Font font = new Font("宋体", Font.BOLD, 16);  // 设置字体
		int x = 500 / n / 3 * 2; // 横坐标  这是为了使得箭头尽可能的位于中间

		// 填写数据
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0) {
					jp[i][j] = new Arrows(x, 60);
					add(jp[i][j]);
					jp[i][j].setVisible(false);
				} else if (i == 1) {
					label[i][j] = new Label();
					label[i][j].setText("	" + String.valueOf(a[j]));
					label[i][j].setBackground(Color.gray);
					label[i][j].setFont(font);
					add(label[i][j]);
				} else if (i == 2) {
					label[i][j] = new Label();
					label[i][j].setText("f[" + j + "]");
					label[i][j].setFont(font);
					add(label[i][j]);
				} else {
					label[i][j] = new Label();
					label[i][j].setText("	" + String.valueOf(f[j]));
					label[i][j].setFont(font);
					label[i][j].setBackground(Color.gray);
					add(label[i][j]);
				}
			}
		}
	}

	public void run() {
		idx = new Vector<>();
		int last = 0; // 记录上一个最大的 f[i]
		for (int i = 0; i < n; i++) {
			int cnt = 1;
			int cnt2 = 1;    // 这些参数是为了减少对集合中坐标的插入 清空 这些东西会降低程序的速度
			int cnt3 = 1;
			int cnt4 = 1;

			while (true) {
				//System.out.println(i);
				if (flag == 1) break;
				if (i == 0) {
					if (cnt2 == 1) {
						idx.add(0);
					}
					ans = a[0]; // 最终答案
					f[0] = a[0];
					jp[0][0].setVisible(true);

					label[1][0].setBackground(Color.ORANGE);
					label[3][0].setText(String.valueOf(a[0]));
					label[3][0].setBackground(Color.red);
					last = 0;
					cnt2++;
				} else {
					if (f[i - 1] < 0) {
						// 将原来标红的删除
						if (cnt <= 1) {
							for (int index : idx) {
								label[1][index].setBackground(Color.gray);
							}
							cnt++;
							idx.clear();
							idx.add(i);

						}
						f[i] = a[i];
						label[1][i].setBackground(Color.ORANGE);
					} else {
						f[i] = a[i] + f[i - 1];

						if (cnt3 == 1) {
							idx.add(i);
							cnt3++;

						}
						label[1][i].setBackground(Color.ORANGE);
					}

					if (ans < f[i]) {
						label[3][last].setBackground(Color.gray);
						label[3][i].setBackground(Color.red);
						last = i;
						ans = f[i];
					}
//					ans = Math.max(f[i], ans);
					jp[0][i - 1].setVisible(false);
					jp[0][i].setVisible(true);
					label[3][i].setText(String.valueOf(f[i]));
				}
			}
			flag = 0;
		}
		System.out.println("the answer is " + ans);
	}
}