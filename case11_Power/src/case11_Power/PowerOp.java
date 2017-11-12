package case11_Power;

/**
 * 题目：实现函数 double Power(double base,int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 * 
 * 该实现方法通过递归的方式完成。
 * 
 * //a^n=|—— = a^(n/2)*a^(n/2) .............................................. //
 * //....|—— = a^((n-1)/2)*a^((n-1)/2)*a....................................
 * 
 * @author WangSai
 *
 */
public class PowerOp {

	// 通过递归的方式完成
	public double Power3(double base, int exponent) {
		if (isEqual(base, 0.0) && exponent < 0)
			throw new IllegalArgumentException("非法输入参数，请重新检查...");
		// 任意数值的0次幂都是1
		if (exponent == 0)
			return 1.0;
		// 当指数exponent为负数时，先计算以exponent绝对值为幂的值，然后取倒数。
		if (exponent < 0) {
			return 1 / powerByRe(base, -exponent);
		}
		// 当指数exponent为正数
		else {
			return powerByRe(base, exponent);
		}

	}

	// 采用递归的方式完成exponent次幂的计算。
	private double powerByRe(double base, int exponent) {
		if (exponent == 0)
			return 1;
		if (exponent == 1)
			return base;
		double result = powerByRe(base, exponent >> 1);
		result *= result;
		// 如果指数n为奇数，则要再乘一次底数base
		if ((exponent & 1) == 1)
			result *= base;
		return result;
	}

	// 在判断底数base是不是等于0时，不能直接写base==0， 这是因为在计算机内表示小数时（包括float和double型小数）都有误差。
	private boolean isEqual(double num1, double num2) {
		if (num1 - num2 > -0.000001 && num1 - num2 < 0.000001)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		PowerOp p = new PowerOp();
		double base = 1.0;
		int exponent = 0;
		System.out.println(base + "^" + exponent + "：  " + p.Power3(base, exponent));
		double base1 = 5.0;
		int exponent1 = 2;
		System.out.println(base1 + "^" + exponent1 + "：  " + p.Power3(base1, exponent1));

		double base3 = 5.0;
		int exponent3 = -2;
		System.out.println(base3 + "^" + exponent3 + "：  " + p.Power3(base3, exponent3));

		double base4 = -2.0;
		int exponent4 = -2;
		System.out.println(base4 + "^" + exponent4 + "：  " + p.Power3(base4, exponent4));

		double base5 = 0.0;
		int exponent5 = -2;
		System.out.println(base5 + "^" + exponent5 + "：  " + p.Power3(base5, exponent5));
	}
}
