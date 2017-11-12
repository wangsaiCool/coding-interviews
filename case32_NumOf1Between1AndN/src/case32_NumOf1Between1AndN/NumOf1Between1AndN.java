package case32_NumOf1Between1AndN;

/**
 * 题目要求：
 * 
 * 输入一个整数n，求1到n这n个整数的十进制表示中1出现的次数。例如输入12,从1到12这些整数 中包含1的数字有1,10,11,12,1 一共出现了5次。
 * 
 * @author WangSai
 *
 */
public class NumOf1Between1AndN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 999000900;
		System.out.println("solution1:");
		long time1 = System.currentTimeMillis();
		int m = getNumOf1From1ToN_solution2(n);
		long time2 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(m);
		System.out.println("solution2:");

		long time3 = System.currentTimeMillis();
		int p = getNumOf1From1ToN_solution1(n);
		long time4 = System.currentTimeMillis();
		System.out.println(time4 - time3);
		System.out.println(p);
	}

	/**
	 * 方法1：从1到n中，统计每个数字中1出现的次数，然后，把所有的次数累加起来。时间复杂度O(nlogn)
	 * 
	 * @param n，最后一个数字n
	 * @return 1出现的总次数
	 */
	public static int getNumOf1From1ToN_solution1(int n) {
		// 异常值检测
		if (n < 1)
			return -1;
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += getNumOf1Ofn(i);
		}
		return sum;
	}

	/**
	 * 统计i中1出现的次数
	 * 
	 * @param i，待统计的数字
	 * @return 1在i中出现的次数
	 */
	private static int getNumOf1Ofn(int i) {
		int count = 0;
		while (i > 0) {
			if (i % 10 == 1)
				count++;
			i /= 10;
		}
		return count;
	}

	/**
	 * 方法2：根据n分为个位和其他位，[round-weight-former]，该方法的时间算法复杂度为O(logn)
	 * 
	 * @param n
	 * @return
	 */
	public static int getNumOf1From1ToN_solution2(int n) {
		// 异常值检测
		if (n < 1)
			return 0;
		// 把n分为个位和其他位
		int round = n;
		int count = 0;
		int base = 1;
		while (round > 0) {
			// 取余，获取weight
			int weight = round % 10;
			// 获取round
			round /= 10;
			// 若weight为0
			count += round * base;
			// 判断weight的值，若等于1，则加上former的值，再加1
			if (weight == 1) {
				count += n % base + 1;
			}
			// 若weight>1，则加上base
			else if (weight > 1) {
				count += base;
			}
			// 基数乘以10，向高位移动一位
			base *= 10;
		}
		return count;
	}
}
