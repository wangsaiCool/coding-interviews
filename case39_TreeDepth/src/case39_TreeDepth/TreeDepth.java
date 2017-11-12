package case39_TreeDepth;

/**
 * 题目1：输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * 
 * @author WangSai
 *
 */
public class TreeDepth {

	/**
	 * 通过遍历，获取二叉树的深度
	 * 
	 * @param root二叉树的根节点
	 * @return 二叉树的深度
	 */
	private int getTreeDepth(myTreeNode root) {
		if (root == null)
			return 0;
		int left = getTreeDepth(root.lchild);
		int right = getTreeDepth(root.rchild);
		return left > right ? (left + 1) : (right + 1);
	}

	public static void main(String[] args) {
		// 普通二叉树
		test1();
		// 斜二叉树
		test2();
		// 只有一个节点
		test3();
		// 头结点为null
		test4();
	}

	// 普通二叉树
	private static void test1() {
		TreeDepth td = new TreeDepth();
		myTreeNode root = new myTreeNode(1);
		myTreeNode N2 = new myTreeNode(2);
		myTreeNode N3 = new myTreeNode(3);
		myTreeNode N4 = new myTreeNode(4);
		myTreeNode N5 = new myTreeNode(5);
		root.lchild = N2;
		root.rchild = N3;
		N2.lchild = N4;
		N2.rchild = N5;
		System.out.println(td.getTreeDepth(root));
	}

	// 斜二叉树
	private static void test2() {
		TreeDepth td = new TreeDepth();
		myTreeNode root = new myTreeNode(1);
		myTreeNode N2 = new myTreeNode(2);
		myTreeNode N4 = new myTreeNode(4);
		root.lchild = N2;
		N2.lchild = N4;
		System.out.println(td.getTreeDepth(root));
	}

	// 只有一个节点
	private static void test3() {
		TreeDepth td = new TreeDepth();
		myTreeNode root = new myTreeNode(1);
		System.out.println(td.getTreeDepth(root));
	}

	// 头结点为null
	private static void test4() {
		TreeDepth td = new TreeDepth();
		System.out.println(td.getTreeDepth(null));
	}
}
