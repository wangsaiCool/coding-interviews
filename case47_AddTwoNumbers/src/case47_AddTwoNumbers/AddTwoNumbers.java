package case47_AddTwoNumbers;

/**
 * 题目：写一个函数，求两个整数之和，要去在函数体内不得使用+ - * / 四则运算符号。
 * 
 * 思路：如果是十进制的处理方法：
 * 
 * 第1步：两个数做不进位的加法，如 5+17= （5+7=2）+（0+10=10）=12。 第2步：处理进位，5+7，进位为10。
 * 第3步：把第一步和第二步的结果加起来，即可以得到我们所要求的结果。
 * 
 * 处理二进制：第1步：等效于二进制中的异或效果。第2步：两个数字按位求与之后，左移一位即可以得到进位。第3步，把第一步和第二步的结果求和，即重复前面的值，
 * 直到不产生进位为止。
 * 
 * @author WangSai
 *
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		int num1 = 16;
		int num2 = 97;
		System.out.println("getMySum(" + num1 + "," + num2 + ")  =" + '\t' + getMySum(num1, num2));
		num1 = 16;
		num2 = -97;
		System.out.println("getMySum(" + num1 + "," + num2 + ")  =" + '\t' + getMySum(num1, num2));
	}

	/**
	 * 不用加减乘除做加法
	 * 
	 * @param num1,被加数
	 * @param num2,加数
	 * @return num1与num2的和
	 */
	private static int getMySum(int num1, int num2) {
		int sum = 0;
		int carry = 0;
		do {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		} while (num2 != 0);

		return num1;
	}

}
