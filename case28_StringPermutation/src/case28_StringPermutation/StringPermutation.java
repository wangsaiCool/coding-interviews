package case28_StringPermutation;

import java.util.HashSet;

/**
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
 * 
 * @author WangSai
 *
 */
public class StringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcdefg";
		myPermutation(str);
	}

	private static void myPermutation(String input) {
		// 空字符串""和null不是同一个东西
		if (input == null || input.length() < 1) {
			return;
		}
		// 去重复字符串
		HashSet<String> hs = new HashSet<>();
		// 为了便于处理把字符串转换成字符数组
		char[] arr = input.toCharArray();
		myPermutationCore(arr, 0, hs);
		int count = 0;
		for (String str : hs) {
			System.out.println(str);
			count++;
		}
		// 不重复的字符串排序的种类数
		System.out.println(count);
	}

	private static void myPermutationCore(char[] arr, int index, HashSet<String> hs) {

		if (index == arr.length - 1) {
			// 停止递归，并打印出char[]数组
			StringBuffer sb1 = new StringBuffer();
			for (char i : arr) {
				sb1.append(i);
			}

			hs.add(sb1.toString());

		} else {
			for (int i = index; i < arr.length; i++) {
				swap(arr, i, index);
				myPermutationCore(arr, index + 1, hs); // abc
				swap(arr, i, index);
			}
		}
	}

	private static void swap(char[] arr, int i, int index) {
		char temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
	}
}
