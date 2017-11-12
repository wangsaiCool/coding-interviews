package case31_FindGreastSumOfSubArray;

import java.util.ArrayList;

/**
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(N)。
 * 
 * @author WangSai
 *
 */
public class FindGreastSumOfSubArray {

	public static void main(String[] args) {
		int[] arr = { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println("getMyGreatSum1(arr):  " + getMyGreatSum1(arr));
		System.out.println("getMyGreatSum2(arr):  " + getMyGreatSum2(arr));
	}

	/**
	 * 方法1：通过从数组头开始累加。
	 * 
	 * @param arr，要被处理的数组
	 * @return 最大子数组的和
	 */
	private static int getMyGreatSum1(int[] arr) {
		// 异常值检测
		if (arr == null || arr.length <= 0)
			throw new IllegalArgumentException("非法参数，请重新检查...");
		// 设置两个变量，currentSum保存当前子数组的和。maxSum保存最大的子数组的和。数组中有正数，所以，currentSum和maxSum最小值都会大于0
		int currentSum = Integer.MIN_VALUE;
		int maxSum = Integer.MIN_VALUE;
		// 分别保存最长子数组的两个角标
		int low = 0;
		int high = 0;

		for (int i = 0; i < arr.length; i++) {
			// 若arr[i]之前元素的子数组的和小于等于0，说明之前的子数组的和加上arr[i]不会 大于 从arr[i]开始算起的子数组的和。
			// 抛弃之前的子数组，从当前元素开始算起。
			// low是开始角标
			if (currentSum <= 0) {
				currentSum = arr[i];
				low = i;
			} else
				currentSum += arr[i];
			// 获取最大的子数组的和。子数组结束的角标
			if (currentSum > maxSum) {
				maxSum = currentSum;
				high = i;
			}
		}
		System.out.print("最大的子数组为：      ");
		for (int i = low; i <= high; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return maxSum;

	}

	/**
	 * 方法2：动态规划的方法实现
	 * 
	 * @param arr,要被处理的数组
	 * @return 最大子数组的和
	 */
	private static int getMyGreatSum2(int[] arr) {
		if (arr == null || arr.length <= 0)
			throw new IllegalArgumentException("非法参数，请重新检查...");
		ArrayList<Integer> list = new ArrayList<>();
		int currentSum = Integer.MIN_VALUE;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				list.add(arr[i]);
			} else if (currentSum <= 0) {
				list.add(arr[i]);
				currentSum = arr[i];
			} else if (currentSum > 0) {
				currentSum += arr[i];
				list.add(Math.max(currentSum, arr[i]));
			}
		}
		maxSum = list.get(0);
		for (int i : list) {
			if (i > maxSum)
				maxSum = i;
		}
		return maxSum;
	}
}
