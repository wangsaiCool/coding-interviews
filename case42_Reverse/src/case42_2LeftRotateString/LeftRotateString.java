package case42_2LeftRotateString;

/**
 * 题目2：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如输入字符串“abcdefg”和数字2,，
 * 该函数将返回旋转2位得到的结果“cdefgab”。
 * 
 * @author WangSai
 *
 */
public class LeftRotateString {

	public static void main(String[] args) {
		String input = "abcdefg";
		int num = 7;
		System.out.println(myRotate1(input, num));
		System.out.println(myRotate2(input, num));
	}

	/**
	 * 方法1：借助容器stringbuffer
	 * 
	 * @param input，待处理的字符串
	 * @param num，翻转字符的数量
	 * @return 翻转之后的字符串
	 */
	private static String myRotate1(String input, int num) {
		// 异常检测
		if (input == null || input.length() < num || num < 0)
			return null;
		// 左旋字符串，先用容器把两个子串保存起来
		StringBuffer sb1 = new StringBuffer(input.substring(0, num));
		StringBuffer sb2 = new StringBuffer(input.substring(num, input.length()));
		// 交换他们的保存顺序
		return sb2.toString() + sb1.toString();
	}

	/**
	 * 方法2： 翻转每个子串 abcdefg ,翻转后： ba gfedc。 旋转整个字符串,翻转后cdefg ab
	 * 
	 * @param input，待处理的字符串
	 * @param num，旋转的字符数
	 * @return 旋转之后的字符串
	 */
	private static String myRotate2(String input, int num) {
		// 异常值检测
		if (input == null || input.length() < num || num < 0) {
			return null;
		}
		if (input.length() == num)
			return input;
		char[] arr = input.toCharArray();
		// 翻转每个子串 abcdefg ,翻转后： ba gfedc
		reverseWord(arr, 0, num - 1);
		reverseWord(arr, num, input.length() - 1);
		// 旋转整个字符串,翻转后cdefg ab
		reverseWord(arr, 0, input.length() - 1);
		StringBuffer sb1 = new StringBuffer();
		for (char i : arr) {
			sb1.append(i);
		}
		return sb1.toString();

	}

	private static void reverseWord(char[] arr, int left, int right) {
		for (int i = 0; i < arr.length; i++) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
		}
	}

}
