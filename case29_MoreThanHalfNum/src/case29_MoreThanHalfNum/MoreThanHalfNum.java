package case29_MoreThanHalfNum;

/**
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现5次，超过数组长度的一半，一次输出2。异常处理，不满足条件时输出-1
 * 
 * @author WangSai
 *
 */

public class MoreThanHalfNum {
	/**
	 * @param 输入的数组
	 *            array[]
	 * @return 满足条件的数字
	 */
	public static void main(String[] args) {
		int[] arr0 = { 1, 3, 3 };
		int[] arr1 = {};
		System.out.println(MoreThanHalf1(arr0));
		System.out.println(MoreThanHalf1(arr1));
	}

	// 基于Partition函数的O(n)算法
	private static int MoreThanHalf1(int[] arr) {
		// 检测异常情况
		if ((arr == null) || (arr.length < 1))
			throw new RuntimeException("输入的数组无效...");
		// 获得数组的中间坐标
		int middle = arr.length >> 1;
		// 通过partition完成数字的输出任务。
		int low = 0;
		int high = arr.length - 1;
		int index = partition(arr, low, high);
		while (index != middle) {
			if (index < middle) {
				low = index + 1;
				index = partition(arr, low, high);
			} else {
				high = index - 1;
				index = partition(arr, low, high);
			}
		}
		int result = arr[index];
		// 检测该数字出现次数是否超过一半,如果满足则放回该数字；否则，报错
		result = checkMoreThanHalf(arr, result);
		return result;
	}

	// 检测某数字在对应的数组中出现次数是否超过一半
	private static int checkMoreThanHalf(int[] arr, int result) {
		int times = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == result)
				times++;
		}
		if (times * 2 > arr.length)
			return result;
		else
			throw new RuntimeException("输入的数组无效...");
	}

	// Partition选择一个数，通过一定方法，使得该数字左侧的数字都比其小，右侧数字比其要大。返回该数字所在的位置。
	private static int partition(int[] arr, int low, int high) {
		int pivotKey = arr[low];
		while (low < high) {
			while (low < high && arr[high] >= pivotKey)
				high--;
			arr[low] = arr[high];
			while (low < high && arr[low] <= pivotKey)
				low++;
			arr[high] = arr[low];
		}
		arr[low] = pivotKey;
		return low;
	}
}
