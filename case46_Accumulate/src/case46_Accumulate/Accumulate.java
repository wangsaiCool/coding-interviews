package case46_Accumulate;

/**
 * 题目：求1+2+3+...+n,要求不能使用乘除法，for，while，if，else，switch,case等关键字及条件判断语句(A?B:C)。
 * 
 * @author WangSai
 *
 */
public class Accumulate {

	public static void main(String[] args) {
		int num = 2;
		System.out.println(mySum(num));
	}

	/**
	 * 思路：递归+&&
	 * 
	 * 用&&来实现条件判断；
	 * 
	 * 用递归实现累加
	 * 
	 * &&两侧的表达式结果必须为boolean型，所有&&右侧要用一个无关变量a判断是否与result相等，让右侧的表达式返回boolean型。
	 * 不管返回的是true还是false，我们的目的仅仅是让&&右侧的表达式执行。
	 * &&连接的表达式，必须要将最终的boolean结果赋给变量，否则编译报错！
	 * 
	 * @param args
	 */
	public static int mySum(int n) {
		int result = n;
		int a = 0;
		boolean value = (n > 0) && (a == (result += mySum(n - 1)));
		return result;
	}
}
