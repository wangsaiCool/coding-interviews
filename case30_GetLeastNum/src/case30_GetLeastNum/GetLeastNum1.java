package case30_GetLeastNum;

/**
 * 题目：输入n个整数，找出其中最小的k个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4
 * 方法：利用partition函数完成,采用这种思路是有限制的。我们需要修改输入的数组，因为函数Partition会调整数组中数字的顺序
 * 
 * 
 * @author WangSai
 *
 */
public class GetLeastNum1 {
	/**
	 * 
	 * @param arr[]
	 *            需要被寻找的数组
	 * @return 寻找出来满足条件的k个数字
	 */
	public static void main(String[] args) {
		int[] arr = { 4, 5, 1, 4, 4, 7, 3, 8 };
		int k = 4;
		getNumbers(arr, k);
	}

	// 通过partition函数，获取arrOut数组
	private static void getNumbers(int[] arr, int k) {
		// 异常值判断
		if (arr == null || arr.length < k || arr.length <= 0 || k <= 0)
			throw new IllegalArgumentException("输入的数组非法...");
		// 采用递归的方式完成
		int low = 0;
		int high = arr.length - 1;
		int index = partition(arr, low, high);
		while (index != k - 1) {
			if (index < k - 1) {
				low = index + 1;
				index = partition(arr, low, high);
			} else {
				high = index - 1;
				index = partition(arr, low, high);
			}
		}
		// 输出满足条件的数
		for (int i = 0; i < k; i++)
			System.out.print(arr[i] + " ");
	}

	// 快排中用到的partition函数
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
