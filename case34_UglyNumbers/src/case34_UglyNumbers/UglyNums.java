package case34_UglyNumbers;

/**
 * 题目：我们把只包含因子2、3 和5 的数称作丑数（Ugly Number）。求从小到大的顺序的第1500个丑数。 思路：逐个判断每个整数是不是丑数
 * 
 * @author WangSai
 *
 */
public class UglyNums {

	public static void main(String[] args) {
		UglyNums myUg = new UglyNums();
		System.out.println(myUg.getUglyNums(1));
	}

	// 依次判断从1开始的每个数字是不是丑数
	private int getUglyNums(int index) {
		if (index <= 0)
			return -1;
		int numbers = 0;
		int uglyCount = 0;
		while (uglyCount < index) {
			numbers++;
			if (isUgly(numbers))
				uglyCount++;
		}
		// 返回丑数
		return numbers;
	}

	// 计算某一个数字是不是丑数
	private boolean isUgly(int number) {
		while (number % 2 == 0)
			number /= 2;
		while (number % 3 == 0)
			number /= 3;
		while (number % 5 == 0)
			number /= 5;
		return number == 1;
	}

}
