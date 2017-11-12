package case13_DeleteNodeInList;

/**
 * 题目：给定单链表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点。
 * 
 * 思路：
 * 
 * 1，要删除的节点是尾节点时，通过遍历，删除该节点。 *
 * 2，链表中有多个节点，要删除的节点NodeP是中间节点时，通过NodeP的下一个节点覆盖当前节点的内容，并且NodeP指向下一个的下一个节点，即可在O(1)时间完成删除。
 * 3，要删除的节点所在的链表只有一个节点时。
 * 
 * 【注意：这个方法和文本上的不一样，书上的没有返回值，这个因为JAVA引用传递的原因，如果删除的结点是头结点，如果不采用返回值的方式，那么头结点永远删除不了】
 * 
 * @author WangSai
 *
 */
public class DeleteNodeInList {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteNodeInList del = new DeleteNodeInList();
		MyNode mn1 = new MyNode(111);
		MyNode mn2 = new MyNode(222);
		MyNode mn3 = new MyNode(333);
		MyNode mn4 = new MyNode(444);
		MyNode mn5 = new MyNode(555);
		MyNode mn6 = new MyNode(666);
		mn1.nextNode = mn2;
		mn2.nextNode = mn3;
		mn3.nextNode = mn4;
		mn4.nextNode = mn5;
		mn5.nextNode = mn6;
		mn6.nextNode = null;
		MyNode test = del.deleteNode(mn1, mn6);
		while (test != null) {
			System.out.println(test.data + " ");
			test = test.nextNode;
		}
	}

	// 删除链表中的节点。
	private MyNode deleteNode(MyNode headNode, MyNode toBeDeleted) {
		// 异常情况检测
		if (headNode == null || toBeDeleted == null)
			return headNode;
		// 链表中有多个节点，且要删除的节点不是尾节点
		if (toBeDeleted.nextNode != null) {
			// 用要被删除的节点的内容替换当前要被删除的节点的内容。
			toBeDeleted.data = toBeDeleted.nextNode.data;
			toBeDeleted.nextNode = toBeDeleted.nextNode.nextNode;
		}
		// 链表中只有一个节点，且要删除头结点。
		else if (headNode == toBeDeleted)
			headNode = null;
		// 链表中要好多个节点，要删除的节点是尾节点
		else if (toBeDeleted.nextNode == null) {
			MyNode tempNode = headNode;
			while (tempNode.nextNode != toBeDeleted) {
				tempNode = tempNode.nextNode;
			}
			tempNode.nextNode = null;
		}
		return headNode;
	}
}
