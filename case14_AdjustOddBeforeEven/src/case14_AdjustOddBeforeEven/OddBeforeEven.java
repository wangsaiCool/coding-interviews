package case14_AdjustOddBeforeEven;

/**
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 思路：使用两个指针，第一个指针plow指向数组第一个元素，用于向数组后半部分移动；第二个指针phigh指向数组最后一个元素，用于向数组前半部分移动。
 * 调整plow指向下一个为偶数的元素，调整phigh指向前一个为奇数的元素，交换两个指针指向的元素。
 * 
 * @author WangSai
 *
 */
public class OddBeforeEven {

	// 调整数组元素
	private void adjustOddEven(int[] arr) {
		// 异常处理
		if (arr == null || arr.length <= 0)
			throw new IllegalArgumentException("输入参数非法，请重新检查...");
		// plow角标指向前半部分的偶数，初始化的时候指向数组第一个元素
		int plow = 0;
		// phigh角标指向后半部分的奇数,初始化的时候指向数组最后一个元素
		int phigh = arr.length - 1;
		while (plow < phigh) {
			// plow角标指向前半部分的偶数
			while (plow < phigh && ((arr[plow] & 1) == 1)) {
				plow++;
			}
			// phigh角标指向后半部分的奇数
			while (plow < phigh && ((arr[phigh] & 1) == 0)) {
				phigh--;
			}
			if (plow < phigh) {
				int temp = arr[plow];
				arr[plow] = arr[phigh];
				arr[phigh] = temp;
			}
		}
	}

	public static void main(String[] args) {
		OddBeforeEven oe = new OddBeforeEven();
		// test1
		int[] arr = { 1, 1, 1, 2, 3, 1, 1, 6, 6, 6, 1 };
		oe.adjustOddEven(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
		// test2
		int[] arr2 = { 1, 1, 1, 3, 1 };
		oe.adjustOddEven(arr2);
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]);
		}
		System.out.println();

		// test3
		int[] arr3 = { 2 };
		oe.adjustOddEven(arr3);
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i]);
		}
		System.out.println();
	}

}
