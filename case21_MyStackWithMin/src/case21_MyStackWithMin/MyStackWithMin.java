package case21_MyStackWithMin;

import java.util.Stack;

/**
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min，push，pop的时间复杂度都是O(1)。
 * 
 * @author WangSai
 *
 */
public class MyStackWithMin {
	/**
	 * 1，思路：通过两个栈实现，数据栈stackData实现存放数据，辅助栈stackMin实现存放最小的数据。
	 * 2，压栈：只要有非空元素请求入栈则压入stackData。同时判断该元素与辅助栈stackMin的栈顶元素的大小，若小于等于stackMin栈顶元素，则入栈stackMin；
	 * 否则，不压栈。stackMin的元素个数 不大于 stackData。
	 * 3，弹栈，stackData不为空则立马弹栈；判断stackMin的栈顶元素是否与stackData刚才的出栈元素相同，如果相同则stackMin栈顶元素也出栈。
	 *
	 * @param <T>，泛型定义数据类型
	 */
	public static class MyStack<T extends Comparable<T>> {
		private Stack<T> stackData;
		private Stack<T> stackMin;

		// 构造函数
		public MyStack() {
			this.stackData = new Stack<>();
			this.stackMin = new Stack<>();
		}

		// 实现压栈
		public void push(T t) {
			// 异常值检测，t不能为null
			if (t == null)
				throw new IllegalArgumentException("IllegalArgument");
			// 如果两个栈都为null，则将t分别压入两个栈。
			if (stackData.empty()) {
				stackData.push(t);
				stackMin.push(t);
			}
			// 如果新元素 小于等于 stackMin的栈顶元素，则压入栈stackMin中
			else if (t.compareTo(stackMin.peek()) <= 0) {
				stackMin.push(t);
				stackData.push(t);
			}
			// 只要有新元素，就需要压入stackData中
			else {
				stackData.push(t);
			}
		}

		// 实现弹栈
		public T pop() {
			if (stackData.empty())
				throw new RuntimeException("Stack is already empty");
			// 只要有弹栈需求，就把stackData栈顶元素弹出去
			T t = stackData.pop();
			// 如果栈stackData不为null，则stackMin中肯定有元素。
			// 若pop出的stackData中的元素，恰好也是是stackMin的栈顶元素，则删除stackMin的栈顶元素
			if (t != null && t == stackMin.peek()) {
				stackMin.pop();
			}
			return t;
		}

		// 获取最小值
		public T min() {
			if (stackData.empty())
				throw new IllegalArgumentException("Stack is already empty");
			return stackMin.peek();
		}
	}

	// 测试MyStack
	public static void main(String[] args) {
		MyStack<Integer> stack1 = new MyStack<>();
		// 压入3，获取min
		stack1.push(3);
		System.out.println("压入3，获取min: " + stack1.min());
		// 压入4，获取min
		stack1.push(4);
		System.out.println("压入4，获取min: " + stack1.min());
		// 压入5，获取min
		stack1.push(5);
		System.out.println("压入5，获取min: " + stack1.min());
		// 压入0，获取min
		stack1.push(0);
		System.out.println("压入0，获取min: " + stack1.min());
		// pop一次，弹出0之后，获取min应该是3
		System.out.println("pop第1次：       	    " + stack1.pop());
		System.out.println("pop第1次之后，获取min: " + stack1.min());

		System.out.println("pop第2次：       	    " + stack1.pop());
		System.out.println("pop第3次：       	    " + stack1.pop());
		System.out.println("pop第3次之后，获取min: " + stack1.min());
		System.out.println("pop第4次：       	    " + stack1.pop());
		System.out.println("pop第5次： " + stack1.pop());
		System.out.println("pop第5次之后，获取min: " + stack1.min());
	}
}
