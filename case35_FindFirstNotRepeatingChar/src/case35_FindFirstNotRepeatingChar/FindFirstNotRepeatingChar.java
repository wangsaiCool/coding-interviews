package case35_FindFirstNotRepeatingChar;

import java.util.LinkedHashMap;

/**
 * 题目：在字符串中找出第一个只出现一次的字符。如输入“abaccdeff”，则输出‘b’
 * 
 * @author WangSai
 *
 */
public class FindFirstNotRepeatingChar {

	// 方法1：使用双列集合,HashMap<K,V>
	private char findTheChar(String str) {
		// 异常处理
		if (str == null)
			return 0;
		// throw new IllegalArgumentException("非法参数，请重新检查...");
		LinkedHashMap<Character, Integer> hp = new LinkedHashMap<>();
		char[] charArr = str.toCharArray();
		// 遍历字符数组，把字符作为键，出现次数作为值记录。
		for (int i = 0; i < charArr.length; i++) {
			// 如果不包含键，则把对应的值设为1
			if (!hp.containsKey(charArr[i]))
				hp.put(charArr[i], 1);
			// 若包含对应的键，则在键对应的原值上+1
			else
				hp.put(charArr[i], hp.get(charArr[i]) + 1);
		}
		// 初始化字符
		char theChar = '\u0000';
		// 迭代HashMap，若出现第一个值为1的键，则该键即为第一个出现的字符,并返回该字符。
		for (char as : hp.keySet()) {

			if (hp.get(as) == 1) {
				return as;
			}
		}
		return theChar;
	}

	/**
	 * 方法2：
	 * 
	 * 自己创建哈希值容器，即数组。char大小为一个字节，范围为0-255，所以创建大小为256的容器。
	 * 
	 * 数组角标和char一一对应。
	 * 
	 * 数组中的内容1，保存每个字符第一次出现的位置,2，初始化时为-1。3，重复出现时置为-2
	 */

	private char findTheChar2(String str) {
		if (str == null)
			throw new IllegalArgumentException("非法输入参数，请重新检查...");
		int[] arr = new int[256];
		// arr初始值为-1
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		int len = str.length();
		// 遍历str
		for (int i = 0; i < len; i++) {
			// str中的字符对应的int值作为数组角标，即哈希值
			int c = (int) str.charAt(i);
			// 数组内容为str中的角标i
			// -1说明没出现过
			if (arr[c] == -1) {
				arr[c] = i;
			}
			// 否则出现过，置为-2
			else {
				arr[c] = -2;
			}
		}
		// 遍历处理完之后的arr，获取最小的角标
		char theChar = 0;
		int minIndex = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			// 数组中的内容为-1或者-2，说明出现过0次或者多次。
			if (arr[i] < 0) {
				continue;
			}
			// 出现过一次的字符
			else {
				if (arr[i] < minIndex)
					// 数组arr的角标即是对应的字符
					theChar = (char) i;
				// arr[i]的内容保存的是字符串的角标
				minIndex = arr[i];
			}
		}
		return theChar;
	}

	public static void main(String[] args) {
		test2();
		test3();
		test4();
		test1();
	}

	// 字符串位null
	private static void test1() {
		String str = null;
		FindFirstNotRepeatingChar ffnrc = new FindFirstNotRepeatingChar();
		System.out.println(str + '\t' + "    1满足条件的字符：   " + ffnrc.findTheChar(str));
		System.out.println(str + '\t' + "    2满足条件的字符：   " + ffnrc.findTheChar2(str));
	}

	// 字符串只有1个字符
	private static void test2() {
		String str = "a";
		FindFirstNotRepeatingChar ffnrc = new FindFirstNotRepeatingChar();
		System.out.println(str + '\t' + "    1满足条件的字符：   " + ffnrc.findTheChar(str));
		System.out.println(str + '\t' + "    2满足条件的字符：   " + ffnrc.findTheChar2(str));
	}

	// 字符串中全部为重复字符
	private static void test3() {
		String str = "aaaaaaaa";
		FindFirstNotRepeatingChar ffnrc = new FindFirstNotRepeatingChar();
		System.out.println(str + '\t' + "    1满足条件的字符：   " + ffnrc.findTheChar(str));
		System.out.println(str + '\t' + "    2满足条件的字符：   " + ffnrc.findTheChar2(str));
	}

	// 普通字符串
	private static void test4() {
		String str = "aaedbcf";
		FindFirstNotRepeatingChar ffnrc = new FindFirstNotRepeatingChar();
		System.out.println(str + '\t' + "    1满足条件的字符：   " + ffnrc.findTheChar(str));
		System.out.println(str + '\t' + "    2满足条件的字符：   " + ffnrc.findTheChar2(str));
	}
}
