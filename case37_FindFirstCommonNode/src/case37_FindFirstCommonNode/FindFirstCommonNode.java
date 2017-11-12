package case37_FindFirstCommonNode;

import java.util.Stack;

/**
 * 题目：输入两个链表，找出他们的第一个公共结点。
 * 
 * @author WangSai
 *
 */
public class FindFirstCommonNode {

	/**
	 * 方法1：
	 * 
	 * 思路：从单链表的尾节点开始寻找，把两个链表分别压入栈stack1和stack2中，然后依次弹出栈，就可以实现从链表尾部开始比较。因为单链表只有一个next引用，
	 * 所以，从第一个公共结点开始就会成Y形。从尾节点开始比较，寻找第一个不相同的地方，即可。
	 * 
	 * @param head1,链表1的头结点
	 * @param head2，链表2的头结点
	 * @return 链表1和链表2的第一个公共结点。
	 */
	private static MyNode getMyFirstCommonNode(MyNode head1, MyNode head2) {
		// 异常值检测
		if (head1 == null || head2 == null)
			return null;
		// 若输入的两个结点为同一个链表的头结点
		if (head1 == head2)
			return head1;
		Stack<MyNode> stack1 = new Stack<>();
		Stack<MyNode> stack2 = new Stack<>();
		MyNode myCommonNode = null;
		// 把链表1压入栈中
		while (head1 != null) {
			stack1.push(head1);
			head1 = head1.next;
		}
		// 把链表2压入栈中
		while (head2 != null) {
			stack2.push(head2);
			head2 = head2.next;
		}
		MyNode stack1Node = stack1.pop();
		MyNode stack2Node = stack2.pop();
		while (!stack1.empty() && !stack2.empty() && stack1Node == stack2Node) {
			myCommonNode = stack1Node;
			stack1Node = stack1.pop();
			stack2Node = stack2.pop();

		}
		return myCommonNode;

	}

	/**
	 * 方法2：
	 * 
	 * 思路：两个链表若有公共结点，则从尾部一定重合。因为单链表只有1个next引用。先分别链表1和链表2，获得两个链表的长度count1和count2，链表长度较长
	 * 的链表，先往前走几步Math.abs（count1-count2）,然后，一起遍历。若有公共结点，则从该结点开始，后面全部重合，呈现Y形。即可获得第一个公共结点。
	 * 
	 * @param head1,链表1的头结点
	 * @param head2，链表2的头结点
	 * @return 链表1和链表2的第一个公共结点。
	 */
	private static MyNode getMyFirstCommonNode2(MyNode head1, MyNode head2) {
		if (head1 == null || head2 == null)
			return null;
		if (head1 == head2)
			return head1;
		MyNode n1 = head1;
		MyNode n2 = head2;
		int count1 = 0, count2 = 0;
		// 遍历链表1，获取元素数量
		while (n1 != null) {
			n1 = n1.next;
			count1++;
		}
		// 遍历链表2，获取元素数量
		while (n2 != null) {
			n2 = n2.next;
			count2++;
		}
		// 元素多的那个链表先开始走几步，然后，当链表剩余的元素相同时，开始比较。
		int dif = count2 - count1;
		while (dif < 0) {
			head1 = head1.next;
			dif++;
		}
		while (dif > 0) {
			head2 = head2.next;
			dif--;
		}
		while (head1 != null && head2 != null && head1 != head2) {
			head1 = head1.next;
			head2 = head2.next;
		}
		// 执行到这一步，有两种情况：
		// 情况1：因为两个元素head1==head2，返回head1即可。
		// 情况2：遍历到最后没有相同的元素。
		if (head1 == head2)
			return head1;
		return null;
	}

	public static void main(String[] args) {
		test1();
		System.out.println("test1()*********** over");
		test2();
		System.out.println("test2()*********** over");
		test3();
		System.out.println("test3()*********** over");
		test4();
		System.out.println("test4()*********** over");
	}

