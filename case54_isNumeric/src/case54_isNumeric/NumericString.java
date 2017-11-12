package case54_isNumeric;

/**
 * 题目：表示数值的字符串。请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串“+100”，“5e2”，“-123”，“3.1416”
 * 以及“-1E-16”都表示数值。但是“12e”，“1a3.14”，“1.2.3”，“12e+5.4”都不是。
 * 
 * @author WangSai
 *
 */
public class NumericString {

	public static void main(String[] args) {
		String[] arr1 = { "+100", "-100", "100", "-1.2", "-1.2e+2", "-1.2e-2", "-e3", ".2" };
		for (int i = 0; i < arr1.length; i++) {
			System.out.println("true:+" + isNumeric(arr1[i]));
		}
		String[] arr2 = { "+", "-+", "-100+2", "-1.2e", "-1.2e1.2", "-1.2e-2.2" };
		for (int i = 0; i < arr2.length; i++) {
			System.out.println("false:+" + isNumeric(arr2[i]));
		}
	}

	/**
	 * 
	 * @param str,待处理的字符串
	 * @return 是否是表示数值的字符串
	 */
	private static boolean isNumeric(String str) {
		// null 或者空字符串
		if (str == null || str.length() <= 0) {
			return false;
		}
		int len = str.length();
		// 字符串长0角标
		int index = 0;
		if (str.charAt(index) == '+' || str.charAt(index) == '-')
			index++;
		if (index >= len)
			return false;
		// 扫描数字,并返回扫描到第一个非数字的字符的角标
		// 符号位之后出现整数，小数点，e/E，都可以
		index = scanDigit(str, index);
		// 纯数字
		if (index >= len)
			return true;
		if (index < len) {
			// .2 或者 +.2 或者 +.e2的情况
			if (str.charAt(index) == '.') {
				index++;
				if (index > len)
					return false;
				index = scanDigit(str, index);
				// 纯小数
				if (index >= len)
					return true;
				// 小数点之后是科学计数法
				if (str.charAt(index) == 'e' || str.charAt(index) == 'E')
					return isExp(str, index);
			}
			// 科学计数法
			else if (str.charAt(index) == 'e' || str.charAt(index) == 'E') {
				return isExp(str, index);
			} else
				return false;
		}
		return false;
	}

	// 是不是科学计数法
	private static boolean isExp(String str, int index) {
		if (str.charAt(index) != 'e' && str.charAt(index) != 'E') {
			return false;
		}
		index++;
		if (index >= str.length())
			return false;
		if (str.charAt(index) == '+' || str.charAt(index) == '-')
			index++;
		if (index >= str.length())
			return false;
		index = scanDigit(str, index);
		if (index < str.length())
			return false;
		else
			return true;
	}

	// 扫描字符串中的数字，并返回遇到的第一个不是数字的字符的角标
	private static int scanDigit(String str, int index) {
		while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9')
			index++;
		return index;
	}

}
