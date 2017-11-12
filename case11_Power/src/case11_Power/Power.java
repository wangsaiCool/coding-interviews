package case11_Power;

/**
 * 题目：实现函数 double Power(double base,int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 * 
 * 该实现方法计算速度比较慢，需要一次一次的累乘。
 * 
 * @author WangSai
 *
 */
public class Power {

	// 1，考虑exponent为负数，0，正数的情况
	// 2,考虑base为0，e为负数的情况
	// 3，判断双精度数为0,不能用"=="，考虑其小于某一个0.000001即为0.0
	/**
	 * 
	 * @param base，基数
	 * @param exponent，指数
	 * @return 基数的指数次幂
	 */
	public double PowerBaseExponent(double base, int exponent) {
		// 0的负数次幂
		if (isEqual(base, 0.0) && exponent < 0)
			throw new IllegalArgumentException("非法的输入参数，请重新检查...");
		// 任意数的0次幂
		if (exponent == 0)
			return 1.0;
		// 若指数为负数，则转换为绝对值之后，按照正指数进行计算，然后1/result
		if (exponent < 0) {
			int absExponent = -exponent;
			return 1 / powerWithUnsignedE(base, absExponent);
		}
		return powerWithUnsignedE(base, exponent);

	}

	// 计算指数为正整数的情况
	private double powerWithUnsignedE(double base, int absExponent) {
		double result = 1.0;
		for (int i = 1; i <= absExponent; i++)
			result *= base;
		return result;
	}

	// 在判断底数base是不是等于0时，不能直接写base==0， 这是因为在计算机内表示小数时（包括float和double型小数）都有误差。
	private boolean isEqual(double a, double b) {
		if ((a - b < 0.0000001) && (a - b > -0.0000001))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Power p = new Power();
		double base = 1.0;
		int exponent = 0;
		System.out.println(base + "^" + exponent + "：  " + p.PowerBaseExponent(base, exponent));
		double base1 = 5.0;
		int exponent1 = 2;
		System.out.println(base1 + "^" + exponent1 + "：  " + p.PowerBaseExponent(base1, exponent1));

		double base3 = 5.0;
		int exponent3 = -2;
		System.out.println(base3 + "^" + exponent3 + "：  " + p.PowerBaseExponent(base3, exponent3));

		double base4 = -2.0;
		int exponent4 = -2;
		System.out.println(base4 + "^" + exponent4 + "：  " + p.PowerBaseExponent(base4, exponent4));

		double base5 = 0.0;
		int exponent5 = -2;
		System.out.println(base5 + "^" + exponent5 + "：  " + p.PowerBaseExponent(base5, exponent5));
	}
}
