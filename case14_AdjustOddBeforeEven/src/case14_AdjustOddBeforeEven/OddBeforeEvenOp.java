/**
 * 
 */
package case14_AdjustOddBeforeEven;

/**
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 优化版：把OddBeforeEven的判断条件使用函数进行解耦优化，可以完成对数组的正负数分为前后两部分，是否能被3整除分为两部分提供了可能。只需要重写解耦函数即可。
 * 
 * @author WangSai
 *
 */
public class OddBeforeEvenOp {

	public static void main(String[] args) {
		OddBeforeEvenOp oeo = new OddBeforeEvenOp();
		// test1
		int[] arr = { 1, 1, 1, 2, 3, 1, 1, 6, 6, 6, 1 };
		oeo.adjustOddEvenOp(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		// test2
		int[] arr2 = { 1, 1, 1, 3, 1 };
		oeo.adjustOddEvenOp(arr2);
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();

		// test3
		int[] arr3 = { 2 };
		oeo.adjustOddEvenOp(arr3);
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}
	}

	private void adjustOddEvenOp(int[] arr) {
		if (arr == null || arr.length <= 0)
			throw new IllegalArgumentException("输入参数非法，请检查参数...");
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			while (low < high && !isEven(arr[low])) {
				low++;
			}
			while (low < high && isEven(arr[high])) {
				high--;
			}
			if (low < high) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
		}
	}

	// 判断给定的数是不是偶数，若是偶数则返回true；否则，返回false
	private boolean isEven(int num) {
		return (num & 1) == 0;
	}
}
