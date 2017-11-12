package case53_RegularExpressionMatching;

import java.util.zip.InflaterInputStream;

/**
 * 题目：请实现一个函数用来匹配包含‘.’和‘*’的正则表达式。模式中的字符’.’表示任意一个字符，而‘*’表示它前面的字符可以出现
 * 任意次（含0次）。本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串“aaa”与模式“a.a”和“ab*ac*a”匹配，但与
 * “aa.a”及“ab*a”均不匹配。
 * 
 * 思路：首先要明确'.'确定了字符的个数为1，并且为任意；'*'可以确定它前面的字符的个数包括0次；
 * 
 * 第一种情况：
 * 
 * 当模式的第二个字符不是'*'的时候，如果字符串的第一个字符和模式串的第一个字符相等，则都向后移动一个，匹配剩下的字符串和模式
 * 串。如果不等则直接返回false；
 * 
 * 
 * 第二种情况：当模式的第二个字符是'*'的时候，这时候就稍复杂点儿，因为这时候存在不同的几种匹配方式：以字符串"aaa"与模式"ab*ac*a"匹配为例：
 * 
 * 1、如果模式串中的字符和字符串中的字符不等，且模式串的第二个字符为'*'。
 * 
 * 选择只有一种：在模式串上向后移动两个字符,忽略掉b和*，因为'*'可以匹配0个字符；
 * 2、如果模式串中的字符和字符串中的字符相等，或者模式串中为'.'，并且模式串的第二个字符为'*'。这时候选择有三种情况：
 * 
 * （1）可以选择在模式串上向后移动两个字符,忽略掉b和*，因为'*'可以匹配0个字符，字符串str保持不变；
 * 
 * （2）可以选择越过'*'，'*'前的a当作有效的字符，且数量为1，str++；
 * 
 * （3）可以选择模式串pattern不变，因为‘*’前的a可以任意数量的，并且和字符串str相等，只需要str++即可；
 * 
 * @author WangSai
 *
 */
public class RegularExpressionMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "aaa";

		String pattern1 = "a.a";
		System.out.println(pattern1 + '\t' + "----" + '\t' + myMatch(input, pattern1));

		String pattern2 = "a*a";
		System.out.println(pattern2 + '\t' + "----" + '\t' + myMatch(input, pattern2));

		String pattern3 = "ab*ac*a";
		System.out.println(pattern3 + '\t' + "----" + '\t' + myMatch(input, pattern3));

		String pattern4 = "a.aa";
		System.out.println(pattern4 + '\t' + "----" + '\t' + myMatch(input, pattern4));

		String pattern5 = "aaa*";
		System.out.println(pattern5 + '\t' + "----" + '\t' + myMatch(input, pattern5));
		String pattern6 = "abbbbb*";
		System.out.println(pattern6 + '\t' + "----" + '\t' + myMatch(input, pattern6));
		String pattern7 = "aa.b";
		System.out.println(pattern7 + '\t' + "----" + '\t' + myMatch(input, pattern7));
		String pattern8 = "a*bbb";
		System.out.println(pattern8 + '\t' + "----" + '\t' + myMatch(input, pattern8));

	}

	private static boolean myMatch(String input, String pattern) {
		// 异常值检测
		if (input == null || pattern == null)
			return false;
		// 采用递归的方式实现
		return myMatchCore(input, 0, pattern, 0);
	}

	private static boolean myMatchCore(String input, int inputIndex, String pattern, int patIndex) {
		// 字符串input和模式串pattern同时结束
		if (inputIndex >= input.length() && patIndex >= pattern.length()) {
			return true;
		}
		// 字符串input未结束，但是模式串pattern结束了
		if (inputIndex < input.length() && patIndex >= pattern.length()) {
			return false;
		}
		// 模式串pattern未结束，字符串input可能结束了，也可能没结束
		// 模式串pattern 到达倒数第二个字符，并且下一个字符为‘*’
		if (patIndex + 1 < pattern.length() && pattern.charAt(patIndex + 1) == '*') {
			// 字符串input结束了
			if (inputIndex >= input.length()) {
				return myMatchCore(input, inputIndex, pattern, patIndex + 2);
			}
			// 字符串input和模式串pattern都未结束

			else {
				// 当前的pattern[parIndex]值 等于input[inputIndex]的值
				if (pattern.charAt(patIndex) == input.charAt(inputIndex) || pattern.charAt(patIndex) == '.') {
					return myMatchCore(input, inputIndex, pattern, patIndex + 2)
							|| myMatchCore(input, inputIndex + 1, pattern, patIndex + 2)
							|| myMatchCore(input, inputIndex + 1, pattern, patIndex);
				}
				// 当前的pattern[parIndex]值 不 等于input[inputIndex]的值
				else
					return myMatchCore(input, inputIndex, pattern, patIndex + 2);
			}

		}

		// 执行到这里说明，匹配串pattern第二个字符不是‘*’，我们可以知道模式串未结束。字符串input可能结束了，也可能没结束
		// 字符串已经结束
		if (inputIndex >= input.length()) {
			return false;
		}
		// 字符串未结束，模式串未结束，并且第二个字符不是‘*’
		else {
			if (input.charAt(inputIndex) == pattern.charAt(patIndex) || pattern.charAt(inputIndex) == '.')
				return myMatchCore(input, inputIndex + 1, pattern, patIndex + 1);
			else
				return false;
		}
	}
}
