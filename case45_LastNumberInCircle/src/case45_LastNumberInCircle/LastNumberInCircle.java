package case45_LastNumberInCircle;

import java.util.LinkedList;

/**
 * 题目：0,1,...,n-1这n个数字排成1个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 
 * @author WangSai
 *
 */
public class LastNumberInCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 40000;
		int m = 997;
		System.out.println(lastRemaining1(n, m));
	}

	/**
	 * 方法1：利用环形链表
	 * 
	 * @param n，数字的个数
	 * @param m，第m个数字
	 * @return 最后剩下的数字
	 */
	private static int lastRemaining1(int n, int m) {
		// 异常值检测
		if (n < 1 || m < 1) {
			return -1;
		}
		// 构建链表
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		// 当前数字在链表中的位置
		int index = 0;
		while (list.size() > 1) {
			// 移动m-1次，就可以到达第m个数
			for (int i = 1; i <= m - 1; i++) {
				index++;
				index %= list.size();
			}
			// 删除
			list.remove(index);
			if (index == list.size()) {
				index = 0;
			}
		}
		return list.get(0);
	}
}
