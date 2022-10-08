package algorithm;
/*
 *   algorithm
 *   Author：fjs
 *   2022-09-29
 *   14:39
 */


import java.util.Arrays;
import java.util.Scanner;

public class sumOfSub {
	public static void main(String[] args) {
//		int[] array = {-2,111,-3,4,-1,2,1,-5,4};
//		-2 111 -3 4 -1 2 1 -5 4
		System.out.print("请输入数据个数：");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		System.out.print("请依次输入每个数：");
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}

		System.out.print("请选择你要是用的算法\n " +
				"1、纯暴力算法O(n^3)\n " +
				"2、暴力算法改进O(n^2)\n " +
				"3、使用二分优化O(nlogn)\n " +
				"4、动态规划O(n)\n");
		int op = sc.nextInt();
		int ans = Integer.MIN_VALUE;
		switch (op) {
			case 1:
				ans = Sum1(array, n);
				break;
			case 2:
				ans = Sum2(array, n);
				break;
			case 3:
				ans = Sum3(array, 0, n - 1);
				break;
			case 4:
				ans = Sum4(array);
				break;
		}
		System.out.println("最大子段和：" + ans);
	}

	// 暴力算法 O(n^3)
	public static int Sum1(int[] array, int n) {
		int MaxSum = Integer.MIN_VALUE, curSum;
		if (array == null || array.length == 0)
			return MaxSum;
		else {
			for (int i = 0; i < n; i++) {
				for (int j = i; j < n; j++) {
					curSum = 0;
					for (int k = i; k <= j; k++) {
						curSum = curSum + array[k];
					}
					if (curSum > MaxSum)
						MaxSum = curSum;
				}
			}
		}
		return MaxSum;
	}

	// 暴力算法改进 O(n^2)
	public static int Sum2(int[] array, int n) {
		int MaxSum = Integer.MIN_VALUE;
		if (array.length == 0)
			return 0;
		else {
			for (int i = 0; i < n; i++) {
				int Sum = 0;
				for (int j = i; j < n; j++) {//改变结束下标的同时（j=i），进行寻找字段和（j++）。
					Sum = Sum + array[j];
					if (Sum > MaxSum) {
						MaxSum = Sum;
					}
				}
			}
		}
		return MaxSum;
	}

	// 采用二分 O(nlogn)
	public static int Sum3(int[] array, int left, int right) {
		if (left == right) {
			return Math.max(array[left], 0);
		}
		int mid = left + right >> 1;
		int maxL = Sum3(array, left, mid);
		int maxR = Sum3(array, mid + 1, right);

		int Sum1 = 0;
		int Sum_left = 0;
		for (int i = mid; i >= left; i--) {//左半部分最大子段和
			Sum1 = Sum1 + array[i];
			if (Sum_left < Sum1) {
				Sum_left = Sum1;
			}
		}

		int Sum2 = 0;
		int Sum_right = 0;
		for (int j = mid + 1; j <= right; j++) {//右半部分子段和
			Sum2 = Sum2 + array[j];
			if (Sum_right < Sum2) {
				Sum_right = Sum2;
			}
		}

		int maxM = Sum_left + Sum_right;//左右相加的子段和
		if (maxM < maxR)
			maxM = maxR;
		if (maxM < maxL)
			maxM = maxL;
		return maxM;//左、右、左+右 三部分子段和比较，取最大者
	}

	// 动态规划O(n)
	public static int Sum4(int[] arr) {
		int n = arr.length;
		int[] f = new int[n];
		Arrays.fill(f, Integer.MIN_VALUE);
		int ans = arr[0];
		f[0] = arr[0];
		for (int i = 1; i < n; i++) {
			f[i] = Math.max(f[i - 1] + arr[i], arr[i]);
			ans = Math.max(f[i], ans);
		}
		return ans;
	}
}




