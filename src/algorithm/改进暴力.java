package algorithm;
/*
 *   algorithm
 *   Author：fjs
 *   2022-09-29
 *   15:44
 */

public class 改进暴力 {
	public static void main(String[] args) {
		int[] array = {-2,1,-3,4,-1,2,1,-5,4};
		int ans = Max(array, 9);
		System.out.println(ans);
	}

	public static int Max(int[] array, int n) {
		int MaxSum = 0;
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
}

