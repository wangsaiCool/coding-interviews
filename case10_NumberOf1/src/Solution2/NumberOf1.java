package Solution2;

import java.util.Scanner;

public class NumberOf1 {

	public static void main(String[] args) {
		// 获取键盘输入，并转换为数字
		// Scanner sc = new Scanner(System.in);
		// String inputStr = sc.nextLine();
		// Integer num = Integer.valueOf(inputStr);
		int num = Integer.MAX_VALUE;
		num = Integer.MIN_VALUE;
		System.out.println(num);
		// 左移标志位，与num做位运算
		int flag = 1;
		int count = 0, times = 0;
		while (flag != 0) {
			if ((num & flag) != 0) {
				count++;
			}
			flag <<= 1;
			++times;
		}
		System.out.println(times);
		System.out.println(count);
	}

}
