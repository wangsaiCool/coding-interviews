package case41_2ContinuesSquenceWithSum;

/**
 * 题目2：输入一个正数s,打印出所有和为s的连续正数序列（至少含有两个数字）。例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，
 * 所以打印出3个连续序列1~5,4~6,7~8。
 * 
 * @author WangSai
 *
 */
public class ContinuesSquenceWithSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 15;
		findMySquence(sum);
	}

	/**
	 * 
	 * @param sum，正数sum
	 */
	private static void findMySquence(int sum) {
		// 异常值检测
		if (sum < 3)
			return;
		int small = 1;
		int big = 2;
		int currentSum = small + big;
		int middle = (1 + sum) / 2;
		// 不取等于号是因为，不能出现7+7=14这种情况。
		while (small < middle) {
			while (currentSum < sum) {
				big++;
				currentSum += big;
			}
			while (currentSum > sum) {
				currentSum -= small;
				small++;
			}
			if (currentSum == sum) {
				myprint(small, big);
				currentSum -= small;
				small++;
			}
		}
	}

	private static void myprint(int small, int big) {
		for (int i = small; i <= big; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
