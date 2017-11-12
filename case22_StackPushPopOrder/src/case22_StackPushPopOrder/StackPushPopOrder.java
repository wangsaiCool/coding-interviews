package case22_StackPushPopOrder;

import java.util.Stack;

/**
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出序列。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压栈序列，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * 
 * @author WangSai
 *
 */
public class StackPushPopOrder {

	public static void main(String[] args) {
		int[] arrIn = { 1, 2, 3, 4, 5 };
		int[] arrOut = { 1, 5, 2, 3, 4 };
		System.out.println(isOrder(arrIn, arrOut));
	}

	private static boolean isOrder(int[] arrIn, int[] arrOut) {
		// 异常值检测
		if (arrIn == null || arrOut == null || arrIn.length != arrOut.length || arrIn.length <= 0)
			throw new IllegalArgumentException("非法输入参数，请重新检查...");
		// 创建辅助栈
		Stack<Integer> stack = new Stack<>();
		int inIndex = 0;
		int outIndex = 0;
		// 如果出栈元素还未完全处理完，则继续处理
		while (outIndex < arrOut.length) {
			// 如果栈为空，或者栈顶元素不等于出栈序列的元素，则一直进栈。直到进栈序列全部进栈完成。
			while (stack.empty() || stack.peek() != arrOut[outIndex]) {
				// 若所有入栈序列元素已经全部入栈，则退出该循环
				if (inIndex >= arrIn.length)
					break;
				stack.push(arrIn[inIndex]);
				inIndex++;
			}
			// 执行到这个地方，有两种可能的情况：
			// 情况1，栈顶元素==出栈序列元素
			// 情况2，进栈序列全部元素都进栈完毕，仍然没有找到与出栈序列相同的元素。
			// 对于情况2，
			if (stack.peek() != arrOut[outIndex])
				break;
			// 若栈顶元素与出栈序列元素相同，则处理后一个出栈序列元素。
			else {
				stack.pop();
				outIndex++;
			}

		}
		// 执行到此处有两种情况
		// 第一种：外层while循环的在第一种情况下退出，则栈中肯定还有未出栈的元素，栈一定不为空。
		// 第二种：所有的出栈元素都被正确匹配，则所有元素都会被从栈中弹出，栈一定为空。
		return stack.empty();
	}

}
