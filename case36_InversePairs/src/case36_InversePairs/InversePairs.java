package case36_InversePairs;

/**
 * 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这两个数组中的逆序对的总数。
 * 
 * @author WangSai
 *
 */
public class InversePairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 3, 2, 1, 4, 0 };
		System.out.println("traverseArray:" + traverseArray(arr));
		int[] arr2 = { 3, 2, 1, 4, 0 };
		System.out.println("myCount:" + myCount(arr2));
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");

		}
	}

	/**
	 * 方法1：遍历数组的方式
	 * 
	 * @param arr，待查找的数组
	 * @return 数组中的逆序对的总数
	 */
	private static int traverseArray(int[] arr) {
		if (arr == null || arr.length <= 0)
			return -1;
		int len = arr.length;
		if (len == 1)
			return 0;
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j])
					count++;
			}
		}
		return count;
	}

	/**
	 * 采用归并的方法统计逆序对数
	 * 
	 * @param arr，待统计的数组
	 * @return 数组中的逆序对数
	 */
	private static int myCount(int[] arr) {
		// 异常值检测
		if (arr == null || arr.length <= 0) {
			return -1;
		}
		return myCountCore(arr, 0, arr.length - 1);
	}

	/**
	 * 递归统计逆序对数
	 * 
	 * @param arr,待查找的数组
	 * @param low，当前数组的最左侧角标
	 * @param high，当前数组的最右侧角标
	 * @return 左侧数组和右侧数组两个数组的逆序对数
	 */
	private static int myCountCore(int[] arr, int low, int high) {
		if (low >= high)
			return 0;
		int middle = (low + high) / 2;
		int left = myCountCore(arr, low, middle);
		int right = myCountCore(arr, middle + 1, high);
		int merge = mergeCount(arr, low, middle, high);
		return merge + left + right;
	}

	private static int mergeCount(int[] arr, int low, int middle, int high) {
		int copy[] = new int[arr.length];
		// 从最高角标开始合并
		int index = high;
		int endL = middle;
		int endR = high;
		int count = 0;
		// 统计左右两个数组，并合并
		while (endL >= low && endR >= middle + 1) {
			if (arr[endL] > arr[endR]) {
				count += endR - middle;
				copy[index--] = arr[endL--];

			} else
				copy[index--] = arr[endR--];
		}
		// 合并剩下的数组
		while (endL >= low) {
			copy[index--] = arr[endL--];
		}
		while (endR >= middle + 1) {
			copy[index--] = arr[endR--];
		}
		for (int i = low; i <= high; i++) {
			arr[i] = copy[i];
		}
		return count;
	}

}
