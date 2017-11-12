package case16_ReverseList;

public class ReverseList {
	/**
	 * 翻转链表，需要注意的问题 1，空链表 2，只有一个节点 3，存在多个节点
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = null;
		ListNode listNodeRev2 = ReverseList2(listNode1);
		ListNode l2 = listNodeRev2.next;
		System.out.print(l2.val);
	}

	// 反转链表
	public static ListNode ReverseList2(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode nowListNode = head; // 保存当前节点
		ListNode preListNode = null; // 当前节点的前一个节点
		ListNode revListNodeHead = null;// 当前节点的下一个节点
		while (nowListNode != null) {
			ListNode nextListNode = nowListNode.next;
			if (nextListNode == null)
				revListNodeHead = nowListNode;
			nowListNode.next = preListNode;
			preListNode = nowListNode;
			nowListNode = nextListNode;
		}
		return revListNodeHead;
	}

	// 构造单链表节点
	public static class ListNode {
		int val;
		ListNode next = null;

		public ListNode(int val) {
			this.val = val;
		}
	}
}
