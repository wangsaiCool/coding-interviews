package case09_Fibonacci;

/**
 * 题目：写一个函数，输入n，求斐波那契数列的第n项。
 * 
 * @author WangSai
 *
 */

public class Fibonacci {

	// 斐波那契数列定义
	// f(n)= |- =0，n=0
	//       |- =1，n=1
	//       |- =f(n-1)+f(n-2),n>=2
	public static void main(String[] args) {
		long temp = Fib1(10);
		System.out.println(temp);
		long temp2 = Fib2(10);
		System.out.println(temp2);

	}

	// 采用递归的方式完成斐波那契数列的计算,计算第n项
	private static long Fib1(int n) {
		int[] results = { 0, 1 };
		if (n < 2)
			return results[n];
		return Fib1(n - 1) + Fib1(n - 2);
	}

	// 采用迭代方式完成斐波那契数列的计算，计算第n项
	private static long Fib2(int n) {
		int[] results = { 0, 1 };
		if (n < 2)
			return results[n];
		int FIB1 = 0;
		int FIB2 = 1;
		int FIBN = 0;
		for (int i = 2; i <= n; i++) {
			FIBN = FIB1 + FIB2;
			FIB1 = FIB2;
			FIB2 = FIBN;
		}
		return FIBN;
	}

	// 采用迭代的方式，计算第n项，对Fib2进行优化，省去FIBN变量
	private long Fib3(int n) {
		if (n < 0)
			return 0;
		long num1 = 0;
		long num2 = 1;
		for (int j = 1; j <= n; j++) {	//	从1开始
			num1 = num1 + num2;
			num2 = num1 - num2;
		}
		return num1;
	}
}
