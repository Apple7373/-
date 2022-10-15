package project;
/*
 *   algorithm
 *   Author：fjs
 *   2022-10-08
 *   8:49
 */

import javax.swing.*;
import java.awt.*;
import java.nio.file.FileAlreadyExistsException;
import java.sql.Time;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;
import java.util.Vector;


public class ViolenceMethod extends JPanel implements Runnable {

	public int flag = 0; // 单步调试
	int[] a;
	int[] f;
	public int n = 9;
	Arrow[][] jp;
	Label[][] label;
	int ans; // 最终答案
	Vector<Integer> idx;
	int MaxSum = 0, curSum;

	ViolenceMethod() {
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

		int row = 3;  // 行数就是四行 固定的 两个行显示数据 两个显示箭头
		int col = n;  // 列数就是 数组的长度
		GridLayout grid = new GridLayout(row, col, 1, 10);
		setLayout(grid);
		jp = new Arrow[4][col];
		label = new Label[4][col];
		Font font = new Font("宋体", Font.BOLD, 16);  // 设置字体
		int x = 500 / n / 3 * 2; // 横坐标  这是为了使得箭头尽可能的位于中间

		// 填写数据
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0) {
					jp[i][j] = new Arrow(x, 60);
					add(jp[i][j]);
					jp[i][j].setVisible(false);
				} else if (i == 1) {
					label[i][j] = new Label();
					label[i][j].setText("	" + String.valueOf(a[j]));
					label[i][j].setBackground(Color.gray);
					label[i][j].setFont(font);
					add(label[i][j]);
				} else if (i == 2) {
					jp[i][j] = new Arrow(x, 60);
					add(jp[i][j]);
					jp[i][j].setVisible(false);
				}
			}
		}
	}

	public void run() {
		idx = new Vector<>();
//		System.out.println("afadfkasjlfas");
		int last = 0; // 记录上一个最大的 f[i]
		MaxSum = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			jp[0][i].setVisible(true);   // 起始位置
			jp[0][i].setBackground(Color.white);
			for (int j = i; j < n; j++) {
				jp[0][j].setVisible(true);  // 终止位置
				jp[0][j].setBackground(Color.white);
				curSum = a[i];
				for (int k = i; k <= j; k++) {
					if (k != i)
						curSum = curSum + a[k];
					while (true) {
						// 处理在k==j时 的cursum重新置零的问题
//						System.out.println("cursum = " + curSum);
						if (flag == 1) break;
						// 当区间只有一个元素时，j==i
						if (j == i || k == i)
						{
							jp[0][i].setBackground(Color.pink);
							continue;
						}
						if (k > i) jp[0][i].setBackground(Color.WHITE);
						if (k == i + 1) {
							jp[0][k].setBackground(Color.pink);
							jp[0][k].setVisible(true);
						}
						else {
							jp[0][k].setBackground(Color.pink);
							jp[0][k - 1].setVisible(false);
							jp[0][k].setVisible(true);
						}
						if (flag == 1) break;  // 多次检测
					}
					flag = 0;
				}
//				System.out.println("here");

				MaxSum = Math.max(MaxSum, curSum);
				curSum = a[i];
				// 等待一个按键更新Maxsum
				while (flag != 0) {
				}
//				System.out.println("here1");
				flag = 0;
				while (true) {
//					curSum = a[i];
					System.out.println("");
					if (flag == 1) break;
					if (j != i)
						jp[0][j].setVisible(false);
					if (flag == 1) break;
					System.out.println("");
				}
//				System.out.println("跳出第二层循环");
				flag = 0;
				System.out.println("");
			}
			while (true) {
				curSum = 0;
				if (flag == 1) break;
//				System.out.println("进入第三层循环");
				jp[0][i].setVisible(false);
				if (flag == 1) break;
			}
//			System.out.println("跳出第三层循环");
			flag = 0;
		}
		System.out.println("the final answer is " + MaxSum);
	}
}
