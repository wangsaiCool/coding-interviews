package case42_1ReverseSentence;

import java.util.Stack;

/**
 * 题目1：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串“I am a
 * student.”， 则输出“ student. a am I ”。
 * 
 * @author WangSai
 *
 */
public class ReverseSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "   I am a student.  ";
		System.out.println("getMySentence1(str): " + getMySentence1(str));
		System.out.println("getMySentence2(str): " + getMySentence2(str));
	}

	/**
	 * 方法1：利用栈的先入后出特点处理。
	 * 
	 * @param input,待处理的字符串
	 * @return 翻转之后的字符串
	 */
	private static String getMySentence1(String input) {
		// 异常值检测
		if (input == null)
			return null;
		// 以空格为分隔符，把字符串分成多个字符，分别压入栈中。
		String[] str = input.split(" ");
		Stack<String> stack1 = new Stack<>();
		for (String mystr : str) {
			if (mystr.isEmpty())
				continue;
			stack1.push(mystr);
		}
		StringBuffer sb1 = new StringBuffer();
		// 当压入完毕之后，再依次弹出来。
		while (stack1.size() > 1) {
			sb1.append(stack1.pop());
			sb1.append(" ");
		}
		// 弹出最后一个的时候，不添加空格
		sb1.append(stack1.pop());
		return sb1.toString();
	}

	/**
	 * 方法2：对调整个字符串的高低位，然后，单词内部进行交换。
	 * 
	 * @param input,待处理的字符串
	 * @return 翻转之后的字符串
	 */
	private static String getMySentence2(String input) {
		if (input == null)
			return null;
		char[] arr = input.toCharArray();
		reverseWord(arr, 0, input.length() - 1);
		int left = 0;
		int right = 0;
		while (left < input.length()) {
			if (arr[left] == ' ') {
				left++;
				right++;
			} else if (right == input.length() || arr[right] == ' ') {
				reverseWord(arr, left, right - 1);
				right++;
				left = right;

			} else {
				right++;
			}
		}
		StringBuffer sb1 = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sb1.append(arr[i]);
		}
		return sb1.toString();

	}

	private static void reverseWord(char[] arr, int left, int right) {
		while (left < right) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
}
