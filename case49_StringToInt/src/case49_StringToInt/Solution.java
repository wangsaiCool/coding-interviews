package case49_StringToInt;

/**
 * 题目：将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 
 * @author WangSai
 *
 */
public class Solution {

	/**
	 * 把给定的字符串转换成数字。需要考虑的问题：
	 * 
	 * 空字符，""，"+10","-100"
	 * 
	 * 
	 * @param str
	 * @return 字符串对应的整数
	 */
	public int StrToInt(String str) {
		// 异常值检测
		if (str == null || str.length() <= 0)
			return 0;
		// 标志是否是负数
		boolean isPostive = true;
		// 记录字符串的角标
		int index = 0;
		// 字符串对应的整数
		int number = 0;
		// 判断是不是带 + -的整数
		if (str.charAt(index) == '+') {
			isPostive = true;
			index++;
		} else if (str.charAt(index) == '-') {
			isPostive = false;
			index++;
		}
		// 判断是否是只有 '+' '-'的字符串
		if (index >= str.length())
			return 0;
		// 处理字符串中的数字
		while (index < str.length()) {
			if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
				number = number * 10 + str.charAt(index) - '0';
				index++;
			} else
				return 0;
		}
		// 如果是负数
		if (!isPostive)
			number = 0 - number;
		return number;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String str1 = "+";
		System.out.println(str1 + " : " + s.StrToInt(str1));
		String str2 = "+10";
		System.out.println(str2 + " : " + s.StrToInt(str2));
		String str3 = "-100";
		System.out.println(str3 + " : " + s.StrToInt(str3));
		String str4 = "10";
		System.out.println(str4 + " : " + s.StrToInt(str4));
		String str5 = "123";
		System.out.println(str5 + " : " + s.StrToInt(str5));
		String str6 = "111a2";
		System.out.println(str6 + " : " + s.StrToInt(str6));
		String str7 = "++";
		System.out.println(str7 + " : " + s.StrToInt(str7));
		String str8 = "";
		System.out.println(str8 + " : " + s.StrToInt(str8));
		String str9 = null;
		System.out.println(str9 + " : " + s.StrToInt(str9));
	}

}
