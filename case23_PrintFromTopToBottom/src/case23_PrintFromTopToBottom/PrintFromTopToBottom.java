package case23_PrintFromTopToBottom;

/**
 * 题目：从上往下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。例如，输入下图中的二叉树，则一次打印出8,6,10,5,7,9,11.
 * 
 * 		   8
 * 	     /   \
 *     6       10
 *   /   \    /   \
 *  5     7   9   11
 *  
 */
import java.util.ArrayDeque;

public class PrintFromTopToBottom {

	/**
	 * 层序遍历二叉树
	 * 
	 * @param 输入二叉树根结点
	 * @return
	 */
	public void printTree(myTreeNode headNode) {

		// 异常值检测
		// 打印头结点，并且把左右子节点先后放入队列中。
		// 出队，打印当前的节点（根节点的左孩子），并且把当前节点的左右子节点入队。
		// 继续出队，打印当前的节点（根节点的右孩子），并且把当前节点的左右子节点入队。

		// 异常值检测
		if (headNode == null)
			return;
		// 创建队列容器
		ArrayDeque<myTreeNode> myQueue = new ArrayDeque<>();
		// 根节点入队。
		myQueue.offer(headNode);
		while (!myQueue.isEmpty()) {
			// 队列第一个元素出队，并且打印数据。
			myTreeNode tempNode = myQueue.poll();
			System.out.print(tempNode.data + " ");
			// 若子节点不为null，则继续入队。
			if (tempNode.lchild != null)
				myQueue.offer(tempNode.lchild);
			if (tempNode.rchild != null)
				myQueue.offer(tempNode.rchild);
		}
	}

	public static void main(String[] args) {
		// 满二叉树
		test1();
		// 只有右子节点二叉树
		test2();
		// 只有左子节点二叉树
		test3();
	}

	// 满二叉树
	private static void test1() {
		PrintFromTopToBottom pfttb = new PrintFromTopToBottom();
		myTreeNode headNode = new myTreeNode(8);
		myTreeNode N1 = new myTreeNode(6);
		myTreeNode N2 = new myTreeNode(10);
		myTreeNode N3 = new myTreeNode(5);
		myTreeNode N4 = new myTreeNode(7);
		myTreeNode N5 = new myTreeNode(9);
		myTreeNode N6 = new myTreeNode(11);
		headNode.lchild = N1;
		headNode.rchild = N2;
		N1.lchild = N3;
		N1.rchild = N4;
		N2.lchild = N5;
		N2.rchild = N6;
		pfttb.printTree(headNode);
		System.out.println();
	}

	// 只有右子节点二叉树
	private static void test2() {
		PrintFromTopToBottom pfttb = new PrintFromTopToBottom();
		myTreeNode headNode = new myTreeNode(8);
		myTreeNode N2 = new myTreeNode(10);
		myTreeNode N6 = new myTreeNode(11);
		headNode.rchild = N2;
		N2.rchild = N6;
		pfttb.printTree(headNode);
		System.out.println();
	}

	// 只有左子节点二叉树
	private static void test3() {
		PrintFromTopToBottom pfttb = new PrintFromTopToBottom();
		myTreeNode headNode = new myTreeNode(8);
		myTreeNode N1 = new myTreeNode(6);
		myTreeNode N3 = new myTreeNode(5);
		headNode.lchild = N1;
		N1.lchild = N3;
		pfttb.printTree(headNode);
		System.out.println();
	}

}
