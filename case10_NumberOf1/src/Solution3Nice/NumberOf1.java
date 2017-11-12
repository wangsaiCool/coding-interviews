package Solution3Nice;

import java.util.Scanner;

public class NumberOf1 {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// get keyboard Input

		Scanner sc = new Scanner(System.in);
		Integer num = Integer.valueOf(sc.nextLine());
		// count Number of 1
		int count = 0;
		while (num != 0) {
			num = num & (num - 1);
			count++;
		}
		// output
		System.out.println(count);
	}

}
