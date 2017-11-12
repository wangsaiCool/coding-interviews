package case07_QueueWithTwoStacks;

import java.util.Stack;

/**
 * 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead,分别完成在队列尾部插入节点和在队列头部删除节点的功能。
 * 
 * @author WangSai
 *
 */
public class QueueWith2Stacks<T> {
	// 插入栈，只用于插入数据
	private Stack<T> stack1;
	// 弹出栈，只用于弹出数据
	private Stack<T> stack2;

	public QueueWith2Stacks() {
		this.stack1 = new Stack<>();
		this.stack2 = new Stack<>();
	}

	// 添加操作，完成在队列尾部插入节点
	public void appendTail(T t) {
		stack1.push(t);
	}

	// 删除操作，完成在队列头部删除节点
	public T deleteHead() {
		// 当stack2为空时，将stack1中的元素一次弹出并压入stack2
		// 当stack2不为空时，先将stack2中的元素弹出直至为空，再将stack1中的元素倒入stack2
		if (stack2.empty())
			while (!stack1.empty())
				stack2.push(stack1.pop());
		// 如果将stack1中的元素倒入stack2之后，stack2仍然为空。在队列中已经没有元素了。
		if (stack2.empty())
			throw new RuntimeException("队列为空");
		// 删除栈顶元素，并且返回该元素。
		return stack2.pop();
	}

	public static void main(String[] args) {
		QueueWith2Stacks<String> myQueue = new QueueWith2Stacks<>();
		myQueue.appendTail("my first string");
		myQueue.appendTail("my second string");
		myQueue.appendTail("my third string");
		System.out.println("第1次删除队列头，并且删除的元素为：" + myQueue.deleteHead());
		System.out.println("第2次删除队列头，并且删除的元素为：" + myQueue.deleteHead());
		System.out.println("第3次删除队列头，并且删除的元素为：" + myQueue.deleteHead());
		System.out.println("第4次删除队列头，并且删除的元素为：" + myQueue.deleteHead());
	}
}
