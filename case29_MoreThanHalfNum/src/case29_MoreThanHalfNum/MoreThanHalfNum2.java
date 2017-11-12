package case29_MoreThanHalfNum;

/**
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现5次，超过数组长度的一半，一次输出2。异常处理，不满足条件时输出-1
 * 
 * @author WangSai
 *
 */
public class MoreThanHalfNum2 {
	/**
	 * @param 数组
	 * @return 出现次数超过数组一半的数字
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3 };
		System.out.println(moreThanHalf(arr));
	}

	// 出现次数超过数组一半的数字
	private static int moreThanHalf(int[] arr) {
		// 检测异常情况
		if (arr == null || arr.length <= 0)
			throw new RuntimeException("输入的数组非法...");
		// 假设arr[0]就是次数超过一半的值
		int result = arr[0];
		// 记录出现的次数
		int times = 1;
		// 过滤掉出现次数低于一半的数
		for (int i = 1; i < arr.length; i++) {
			if (times == 0) {
				result = arr[i];
				times = 1;
			} else if (arr[i] == result) {
				times++;
			} else {
				times--;
			}
		}
		return checkMoreThanHalf(arr, result);
	}

	// 检测输入获得的数字的次数，是否超过数组长度的一半。
	private static int checkMoreThanHalf(int[] arr, int result) {
		int times = 0;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == result)
				times++;
		}
		if (times * 2 > arr.length)
			return result;
		else
			// return -1;
			throw new RuntimeException("输入的数组非法...");
	}

}
