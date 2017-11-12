package case17_MergeListNode;

public class MergeListNode {
	/**
	 * 健壮性： 输入两个链表，有一个为null？
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 构造链表A
		ListNode listNodeA1 = new ListNode(1);
		ListNode listNodeA2 = new ListNode(3);
		ListNode listNodeA3 = new ListNode(5);
		ListNode listNodeA4 = new ListNode(7);
		listNodeA1.next = listNodeA2;
		listNodeA2.next = listNodeA3;
		listNodeA3.next = listNodeA4;
		listNodeA4.next = null;
		// 构造链表B
		ListNode listNodeB1 = new ListNode(2);
		ListNode listNodeB2 = new ListNode(4);
		ListNode listNodeB3 = new ListNode(9);
		ListNode listNodeB4 = new ListNode(9);
		listNodeB1.next = listNodeB2;
		listNodeB2.next = listNodeB3;
		listNodeB3.next = listNodeB4;
		listNodeB4.next = null;

		MergeListNode mln = new MergeListNode();
		ListNode newListNode = mln.MergeSotrListNode2(listNodeA1, listNodeB1);
		while (newListNode != null) {
			System.out.print(newListNode.val + " ");
			newListNode = newListNode.next;
		}
	}

	// 构造ListNode节点
	public static class ListNode {
		int val;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		ListNode next;
	}

	// 采用递归的方式合并有序链表
	public ListNode MergeSotrListNode2(ListNode listNodeA, ListNode listNodeB) {
		ListNode newListNode = null;
		if (listNodeA == null)
			return listNodeB;
		if (listNodeB == null)
			return listNodeA;
		if (listNodeA.val < listNodeB.val) {
			newListNode = listNodeA;
			newListNode.next = MergeSotrListNode2(listNodeA.next, listNodeB);
		} else {
			newListNode = listNodeB;
			newListNode.next = MergeSotrListNode2(listNodeA, listNodeB.next);
		}
		return newListNode;
	}
}
