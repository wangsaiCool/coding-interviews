package case39_IsBalanceTree;

import case39_TreeDepth.myTreeNode;

/**
 * 题目2：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任一结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * 
 * 
 */
public class IsBalanceTree {

	/**
	 * @param root二叉树的根节点
	 * @return true表示该树是平衡二叉树
	 */
	private static boolean isItBalance1(myTreeNode root) {
		if (root == null)
			return true;
		// 获取root节点的左右子树的深度
		int left = getTreeDepth(root.lchild);
		int right = getTreeDepth(root.rchild);
		int dif = left - right;
		if (dif < -1 || dif > 1)
			return false;
		else
			return isItBalance1(root.lchild) && isItBalance1(root.rchild);
	}

	/**
	 * 第1种解法
	 * 
	 * @param root二叉树的根节点
	 * @return 二叉树的深度
	 */
	// 获取某节点的子树深度
	private static int getTreeDepth(myTreeNode root) {
		// 递归终止条件
		if (root == null)
			return 0;
		// 当前节点的左子树深度
		int left = getTreeDepth(root.lchild);
		// 当前节点的右子树深度
		int right = getTreeDepth(root.rchild);
		// 当前节点左右子树，深度大的那个节点深度值+1，即是当前节点的节点深度。
		return left > right ? left + 1 : right + 1;

	}

	/**
	 * 第2种解法：用后序遍历的方式遍历二叉树的每一个结点，在遍历到一个结点之前我们就已经遍历了它的左右子树。
	 * 只要在遍历每个结点的时候记录它的深度（某一结点的深度等于它到叶节点的路径的长度），我们就可以一边遍历一边判断每个结点是不是平衡的。
	 * 
	 * //后序遍历二叉树
	 * 
	 * @param args
	 */

	private static boolean isItBalance2(myTreeNode root) {
		int[] depth = new int[1];
		return isItBalance2Core(root, depth);

	}

	private static boolean isItBalance2Core(myTreeNode root, int[] depth) {
		// 节点为null
		if (root == null) {
			depth[0] = 0;
			return true;
		}
		// 判断当前节点的左右子树是否为平衡二叉树，并且计算当前root节点的深度。
		// 计算方法：通过保存并获取root左右子树的深度值较大的值，然后+1，即是当前节点的深度。
		int[] left = new int[1];
		int[] right = new int[1];
		if (isItBalance2Core(root.lchild, left) && isItBalance2Core(root.rchild, right)) {
			int dif = left[0] - right[0];
			if (dif >= -1 && dif <= 1) {
				depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("-----test1()-----:");
		test1();
		System.out.println("-----test2()-----:");
		test2();
		System.out.println("-----test3()-----:");
		test3();
		System.out.println("-----test4()-----:");
		test4();
		System.out.println("-----test5()-----:");
		test5();
	}

	// 完全二叉树
	// 1
	// / \
	// 2 3
	// /\ / \
	// 4 5 6 7
	private static void test1() {
		myTreeNode n1 = new myTreeNode(1);
		myTreeNode n2 = new myTreeNode(2);
		myTreeNode n3 = new myTreeNode(3);
		myTreeNode n4 = new myTreeNode(4);
		myTreeNode n5 = new myTreeNode(5);
		myTreeNode n6 = new myTreeNode(6);
		myTreeNode n7 = new myTreeNode(7);
		n1.lchild = n2;
		n1.rchild = n3;
		n2.lchild = n4;
		n2.rchild = n5;
		n3.lchild = n6;
		n3.rchild = n7;
		System.out.println(isItBalance1(n1));
		System.out.println(isItBalance2(n1));

	}

	// 不是完全二叉树，但是平衡二叉树
	// 1
	// / \
	// 2 3
	// /\ \
	// 4 5 6
	// /
	// 7
	private static void test2() {
		myTreeNode n1 = new myTreeNode(1);
		myTreeNode n2 = new myTreeNode(2);
		myTreeNode n3 = new myTreeNode(3);
		myTreeNode n4 = new myTreeNode(4);
		myTreeNode n5 = new myTreeNode(5);
		myTreeNode n6 = new myTreeNode(6);
		myTreeNode n7 = new myTreeNode(7);
		n1.lchild = n2;
		n1.rchild = n3;
		n2.lchild = n4;
		n2.rchild = n5;
		n5.lchild = n7;
		n3.rchild = n6;
		System.out.println(isItBalance1(n1));
		System.out.println(isItBalance2(n1));
	}

	// 不是平衡二叉树
	// 1
	// / \
	// 2 3
	// /\
	// 4 5
	// /
	// 7
	private static void test3() {
		myTreeNode n1 = new myTreeNode(1);
		myTreeNode n2 = new myTreeNode(2);
		myTreeNode n3 = new myTreeNode(3);
		myTreeNode n4 = new myTreeNode(4);
		myTreeNode n5 = new myTreeNode(5);
		// myTreeNode n6 = new myTreeNode(6);
		myTreeNode n7 = new myTreeNode(7);
		n1.lchild = n2;
		n1.rchild = n3;
		n2.lchild = n4;
		n2.rchild = n5;
		n5.lchild = n7;
		System.out.println(isItBalance1(n1));
		System.out.println(isItBalance2(n1));
	}

	// 1
	// /
	// 2
	// /
	// 3
	// /
	// 4
	// /
	// 5
	private static void test4() {
		myTreeNode n1 = new myTreeNode(1);
		myTreeNode n2 = new myTreeNode(2);
		myTreeNode n3 = new myTreeNode(3);
		myTreeNode n4 = new myTreeNode(4);
		myTreeNode n5 = new myTreeNode(5);
		// myTreeNode n6 = new myTreeNode(6);
		// myTreeNode n7 = new myTreeNode(7);
		n1.lchild = n2;
		n2.lchild = n3;
		n3.lchild = n4;
		n4.lchild = n5;
		System.out.println(isItBalance1(n1));
		System.out.println(isItBalance2(n1));
	}

	// 1
	// \
	// 2
	// \
	// 3
	// \
	// 4
	// \
	// 5
	private static void test5() {
		myTreeNode n1 = new myTreeNode(1);
		myTreeNode n2 = new myTreeNode(2);
		myTreeNode n3 = new myTreeNode(3);
		myTreeNode n4 = new myTreeNode(4);
		myTreeNode n5 = new myTreeNode(5);
		// myTreeNode n6 = new myTreeNode(6);
		// myTreeNode n7 = new myTreeNode(7);
		n1.rchild = n2;
		n2.rchild = n3;
		n3.rchild = n4;
		n4.rchild = n5;
		System.out.println(isItBalance1(n1));
		System.out.println(isItBalance2(n1));
	}
}
