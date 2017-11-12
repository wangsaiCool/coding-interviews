package Solution1;

import java.util.Scanner;

public class NumberOf1 {

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		// String input_str = sc.nextLine();
		// Integer num = Integer.valueOf(input_str);
		int num = Integer.MAX_VALUE;
		num = Integer.MIN_VALUE;
		System.out.println(num);
		int count = 0;
		while (num != 0) {

			if ((num & 1) != 0) {
				count++;
			}
			num >>>= 1;

		}
		System.out.println(count);
	}

}
