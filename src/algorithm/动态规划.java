package algorithm;
/*
 *   algorithm
 *   Author：fjs
 *   2022-10-03
 *   22:01
 */


import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;

public class 动态规划 {
	public static void main(String[] args) {
		int[] array = {-2,1,-4,4,-1,-2,1,-5,4};
		int ans = method_dp(array);
		System.out.println(ans);
	}
	public static int method_dp(int[] arr) {
		int n = arr.length;
		int[] f = new int[n];
		int ans = arr[0];
		f[0] = arr[0];
		for (int i = 1; i < n; i++) {
			f[i] = Math.max(f[i-1] + arr[i], arr[i]);
			ans = Math.max(f[i], ans);
		}
		return ans;
	}
}
