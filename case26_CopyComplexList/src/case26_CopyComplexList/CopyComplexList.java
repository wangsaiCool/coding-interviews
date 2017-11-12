package case26_CopyComplexList;

/**
 * 题目：请实现函数ListNode Clone(ListNode root)，复制一个复杂链表。在复杂链表中， 每个节点除了有一个Next
 * 指针指向下一个节点外，还有一个sibling指向链表中的任意结点或者null。
 * 
 * @author WangSai
 *
 */
public class CopyComplexList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ComplexListNode n1 = new ComplexListNode(1);
		ComplexListNode n1_ = new ComplexListNode(1);
		ComplexListNode n2 = new ComplexListNode(2);
		ComplexListNode n2_ = new ComplexListNode(2);
		ComplexListNode n3 = new ComplexListNode(3);
		ComplexListNode n3_ = new ComplexListNode(3);
		n1.next = n1_;
		n1_.next = n2;
		n2.next = n2_;
		n2_.next = n3;
		n3.next = n3_;
		// n3_.next = n4;
		// n4.next = n4_;
		// n4.next = n5;
		// simpleCopy(n1);
		ComplexListNode node = reConnected(n1);
		// while (node != null) {
		// System.out.print(node.data + " ");
		// node = node.next;
		// }

		while (n1 != null) {
			System.out.print(n1.data + " ");
			n1 = n1.next;
		}
	}

	/**
	 * 
	 * @param head,原链表的头结点
	 * @return 复制出来的节点的头结点
	 */
	private static ComplexListNode Clone(ComplexListNode head) {
		// 异常值检测
		if (head == null)
			return null;
		// 在原链表的每一个节点后面复制出一个与前一个节点相同的节点，并且插入到前一个节点后面。只处理next
		simpleCopy(head);
		// 处理sibling
		connectSibling(head);
		// 拆分链表
		reConnected(head);
		return null;

	}

	/**
	 * 在原链表的每一节点N后面复制一个新的节点N'，并且与前一个节点相同。
	 * 
	 * 复制出来的新链表newlist：N1 ——>N1' ——>N2 ——>N2' ——>N3 ——>N3' ——>N4 ——> N4'
	 * 
	 * @param head，原链表的头节点
	 */
	private static void simpleCopy(ComplexListNode head) {
		while (head != null) {
			// 新建节点
			ComplexListNode temp = new ComplexListNode();
			// 为新节点赋值，值为当前处理的head节点的值
			temp.data = head.data + 100;
			// 把新节点插入到原head的下一个节点的前面。
			temp.next = head.next;
			// 把temp插入到head后面
			head.next = temp;
			// head指向原链表的下一个节点
			head = temp.next;
		}
	}

	/**
	 * 处理复制出来的链表newlist(N1——>N1'——>N2——>N2'——>N3——>N3'——>N4——> N4')中的sibling节点。
	 * 
	 * @param head,复制出来的新链表newlist的头结点。
	 */
	private static void connectSibling(ComplexListNode head) {
		while (head != null) {
			// head.next:新链表中被复制出来的新节点
			// head.next.next:原链表中head的下一个节点
			// head.sibling:原节点的sibling节点
			// head.next.sibling:复制出来的新节点的sibling节点
			// head.sibling.next:原节点的sibling节点的下一个节点，即新节点的sibling节点
			if (head.sibling != null) {
				head.next.sibling = head.sibling.next;
			}
		}
	}

	/**
	 * 把原来的节点和复制出来的新结点进行拆分。奇数是原来的节点，偶数是复制出来的结点。
	 * 
	 * @param head,复制出来新链表newlist(N1—>N1'—>N2—>N2'—>N3—>N3'—>N4—>N4')的头结点。
	 * @return 题目要求的新节点的头结点N1'，即N1' ——>N2' ——>N3' ——> N4'的头结点。
	 */
	private static ComplexListNode reConnected(ComplexListNode head) {

		// 记录偶数结点组成的链表的头结点
		ComplexListNode newHead = head.next;
		// 指向偶数结点
		ComplexListNode pointer = newHead;
		// 最原始的链表的头结点的引用
		ComplexListNode pre = head;

		while (pre != null) {
			pre.next = pre.next.next;
			if (pointer.next == null) {
				pointer.next = null;
			} else {
				pointer.next = pointer.next.next;
			}
			pre = pre.next;
			pointer = pointer.next;
		}
		return newHead;
	}
}
