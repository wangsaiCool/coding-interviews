package case56_EntryNodeOfLoop;

/**
 * 题目：一个链表中包含环，如何找出环的入口节点？例如在下图的链表中，环的入口节点是节点3。
 * 
 * N1 ——>N2 ——>N3 ——>N4 ——>N5 ——>N6 ——>N7 ——>N8 ——>N9 ——>N10 ——>N11 ——>N12
 * ............^—————————————<—————————————<—————————————<—————————————v
 * 
 * 思路：
 * 
 * 1，首先判断链表中是否有环。方法：定义两个指针，fast和slow指向head，fast走的快，slow走的慢。若有环则fast会追上slow，
 * 并且相遇的节点就是环中的节点。
 * 
 * 2，若有环，则从相遇的节点开始统计环中的节点数n
 * 
 * 3，再定义两个指针p1,p2从链表的头开始，p1先走n步，然后，p2和p1一起向前走，当第一次相遇时，便是环形链表的入口节点。
 * 
 * @author WangSai
 *
 */
public class EntryNodeOfLoop {

	/**
	 * 判断链表中是否存在环？定义两个指针一个走的 快fast，一个走的慢slow，如果快的fast和慢的slow相遇了，说明存在环，并且返回相遇的点。
	 * 若不存在则返回null。
	 * 
	 * @param head,链表的头结点
	 * @return 环中相遇的节点，若不存在环则返回null
	 */
	private static ListNode meetingNode(ListNode head) {
		// 异常检测
		if (head == null)
			return null;
		// 定义两个指针，一个走的快，一个走的慢
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null) {
			fast = fast.next;
			if (fast == null)
				return null;
			fast = fast.next;

			slow = slow.next;
			if (fast == slow) {
				return slow;
			}
		}
		return null;
	}

	/**
	 * 找到相遇的点后，计算环中有多少个点
	 * 
	 * @param node，环中任意的一个节点
	 * @return 环中有多少个节点
	 */
	private static int numOfNodeInLoop(ListNode node) {
		if (node == null)
			return 0;
		int count = 1;
		ListNode temp = node;
		temp = temp.next;
		while (node != temp) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	/**
	 * 寻找环的入口节点。定义两个指针p1,p2。p1先走n步，然后，p1 p2一起向前走，当他们相遇时，就是环形链表的入口。
	 * 
	 * @param head,链表的头结点
	 * @param num,链表中环形链表中的节点数量
	 * @return 链表的环形入口
	 */

	private static ListNode myEntryNode(ListNode head, int num) {
		// num为0，说明没有环
		if (num == 0)
			return null;
		// fast先走num步，然后，slow和fast一起向前走。当fast和slow相遇时，就是入口的点。
		ListNode fast = head;
		ListNode slow = head;
		while (num > 0) {
			fast = fast.next;
			num--;
		}
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 链表有环
		test1();
		// 单链表，没有环
		test2();
		// 空链表
		test3();
		// 环形链表，链表尾节点指向头结点
		test4();
	}

	/**
	 * 链表有环
	 */
	public static void test1() {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n8;

		ListNode entryNode3 = myEntryNodeInLoop(head);
		System.out.println(entryNode3.data);
	}

	/*
	 * 单链表，没有环
	 */
	public static void test2() {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;

		ListNode entryNode3 = myEntryNodeInLoop(head);
		System.out.println(entryNode3);
	}

	/*
	 * 空链表
	 */
	public static void test3() {

		ListNode entryNode1 = myEntryNodeInLoop(null);
		System.out.println(entryNode1);
	}

	/*
	 * 链表尾节点指向头节点
	 */
	public static void test4() {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = head;

		ListNode entryNode3 = myEntryNodeInLoop(head);
		System.out.println(entryNode3.data);
	}

	private static ListNode myEntryNodeInLoop(ListNode head) {
		// 是否有环，若有环则返回环中的任意结点；若没有则返回null
		ListNode nodeInloop = meetingNode(head);
		// 统计环中有多少个节点
		int numInLoop = numOfNodeInLoop(nodeInloop);
		System.out.println("环中有多少个节点：" + numInLoop);
		// 返回环的入口节点
		ListNode entryNode = myEntryNode(head, numInLoop);
		return entryNode;
	}
}
