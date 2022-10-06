package algorithm;
/*
 *   algorithm
 *   Author：fjs
 *   2022-09-29
 *   15:47
 */

public class dichotomy {
	public static void main(String[] args) {
//		dichotomy d = new dichotomy();
		int[] array = {-2,100,-4,4,-1,-2,1,-5,4};
		int ans = Max(array, 0, 8);
		System.out.println(ans);
	}

	public static int Max(int[] array, int left, int right) {
		if (left == right) {
			return Math.max(array[left], 0);
		}
		int mid = left + right >> 1;
		int maxL = Max(array, left, mid);
		int maxR = Max(array, mid + 1, right);

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
}



