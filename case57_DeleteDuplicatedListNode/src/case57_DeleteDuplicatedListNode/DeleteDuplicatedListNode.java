package case57_DeleteDuplicatedListNode;

/**
 * 题目：在一个排序的链表中，如何删除重复的结点？例如，在下图a中重复节点被删除之后，链表如b图所示。
 * 
 * a: N1 ——————> N2 ——————> N3 ——————> N3 ——————> N4 ——————> N4 ——————> N5
 * 
 * b: N1 ——————> N2 ——————> N5
 * 
 * @author WangSai
 *
 */
public class DeleteDuplicatedListNode {

	/**
	 * 设置一个前驱节点，保存当前节点的上一个节点。设置临时头结点，指向原链表的头结点。
	 * 
	 * @param head，原链表的头结点
	 * @return 删除重复节点之后的新链表的头结点
	 */
	private static ListNode myDelete(ListNode head) {
		// 异常值处理
		if (head == null)
			return null;
		// 临时头结点
		ListNode root = new ListNode();
		// 当前节点的前一个节点
		ListNode pre = root;
		// 当前节点
		ListNode cur = head;
		root.next = head;

		while (cur != null && cur.next != null) {
			// 有重复结点，与cur值相同的结点都要删除
			if (cur.data == cur.next.data) {
				// 找到下一个不同值的节点，注意其有可能也是重复节点
				while (cur.next != null && cur.data == cur.next.data) {
					cur = cur.next;
				}
				// 指向下一个节点，prev.next也可能是重复结点
				// 所以prev不要移动到下一个结点
				pre.next = cur.next;
			} else {
				pre.next = cur;
				pre = pre.next;
			}
			cur = cur.next;
		}
		return root.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 有重复节点，重复节点在中间
		test1();
		// 有重复节点，重复节点开始部分
		test2();
		// 所有节点重复
		test3();
		// 没有重复节点
		test4();
	}

	/**
	 * 有重复节点，重复节点在中间
	 */
	public static void test1() {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);

		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		System.out.println("删除重复节点之前：");
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("删除重复节点之后：");
		ListNode node = myDelete(head);
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println();
		System.out.println("----------------");
	}

	/**
	 * 有重复节点，重复节点开始部分
	 */
	public static void test2() {
		ListNode head = new ListNode(2);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);

		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		System.out.println("删除重复节点之前：");
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("删除重复节点之后：");
		ListNode node = myDelete(head);
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println();
		System.out.println("----------------");
	}

	/**
	 * 所有节点重复
	 */
	public static void test3() {
		ListNode head = new ListNode(2);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(2);

		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		System.out.println("删除重复节点之前：");
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("删除重复节点之后：");
		ListNode node = myDelete(head);
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println();
		System.out.println("----------------");
	}

	/**
	 * 没有节点重复
	 */
	public static void test4() {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);

		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		System.out.println("删除重复节点之前：");
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("删除重复节点之后：");
		ListNode node = myDelete(head);
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println();
		System.out.println("----------------");
	}
}