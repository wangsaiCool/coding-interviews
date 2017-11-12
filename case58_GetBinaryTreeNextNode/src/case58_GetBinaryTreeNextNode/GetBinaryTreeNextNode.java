package case58_GetBinaryTreeNextNode;

/**
 * 题目： 给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个节点？树中的节点除了有两个分别指向左右子节点的指针以外，
 * 还有一个指针指向父节点的指针。
 * 
 * @author WangSai
 *
 */
public class GetBinaryTreeNextNode {

	/**
	 * 
	 * @param root,树的根节点
	 * @param MyNode,待查找的节点
	 * @return 树的中序遍历的MyNode节点的下一个子节点
	 */
	private static BinaryTreeNode getMyInOrderTraverNexNode(BinaryTreeNode root, BinaryTreeNode MyNode) {
		// root||mynode为null
		if (root == null || MyNode == null)
			return null;
		// MyNode为根节点root
		if (root == MyNode) {
			// 1.有 右子节点
			if (MyNode.rchild != null) {
				BinaryTreeNode temp = MyNode.rchild;
				while (temp.lchild != null) {
					temp = temp.lchild;
				}
				return temp;
			}
			// 2.有 左子节点,没有右子节点
			// 3.没有左右子节点
			else if (root.rchild == null) {
				return null;
			}
		}
		// MyNode不为根节点
		else {
			// 1,该节点 有右子节点
			if (MyNode.rchild != null) {
				BinaryTreeNode temp = MyNode.rchild;
				while (temp.lchild != null) {
					temp = temp.lchild;
				}
				return temp;
			}
			// 2,该节点 没有右子节点
			else {
				// 1),该节点为父节点的左子节点
				if (MyNode == MyNode.parent.lchild)
					return MyNode.parent;
				// 2),该节点为父节点的右子节点
				else {
					BinaryTreeNode temp = MyNode;
					if (temp.parent == root) {
						return null;
					}
					// 该节点的父节点的是不是左子节点,一直向上寻找父节点，一直到是某一个节点的子节点
					while (temp.parent != temp.parent.parent.lchild) {
						if (temp.parent.parent == root) {
							return null;
						}
						temp = temp.parent;
					}
					return temp.parent.parent;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println("test1--");
		test1();
		System.out.println("test2--");
		test2();
		System.out.println("test3--");
		test3();
		System.out.println("test4--");
		test4();
	}

	// 树只有一个根节点时
	public static void test1() {
		// ............1...............................................................
		BinaryTreeNode root = new BinaryTreeNode(1);
		System.out.println("root的下一个节点:null:" + '\t' + getMyInOrderTraverNexNode(root, root));
	}

	// 树有两个节点，根节点和右子节点
	public static void test2() {
		// ............1...............................................................
		// ........../....\............................................................
		// ...............3...........................................................
		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode N3 = new BinaryTreeNode(3);
		root.rchild = N3;
		N3.parent = root;
		System.out.println("root的下一个节点:3:" + '\t' + getMyInOrderTraverNexNode(root, root).data);
		System.out.println("N3的下一个节点:null:" + '\t' + getMyInOrderTraverNexNode(root, N3));
	}

	// 树有两个节点，根节点和左子节点
	public static void test3() {
		// ............1...............................................................
		// ........../....\............................................................
		// ..........2...............................................................
		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode N2 = new BinaryTreeNode(2);
		root.lchild = N2;
		N2.parent = root;
		System.out.println("root的下一个节点:null:" + '\t' + getMyInOrderTraverNexNode(root, root));
	}

	// 树有多个节点
	public static void test4() {
		// ............1...............................................................
		// ........../....\............................................................
		// .........2......3...........................................................
		// ......./..\.../...\..........................................................
		// ......4...5...6....7.........................................................
		// ...../.....\../......\.......................................................
		// ....8.....9..10......11.......................................................
		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode N2 = new BinaryTreeNode(2);
		BinaryTreeNode N3 = new BinaryTreeNode(3);
		BinaryTreeNode N4 = new BinaryTreeNode(4);
		BinaryTreeNode N5 = new BinaryTreeNode(5);
		BinaryTreeNode N6 = new BinaryTreeNode(6);
		BinaryTreeNode N7 = new BinaryTreeNode(7);
		BinaryTreeNode N8 = new BinaryTreeNode(8);
		BinaryTreeNode N9 = new BinaryTreeNode(9);
		BinaryTreeNode N10 = new BinaryTreeNode(10);
		BinaryTreeNode N11 = new BinaryTreeNode(11);
		root.lchild = N2;
		root.rchild = N3;
		N2.lchild = N4;
		N2.rchild = N5;
		N2.parent = root;
		N3.lchild = N6;
		N3.rchild = N7;
		N3.parent = root;
		N4.lchild = N8;
		N4.parent = N2;
		N5.rchild = N9;
		N5.parent = N2;
		N6.lchild = N10;
		N6.parent = N3;
		N7.rchild = N11;
		N7.parent = N3;
		N8.parent = N4;
		N9.parent = N5;
		N10.parent = N6;
		N11.parent = N7;
		System.out.println("N11的下一个节点:null" + '\t' + getMyInOrderTraverNexNode(root, N11));
		System.out.println("N9的下一个节点:1" + '\t' + getMyInOrderTraverNexNode(root, N9).data);
		System.out.println("N2的下一个节点:5" + '\t' + getMyInOrderTraverNexNode(root, N2).data);
		System.out.println("N8的下一个节点:4" + '\t' + getMyInOrderTraverNexNode(root, N8).data);
		System.out.println("N3的下一个节点:7" + '\t' + getMyInOrderTraverNexNode(root, N3).data);
	}
}
