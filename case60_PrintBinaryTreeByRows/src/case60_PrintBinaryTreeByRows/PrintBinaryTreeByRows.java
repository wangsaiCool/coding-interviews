package case60_PrintBinaryTreeByRows;

/**
 * 题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行，
 * ............8...............................................................
 * ........../....\............................................................
 * .........6......10...........................................................
 * ......./..\.../...\..........................................................
 * ......5...7...9....11.........................................................
 * 上图二叉树打印结果：
 * 8
 * 6 10
 * 5  7  9  11
 * 
 * @author WangSai
 *
 */
import java.util.ArrayDeque;

public class PrintBinaryTreeByRows {
	/**
	 * 思路：利用队列把按照层序遍历到的元素，存入队列中。然后队列把第一个元素出队列，同时把该元素的左右子节点先后入队列。
	 * 这样就可以实现按照层序遍历二叉树。为了实现按照行打印二叉树，需要两个变量：
	 * 1，currentCount,保存当前行剩余需要给打印的元素个数。2，nextRowsCount,统计下一行的元素数量。
	 * 
	 * @param root,二叉树的根节点
	 */
	private void getMyRows(MyNode root) {
		if (root == null)
			return;
		// 利用队列保存遍历到的数据，当队列第一个元素出队列的时候，把它的左右元素分别入队列。
		ArrayDeque<MyNode> queue1 = new ArrayDeque<>();
		// 把二叉树的根元素入队列
		queue1.offer(root);
		int currentCount = 1;
		int nextRowsCount = 0;
		while (!queue1.isEmpty()) {
			// 取出队列第一个元素，并打印
			MyNode tempNode = null;
			tempNode = queue1.poll();
			System.out.print(tempNode.data + " ");
			// 当前行需要被打印的元素-1个
			currentCount--;
			// 该出队元素的左子节点若不为null，则入队列。并且下一行统计到的元素+1
			if (tempNode.lchild != null) {
				queue1.offer(tempNode.lchild);
				nextRowsCount++;
			}
			// 该出队元素的右子节点若不为null，则入队列。并且下一行统计到的元素+1
			if (tempNode.rchild != null) {
				queue1.offer(tempNode.rchild);
				nextRowsCount++;
			}
			// 若当前行元素全部都出队列，打印换行。
			// 开始下一行打印，并进行统计。
			if (currentCount == 0) {
				System.out.println('\t');
				currentCount = nextRowsCount;
				nextRowsCount = 0;
				// 该行元素打印完毕，并且下一行元素为0，则表示已经打印完毕。
				if (currentCount == 0 && nextRowsCount == 0) {
					System.out.println("Done");
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		test1();
		System.out.println("***********");
		test2();
		System.out.println("***********");
		test3();
		System.out.println("***********");
	}

	// 满二叉树
	// ............8...............................................................
	// ........../....\............................................................
	// .........6......10...........................................................
	// ......./..\.../...\..........................................................
	// ......5...7...9....11.........................................................
	private static void test1() {
		PrintBinaryTreeByRows rbtb = new PrintBinaryTreeByRows();
		MyNode root = new MyNode(8);
		MyNode N2 = new MyNode(6);
		MyNode N3 = new MyNode(10);
		MyNode N4 = new MyNode(5);
		MyNode N5 = new MyNode(7);
		MyNode N6 = new MyNode(9);
		MyNode N7 = new MyNode(11);
		root.lchild = N2;
		root.rchild = N3;
		N2.lchild = N4;
		N2.rchild = N5;
		N3.lchild = N6;
		N3.rchild = N7;
		rbtb.getMyRows(root);
	}

	// 斜二叉树
	// ............8...............................................................
	// ........../.................................................................
	// .........6..................................................................
	// ......./.....................................................................
	// ......5......................................................................
	private static void test2() {
		PrintBinaryTreeByRows rbtb = new PrintBinaryTreeByRows();
		MyNode root = new MyNode(8);
		MyNode N2 = new MyNode(6);
		MyNode N4 = new MyNode(5);
		root.lchild = N2;
		N2.lchild = N4;
		rbtb.getMyRows(root);
	}

	// 普通二叉树
	// ............8...............................................................
	// ........../....\............................................................
	// .........6......10...........................................................
	// ......./..\..................................................................
	// ......5...7..................................................................
	private static void test3() {
		PrintBinaryTreeByRows rbtb = new PrintBinaryTreeByRows();
		MyNode root = new MyNode(8);
		MyNode N2 = new MyNode(6);
		MyNode N3 = new MyNode(10);
		MyNode N4 = new MyNode(5);
		MyNode N5 = new MyNode(7);
		root.lchild = N2;
		root.rchild = N3;
		N2.lchild = N4;
		N2.rchild = N5;
		rbtb.getMyRows(root);
	}

}
