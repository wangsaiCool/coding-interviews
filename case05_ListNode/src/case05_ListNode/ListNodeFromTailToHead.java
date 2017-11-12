package case05_ListNode;

import java.util.Stack;

public class ListNodeFromTailToHead {

	public static void main(String[] args) {
		ListNode1 listN1 = new ListNode1(1);
		ListNode1 listN2 = new ListNode1(2);
		ListNode1 listN3 = new ListNode1(3);
		ListNode1 listN4 = new ListNode1(4);
		ListNode1 listN5 = new ListNode1(5);
		ListNode1 listN6 = new ListNode1(6);
		ListNode1 listN7 = new ListNode1(7);
		listN1.next = listN2;
		listN2.next = listN3;
		listN3.next = listN4;
		listN4.next = listN5;
		listN5.next = listN6;
		listN6.next = listN7;
		listN7.next = null;
		System.out.println("//方法1：利用栈从尾到头打印链表");
		// 方法1：利用栈从尾到头打印链表
		printFromHailToHead1(listN1);
		System.out.println();
		System.out.println("//方法2：利用递归方式");
		// 方法2：利用递归方式
		printFromTailToHead2(listN1);
	}

	// 定义节点结构
	public static class ListNode1 {
		int val;

		public ListNode1(int val) {
			this.val = val;
		}

		ListNode1 next = null;
	}

	// 方法1：利用栈的方式实现。
	public static void printFromHailToHead1(ListNode1 list1) {
		Stack<Integer> stack1 = new Stack<>();
		if (list1 == null)
			return;
		// 压入栈stack1里面
		while (list1 != null) {
			stack1.push(list1.val);
			list1 = list1.next;
		}
		// 出栈
		while (!stack1.empty()) {
			System.out.print(stack1.pop() + " ");
		}
	}

	// 方法2：利用递归的方法实现
	public static void printFromTailToHead2(ListNode1 list2) {
		if (list2 == null) {
			return;
		} else {
			printFromTailToHead2(list2.next);
			System.out.print(list2.val + " ");
		}
	}

}
