package case08_MinNumInRotatedArray;

/**
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，求输出旋转数组的最小元素。
 * 例如数组为{1,2,3,4,5}，它的一个旋转为{3,4,5,1,2},该数组的最小值为1.
 * 
 * 思路：利用二分查找的办法。
 * 
 * @author WangSai
 *
 */
public class MinNum {
	/**
	 * 
	 * @param 旋转数组
	 * @return 旋转数组的最小数字
	 */
	public static void main(String[] args) {
		MinNum mn = new MinNum();

		int[] arr = { 3, 4, 5, 6, 1, 2 };
		System.out.println(mn.getMin(arr));

		int[] arr1 = { 1, 2, 1, 1, 1 };
		System.out.println(mn.getMin(arr1));

		int[] arr2 = { 2, 2, 2, 2, 2, 2 };
		System.out.println(mn.getMin(arr2));
	}

	// 旋转数组arr的最小值。
	private int getMin(int[] arr) {
		// 检测异常情况
		// 利用二分查找从两头开始向中间查找。
		// 若arr[mid]大于等于arr[low]，则说明arr[mid]位于数组前面的子数组{3,4,5}中。（并且，最小数在其之后）；
		// 若arr[mid]小于等于arr[low]，同时，也小于arr[high]，说明arr[mid]位于数组的后半段子数组中。（并且，最小数字是它本身或在其之前）。
		// 当low与high值相差为1时，则arr[high]就是其最小值。

		// 特殊情况1：旋转数组中并未旋转数字，即是原递增数组。
		// 特殊情况2：[1,1,1,1,1,1,1,1,1,0,1,1],这种情况时arr[low]，arr[mid],arr[high]三者相同，只能用遍历的方式完成。

		// 异常情况检测
		if (arr == null || arr.length <= 0)
			throw new IllegalArgumentException("非法参数，请重新输入...");
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		while (arr[low] >= arr[high]) {
			// 结束条件
			if (high - low <= 1) {
				return arr[high];
			}
			// 二分查找
			mid = (low + high) / 2;
			// 同时考虑特殊情况2
			if (arr[low] == arr[mid] && arr[mid] == arr[high])
				return minInOrder(arr, low, high);
			if (arr[mid] >= arr[low])
				low = mid;
			else if (arr[mid] <= arr[high]) {
				high = mid;
			}
		}
		return arr[high]; // 解决特殊情况1，从第一个数字比较
	}

	// 顺序查找，遍历[low，high]
	private int minInOrder(int[] arr, int low, int high) {
		int result = arr[low];
		for (int i = low; i <= high; i++) {
			if (arr[i] < result)
				result = arr[i];
		}
		return result;
	}
}
