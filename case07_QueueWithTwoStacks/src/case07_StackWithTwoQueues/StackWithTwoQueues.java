package case07_StackWithTwoQueues;
/**
 *题目：用两个队列实现栈，并且实现栈的pop,push，empty，top(获取栈顶元素，但是不删除)
 * @author WangSai
 *
 */

import java.util.ArrayDeque;

public class StackWithTwoQueues<T> {
	// 两个队列，在模拟实现栈的时候，始终保持其中一个队列为空。
	private ArrayDeque<T> queue1;
	private ArrayDeque<T> queue2;

	public StackWithTwoQueues() {
		queue1 = new ArrayDeque<>();
		queue2 = new ArrayDeque<>();
	}

	// 从from队列中取出元素，并且送入队列to中。在队列from中保留最后一个元素。
	private void move(ArrayDeque<T> from, ArrayDeque<T> to) {
		if (!isEmpty()) {
			while (from.size() > 1) {
				// 从from队列中取出元素，并且送入队列to中。在队列from中保留最后一个元素。
				to.offer(from.poll());
			}
		}
	}

	// 模拟入栈操作，queque1始终作为
	public void push(T t) {
		queue1.offer(t);
	}

	// 模拟出栈操作,弹出并返回栈顶元素。
	public T pop() {
		T top = null;
		if (!isEmpty()) {
			if (!queue1.isEmpty()) {
				move(queue1, queue2);
				top = queue1.poll();
			} else {
				move(queue2, queue1);
				top = queue2.poll();
			}
		}
		return top;
	}

	// 模拟栈的top操作
	public T top() {
		T top = null;
		if (!isEmpty()) {
			if (!queue1.isEmpty()) {
				move(queue1, queue2);
				top = queue1.poll();
				queue2.offer(top);
			} else {
				move(queue2, queue1);
				top = queue2.poll();
				queue1.offer(top);
			}
		}
		return top;
	}

	// 实现栈为空功能
	public boolean isEmpty() {
		return queue1.isEmpty() && queue2.isEmpty();
	}

	public static void main(String[] args) {
		StackWithTwoQueues<String> myStack = new StackWithTwoQueues<>();
		myStack.push("1st e");
		myStack.push("2nd e");
		myStack.push("3rd e");
		System.out.println("myStack.isEmpty():" + myStack.isEmpty());
		System.out.println("第1次：myStack.pop():" + myStack.pop());
		System.out.println("第3次：myStack.pop():" + myStack.pop());
		System.out.println("myStack.top():" + myStack.top());
		System.out.println("第2次：myStack.pop():" + myStack.pop());
		System.out.println("第4次：myStack.pop():" + myStack.pop());
		System.out.println("myStack.isEmpty():" + myStack.isEmpty());
	}

}
