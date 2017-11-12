package case43_DicesProbability;

import java.util.HashMap;

/**
 * @author WangSai
 *
 */
public class DicesProbability {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 2;
		System.out.println("-------printSumProbability1(" + num + ")--------------:");
		printSumProbability1(num);
		System.out.println("-------printSumProbability2(" + num + ")--------------:");
		printSumProbability2(num);
	}

	/**
	 * 方法1： 递归调用，当前色子加上之前所有色子的sum的和。先求第一个色子的值，然后，再递归下一个的值，并求和。一直到最后一个色子
	 * 
	 * @param num，色子数量
	 */
	private static void printSumProbability1(int num) {
		if (num <= 0)
			return;
		int theSum = 0;
		// 把求到的和保存到HashMap里面，键是点数，值是出现的次数。
		HashMap<Integer, Integer> hs = new HashMap<>();
		// 递归调用下一个可能出现的情况
		myProbability2(theSum, num, hs);
		// 求出所有可能出现的情况的种数
		double allKinds = 1.0;
		for (int i = 1; i <= num; i++) {
			allKinds = allKinds * 6;
		}
		// 计算各种可能值得概率
		for (Integer sum : hs.keySet()) {
			// System.out.println(sum);
			int times = hs.get(sum);
			double ratio = times / allKinds;
			System.out.println("sum=" + sum + '\t' + ",times: " + times + '\t' + ratio);
		}
	}

	/**
	 * 
	 * @param theSum,第1个到当前色子的前1个色子的和，未包括当前色子
	 * @param num,剩余未求和色子的个数
	 * @param hs,把求到的和保存到HashMap里面，键是点数，值是出现的次数。
	 */
	private static void myProbability2(int theSum, int num, HashMap<Integer, Integer> hs) {
		// 递归终止条件,并把求到的和加入到
		if (num <= 0) {
			// 统计当前和出现的情况
			if (!hs.containsKey(theSum)) {
				hs.put(theSum, 1);
			} else {
				hs.put(theSum, hs.get(theSum) + 1);
			}
			return;
		}
		// 当前色子的可能出现的数字，并与之前的色子的和求和
		// 到达倒数第二个色子
		else if (num >= 1) {
			for (int i = 1; i <= 6; i++) {
				// 求和
				// theSum += i;
				// 递归调用下一个可能出现的情况
				myProbability2(theSum + i, num - 1, hs);

			}
		}
	}

	/**
	 * 方法2：用迭代的方法实现。用两个数组实现，数组大小为num*6+1,数组角标为已经出现过的色子的和，数组的内容为数组角标
	 * 对应的数字出现的次数。在一次循环中， 第一个数组中的第n个数字表示骰子和为n出现的次数。在下一循环中，我们加上一个新的骰子，此时和为n
	 * 的骰子出现的次数应该等于上一次循环中骰子点数和为n-1 、n-2 、n-3 、n-4, n-5 与n-6
	 * 的次数的总和，所以我们把另一个数组的第n个数字设为前一个数组对应的第n-1 、n-2 、n-3 、n-4、n-5与n-6之和。
	 * 
	 * @param num，色子数量
	 */
	private static void printSumProbability2(int num) {
		// 异常值检测
		if (num <= 0)
			throw new IllegalArgumentException("非法输入参数，请重新检查...");
		// 创建辅助容器,并初始化。
		int[][] arr = new int[2][num * 6 + 1];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = 0;
			}
		}
		// 定义标志位，用来决定用哪一个数组
		int flag = 0;
		// 只出现一个色子的时候
		for (int i = 1; i <= 6; i++) {
			// 用数组a
			arr[flag][i] = 1;
		}
		// 出现到第k个色子的情况,用另一个数组保存b
		for (int k = 2; k <= num; k++) {
			// 小于k的值, 出现次数为0
			for (int j = 0; j <= k - 1; j++)
				arr[1 - flag][j] = 0;
			// 第k个色子中和为sum出现的次数为：
			// ：前k-1个色子中和值为sun-1,sum-2,sum-2,sum-3,sum-4,sum-5,sum-6出现次数的和
			for (int sum = k; sum <= 6 * k; sum++) {
				for (int y = 1; y <= 6; y++) {
					if (sum - y >= 0)
						arr[1 - flag][sum] += arr[flag][sum - y];
				}
			}
			// 标志位取反，开始使用另一个数组。
			flag = 1 - flag;
		}
		// 计算所有和的情况
		double totalKinds = 1;
		for (int i = 1; i <= num; i++) {
			totalKinds *= 6;
		}
		System.out.println(totalKinds);
		// 遍历数组计算所有的情况
		for (int i = 0; i < arr[flag].length; i++) {
			if (arr[flag][i] > 0) {
				double ratio = arr[flag][i] / totalKinds;
				System.out.println("sum=" + i + '\t' + ",times: " + arr[flag][i] + '\t' + ratio);
			}
		}
	}

}