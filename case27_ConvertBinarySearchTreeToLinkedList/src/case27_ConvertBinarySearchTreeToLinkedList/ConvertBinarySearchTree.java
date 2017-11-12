package case27_ConvertBinarySearchTreeToLinkedList;

/**
 * 题目：输入一棵二叉搜索树，将该二叉树转换成一个排序的双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 比如输入下图的二叉搜索树，则输出转换之后的排序双向链表。
 * 
 * ..............10...............................................................
 * ........../.......\............................................................
 * .........6..........14...........................................................
 * ......./...\....../....\........................................................
 * ......4.....8....12......16.......................................................
 * 
 * 转换之后的排序双向链表：4<==>6<==>8<==>10<==>12<==>14<==>16。
 * 
 * @author WangSai
 *
 */
public class ConvertBinarySearchTree {

	private static TreeNode myConvert(TreeNode root) {
		// 异常检测
		if (root == null)
			return null;
		// 保存上一次的处理节点
		TreeNode[] lastNode = new TreeNode[1];
		// 中序遍历
		myConvertCore(root, lastNode);
		TreeNode temp = lastNode[0];
		// System.out.println(temp.data); //遍历完成之后，lastNode[0]指向原树的最后一个节点
		// 寻找新链表的头结点
		while (temp.lchild != null) {
			temp = temp.lchild;
		}
		return temp;
	}

	/**
	 * 采用中序遍历的方式完成。递归调用。
	 * 
	 * @param root，当前处理的结点
	 * @param lastNode，上一次处理的结点。使用数组时因为数组在堆里存放着，是共享的。
	 */
	private static void myConvertCore(TreeNode root, TreeNode[] lastNode) {
		// 递归停止条件
		if (root == null)
			return;
		// 递归当前节点的左子树
		myConvertCore(root.lchild, lastNode);
		// 当前节点的lchild指向上一个结点，即root的前驱节点指向上一次的节点
		root.lchild = lastNode[0];
		if (lastNode[0] != null) {
			// 前一个节点的后驱节点指向当前节点。
			lastNode[0].rchild = root;
		}
		// 当前处理的节点作为下一次处理结点的上一个结点。
		lastNode[0] = root;
		// 递归右子树
		myConvertCore(root.rchild, lastNode);
	}

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	/**
	 * 普通二叉树：
	 * ..............10...............................................................
	 * ........../.......\............................................................
	 * .........6..........14...........................................................
	 * ......./...\....../....\........................................................
	 * ......4.....8....12......16.......................................................
	 * 
	 */
	public static void test1() {
		TreeNode root = new TreeNode(10);
		TreeNode n6 = new TreeNode(6);
		TreeNode n14 = new TreeNode(14);
		TreeNode n4 = new TreeNode(4);
		TreeNode n8 = new TreeNode(8);
		TreeNode n12 = new TreeNode(12);
		TreeNode n16 = new TreeNode(16);
		root.lchild = n6;
		root.rchild = n14;
		n6.lchild = n4;
		n6.rchild = n8;
		n14.lchild = n12;
		n14.rchild = n16;
		TreeNode head = myConvert(root);
		System.out.println("-----普通二叉树--start---");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.rchild;
		}
		System.out.println();
		System.out.println("-----普通二叉树--end---");
	}

	/**
	 * 斜二叉树：
	 * ..............10...............................................................
	 * ........../...................................................................
	 * .........6.....................................................................
	 * ......./.....................................................................
	 * ......4.....................................................................
	 * 
	 */
	public static void test2() {
		TreeNode root = new TreeNode(10);
		TreeNode n6 = new TreeNode(6);
		TreeNode n4 = new TreeNode(4);
		root.lchild = n6;
		n6.lchild = n4;
		TreeNode head = myConvert(root);
		System.out.println("-----斜二叉树--start---");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.rchild;
		}
		System.out.println();
		System.out.println("-----斜二叉树--end---");
	}

	/**
	 * 只有一个节点的二叉树：
	 * ..............10...............................................................
	 * 
	 */
	public static void test3() {
		TreeNode root = new TreeNode(10);
		TreeNode head = myConvert(root);
		System.out.println("-----只有根节点二叉树--start---");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.rchild;
		}
		System.out.println();
		System.out.println("-----只有根节点二叉树--end---");
	}

	/**
	 * 二叉树null：
	 * 
	 */
	public static void test4() {
		TreeNode root = null;
		TreeNode head = myConvert(root);
		System.out.println("----null--start---");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.rchild;
		}
		System.out.println();
		System.out.println("----null--end---");
	}

}
