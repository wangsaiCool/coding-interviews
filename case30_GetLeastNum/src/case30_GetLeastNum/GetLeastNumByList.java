package case30_GetLeastNum;

import java.util.ArrayList;

public class GetLeastNumByList {

	public static void main(String[] args) {
		// 测试
		int[] arr = { 4, 5, 1, 4, 4, 7, 3, 8 };
		int k = 4;
		ArrayList<Integer> alist = getNum(arr, k);
		for (Integer num : alist)
			System.out.print(num + " ");

	}

	// 获取满足条件的最小的k个数字
	private static ArrayList<Integer> getNum(int[] arr, int k) {
		// 判断异常情况
		if (arr == null || arr.length <= 0 || arr.length < k || k <= 0)
			throw new IllegalArgumentException("非法的输入参数...");
		// 新建容器，当容器中的数小于k的时候，直接添加。
		ArrayList<Integer> alist = new ArrayList<>();
		for (int i = 0; i < k; i++)
			alist.add(arr[i]);

		// 当容器满了之后，继续从剩下的arr[]数组的取出数。若取出来的数小于alist中最大的数，则直接替换掉。
		for (int j = k; j < arr.length; j++) {
			// 获取alist中最大的数值
			int indexOfMaxValue = getMaxIndex(alist);
			int max = alist.get(indexOfMaxValue);
			// 若arr中当前的值小于alist中的最大值，则替换掉alist中的最大值
			if (arr[j] < max) {
				alist.set(indexOfMaxValue, arr[j]);
			}
		}
		return alist;
	}

	// 获取arraylist中的最大数值的角坐标
	private static int getMaxIndex(ArrayList<Integer> alist) {
		int max = alist.get(0);
		int i = 0;
		for (int j = 1; j < alist.size(); j++) {
			if (alist.get(j) > max) {
				max = alist.get(j);
				i = j;
			}
		}
		return i;
	}
}
