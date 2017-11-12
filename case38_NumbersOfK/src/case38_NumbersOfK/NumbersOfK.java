package case38_NumbersOfK;

/**
 * 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 * 
 * @author WangSai
 *
 */
public class NumbersOfK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 5, 16, 16, 20 };
		int num1 = 16;
		System.out.println("1次:" + getMyTimes(arr1, num1));
		int[] arr2 = { 1, 1, 1, 1, 1, 1, 1 };
		int num2 = 1;
		System.out.println("7次:" + getMyTimes(arr2, num2));
		int[] arr3 = { 1 };
		int num3 = 1;
		System.out.println("1次:" + getMyTimes(arr3, num3));
		int[] arr4 = { 2, 2, 2, 2, 2, 2 };
		int num4 = 1;
		System.out.println("0次:" + getMyTimes(arr4, num4));
	}

	/**
	 * 获取num在arr数组中出现的次数
	 * 
	 * @param arr，待查找的数组
	 * @param num，待查找的数字
	 * @return 若数组中不存在该数字，返回-1；若存在则返回出现的次数。
	 */
	private static int getMyTimes(int[] arr, int num) {
		// 异常值检测
		if (arr == null || arr.length <= 0) {
			throw new IllegalArgumentException("非法输入参数，请重新检查...");
		}
		// 二分查找，获取num在arr中的位置
		int index = binarySearch(arr, 0, arr.length - 1, num);
		// 若index-1，说明该数字未出现。
		if (index == -1)
			return 0;
		// 查找最左侧的第一个num，并返回角标
		int firstIndex = getFirstIndexOfNum(arr, index, num);
		// 查找最右侧的最后一个num，并返回角标
		int lastIndex = getLastIndexOfNum(arr, index, num);
		// 返回num在数组中出现的次数
		return lastIndex - firstIndex + 1;
	}

	/**
	 * 获取num最后一次出现时在arr数组中对应的角标
	 * 
	 * @param arr，待查找的数组
	 * @param index，num在arr中的角标
	 * @param num，待查找的数字
	 * @return 数字num最后一次出现时在arr数组中对应的角标
	 */
	private static int getLastIndexOfNum(int[] arr, int index, int num) {
		// 若index为arr[]的最后一个角标，则直接返回index
		if (index == arr.length - 1)
			return index;
		// 若arr[index]不是最后一个元素，并且下一个元素不是num，则直接返回当前的index
		else if (arr[index + 1] != num)
			return index;
		// 在数组后半段继续查找
		int pos = binarySearch(arr, index + 1, arr.length - 1, num);
		return getLastIndexOfNum(arr, pos, num);
	}

	/**
	 * 获取 数组arr中第一次出现num时的角标，时间复杂度O(logn)
	 * 
	 * @param arr，待查找的数组
	 * @param index，num在arr中的角标
	 * @param num，待查找的数字
	 * @return 数组arr中第一次出现num时的角标
	 */
	private static int getFirstIndexOfNum(int[] arr, int index, int num) {
		// 若index为arr[]的0角标，则直接返回index
		if (index == 0)
			return 0;
		// 若arr[index]不是第一个元素，并且前一个元素不是num，则直接返回当前的index
		else if (arr[index - 1] != num) {
			return index;
		}
		// 在前半段继续查找，递归
		int pos = binarySearch(arr, 0, index - 1, num);
		return getFirstIndexOfNum(arr, pos, num);

	}

	/**
	 * 二分查找，时间复杂度O(logn)
	 * 
	 * @param arr,待查找的数组
	 * @param low
	 * @param high
	 * @param num，待查找的数字
	 * @return 查找的数字所在的角标，或者 若不存在则返回-1
	 */
	private static int binarySearch(int[] arr, int low, int high, int num) {
		while (low <= high) {
			int middle = (low + high) / 2;
			if (arr[middle] < num) {
				low = middle + 1;
			} else if (arr[middle] > num) {
				high = middle - 1;
			} else {
				return middle;
			}
		}
		return -1;
	}
}
