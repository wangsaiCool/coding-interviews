package case12_Print1ToMaxOfNDigits;

/**
 * 题目：输入n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1,2,3一直到最大的3位数999。
 * 
 * @author WangSai
 *
 */
public class Print1ToMaxOfNDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// myPrint1ToMax1(1);
		System.out.println();
		myPrint1ToMax2(1);
	}

	/**
	 * 方法1：利用数字的全排列解决
	 * 
	 * @param n，给定的数字n
	 */
	// 因为考虑到大数问题，所以用数字的全排列完成，类似于扔色子出现的所有可能的结果。
	private static void myPrint1ToMax1(int n) {
		// 异常值
		if (n <= 0)
			return;
		String str = "";
		mySeq(str, n);
	}

	/**
	 * 方法1：利用数字的全排列解决
	 * 
	 * @param str，上次保存的前几个数字的一次排列
	 * @param n，剩余未排列的数字数量
	 */
	private static void mySeq(String str, int n) {
		if (n <= 0) {
			myPrint(str);
			return;
		}
		for (int i = 0; i <= 9; i++) {
			mySeq(str + "" + i, n - 1);
		}
	}

	/**
	 * 打印str表示的数字，若前面是0则不打印，打印从第一个非0的数后面的数字
	 * 
	 * @param str，待打印的字符串
	 */
	private static void myPrint(String str) {
		int len = str.length();
		int i = 0;
		// 寻找第一个非0数字的角标
		for (i = 0; i < len; i++) {
			if (str.charAt(i) != '0')
				break;
		}
		// 打印第一个非0数字及剩下的位
		for (int j = i; j < len; j++) {
			System.out.print(str.charAt(j));
		}
		// 条件成立说明数组中有非零元素，所以需要换行
		if (i < str.length()) {
			System.out.println();
		}
	}

	/**
	 * 方法2：利用数组模拟每一个位置的数字，并且每一个位置的数字在0~9之间，不能有其他值
	 * 
	 * @param num,给定的位数
	 */
	private static void myPrint1ToMax2(int num) {
		if (num <= 0)
			return;
		// 创建辅助容器，并进行初始化。数组最左侧表示拼接之后的数字的最高位，右侧为最低位。
		int[] arr = new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}

		while (addOne(arr) == 0) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}
	}

	/**
	 * 利用数组模拟数字的加法及进位
	 * 
	 * @param arr
	 */
	public static int addOne(int[] arr) {
		// 加数值 进位值
		int carry = 1;
		// 最低位的位置的后一位
		int index = arr.length;
		do {
			// 高一位的位置
			index--;
			// 处理位置的值加上进位的值
			arr[index] += carry;
			// 进位值
			carry = arr[index] / 10;
			// 求处理位置的值
			arr[index] %= 10;
			// 有进位，且未到达最高位时，继续循环求下一个位置的值
		} while (carry != 0 && index > 0);
		// 到达最高位，并且最高位有进位位
		if (carry > 0 && index == 0)
			return 1;
		// 没有到达最高位
		return 0;
	}
}