	// 链表1和链表2最后一个结点相同
	// 链表1：head1(0)——>N1(1)——>N2(2)——>N3(3)——>null
	// 链表2：head2(5)——>M1(6)——>M2(7)——>N3(3)——>null
	private static void test1() {
		MyNode head1 = new MyNode(0);
		MyNode N1 = new MyNode(1);
		MyNode N2 = new MyNode(2);
		MyNode N3 = new MyNode(3);
		head1.next = N1;
		N1.next = N2;
		N2.next = N3;

		MyNode head2 = new MyNode(5);
		MyNode M1 = new MyNode(6);
		MyNode M2 = new MyNode(7);
		// MyNode M3 = new MyNode(8);
		head2.next = M1;
		M1.next = M2;
		M2.next = N3;
		System.out.println("链表1:head1(0)——>N1(1)——>N2(2)——>N3(3)——>null:");
		System.out.println("链表2:head2(5)——>M1(6)——>M2(7)——>N3(3)——>null:");
		System.out.println(getMyFirstCommonNode(head1, head2).data);
		System.out.println(getMyFirstCommonNode2(head1, head2).data);

	}

	// 链表1和链表2从第一个结点开始就相同,即输入同一个链表的头结点
	// 链表1：head1(9)——>N1(1)——>N2(2)——>N3(3)——>null
	// 链表2：head1(9)——>N1(1)——>N2(2)——>N3(3)——>null
	private static void test2() {
		MyNode head1 = new MyNode(9);
		MyNode N1 = new MyNode(1);
		MyNode N2 = new MyNode(2);
		MyNode N3 = new MyNode(3);
		head1.next = N1;
		N1.next = N2;
		N2.next = N3;

		System.out.println("链表1:head1(9)——>N1(1)——>N2(2)——>N3(3)——>null:");
		System.out.println("链表2:head1(9)——>N1(1)——>N2(2)——>N3(3)——>null:");
		System.out.println(getMyFirstCommonNode(head1, head1).data);
		System.out.println(getMyFirstCommonNode2(head1, head1).data);

	}

	// 链表1:head1(0)——>N1(1)——>N2(2)——>N3(3)——>null
	// 链表2:head2(5)——>M1(6)——>M2(7)——>M3(8)——>null
	// 没有公共结点
	private static void test3() {
		MyNode head1 = new MyNode(0);
		MyNode N1 = new MyNode(1);
		MyNode N2 = new MyNode(2);
		MyNode N3 = new MyNode(3);
		head1.next = N1;
		N1.next = N2;
		N2.next = N3;

		MyNode head2 = new MyNode(5);
		MyNode M1 = new MyNode(6);
		MyNode M2 = new MyNode(7);
		MyNode M3 = new MyNode(8);
		head2.next = M1;
		M1.next = M2;
		M2.next = M3;
		System.out.println("链表1:head1(0)——>N1(1)——>N2(2)——>N3(3)——>null:");
		System.out.println("链表2:head2(5)——>M1(6)——>M2(7)——>M3(8)——>null:");
		System.out.println(getMyFirstCommonNode(head1, head2));
		System.out.println(getMyFirstCommonNode2(head1, head2));

	}

	// 链表1:head1(0)——>N1(1)——>N2(2)——>N3(3)——>null
	// 链表2:head2(5)——>M1(6)——>N2(2)——>N3(3)——>null
	// 从中部开始相同。
	private static void test4() {
		MyNode head1 = new MyNode(0);
		MyNode N1 = new MyNode(1);
		MyNode N2 = new MyNode(2);
		MyNode N3 = new MyNode(3);
		head1.next = N1;
		N1.next = N2;
		N2.next = N3;

		MyNode head2 = new MyNode(5);
		MyNode M1 = new MyNode(6);
		// MyNode M2 = new MyNode(7);
		// MyNode M3 = new MyNode(8);
		head2.next = M1;
		M1.next = N2;
		System.out.println("链表1:head1(0)——>N1(1)——>N2(2)——>N3(3)——>null:");
		System.out.println("链表2:head2(5)——>M1(6)——>N2(2)——>N3(3)——>null:");
		System.out.println(getMyFirstCommonNode(head1, head2).data);
		System.out.println(getMyFirstCommonNode2(head1, head2).data);

	}
}
