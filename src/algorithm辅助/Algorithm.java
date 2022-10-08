package algorithm辅助;
/*
 *   algorithm
 *   Author：fjs
 *   2022-09-25
 *   11:14
 */

import java.util.Arrays;
import java.util.Scanner;

public class Algorithm implements Runnable{
	public int flag = 0; // 单步调试
	int[] a;
	int[] f;
	public int n = 9;
	Algorithm() {
//		method();
	}
	public void run() {
		Scanner sc = new Scanner(System.in);
//		System.out.println("请输入数据的个数：");
//		n = sc.nextInt();
		a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		f = new int[n];

		// 算法实现
//		System.out.println("请依次输入每个数：");
//		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		Arrays.fill(f, 0);
		int ans = a[0]; // 最终答案
		f[0] = a[0];

		for (int i = 1; i < n; i++) {
			while (true) {
				System.out.println(i);
				f[i] = Math.max(a[i], f[i-1] + a[i]);
				ans = Math.max(f[i], ans);
				if (flag == 1) break;
			}
			flag = 0;
		}
		System.out.println("the answer is " + ans);
	}
}
