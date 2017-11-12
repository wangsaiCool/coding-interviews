package case65_maxInWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}。
 * 
 * @author WangSai
 *
 */
public class maxInWindow {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 2, 6, 2, 5, 1 };
		int k = 3;
		int[] temp = getMax(arr, k);
		System.out.println("所有滑动窗口最大值所组成的数组，数组里面的元素为：");
		for (int i : temp) {
			System.out.print(i + " ");
		}

		System.out.println();
		int[] arr2 = { 2 };
		int k2 = 1;
		int[] temp2 = getMax(arr2, k2);
		System.out.println("所有滑动窗口最大值所组成的数组，数组里面的元素为：");
		for (int i : temp2) {
			System.out.print(i + " ");
		}
	}

	/**
	 * 
	 * @param arr,给定的数组
	 * @param k，窗口大小
	 * @return 每个滑动窗口的最大值组成的数组
	 */
	private static int[] getMax(int[] arr, int k) {
		// 异常值检测
		if (arr == null || arr.length <= 0 || k <= 0 || arr.length < k)
			throw new IllegalArgumentException("非法输入参数...");
		// 辅助队列，保存当前窗口的最大值的角标和次大值的角标
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		// 辅助空间，保存当前窗口的最大值
		ArrayList<Integer> list = new ArrayList<>();
		// 把arr第一个元素角标压入队列里，辅助队列里保存角标是为了判断最大值是否已经出滑动窗口。如i-queue.peek()>=k
		queue.add(0);
		// 把第一个窗口填满，并且把最大值的角标存到队列里。
		for (int i = 1; i < k; i++) {
			// 若当前元素大于队列里的最大元素时，清空队列，并且把当前元素入队。
			if (arr[i] > arr[queue.peek()]) {
				if (!queue.isEmpty())
					queue.clear();
				// 把最大值角标入队列
				queue.add(i);
			}
			// 若当前元素小于等于队列尾部元素，则把当前元素放在队列尾。因为该元素可能是下一个滑动窗口的最大值，所以要把对应的角标加入到辅助队列里。
			else if (arr[i] <= arr[queue.peekLast()]) {
				queue.add(i);
			}
			// 若当前元素大于队尾元素，则队尾元素一直出栈，直到存在不小于它的数，然后把该元素角标加入队列。
			else {
				while (arr[i] > arr[queue.peek()]) {
					queue.pollLast();
				}
				queue.add(i);
			}
		}
		// 保存辅助队列第一个窗口的最大值
		list.add(arr[queue.peek()]);
		// 开始窗口滑动
		for (int i = k; i < arr.length; i++) {
			// 判断辅助队列中的最大值是否已经在窗口中滑动出去。
			if (i - queue.peek() >= k)
				queue.pollFirst();
			// 判断当前的值和队列头部的值大小,若当前值大于队列首部，即比辅助队列里的值都大
			if (arr[i] > arr[queue.peek()]) {
				queue.clear();
				queue.add(i);
			}
			// 若当前元素小于等于队列尾部元素，则把当前元素放在队列尾。
			else if (arr[i] <= arr[queue.peekLast()]) {
				queue.add(i);
			}
			// 若当前元素大于队尾元素，则队尾元素一直出栈，直到存在不小于它的数
			else {
				while (arr[i] > arr[queue.peekLast()]) {
					queue.pollLast();
				}
				queue.add(i);
			}
			// 保存辅助队列第一个窗口的最大值
			list.add(arr[queue.peek()]);
		}
		// 把角标值转换成数组元素。
		int[] temp = new int[list.size()];
		for (int i = list.size() - 1; i >= 0; i--) {
			temp[i] = list.get(i);
		}
		// 返回最大值组成的数组
		return temp;
	}
}
