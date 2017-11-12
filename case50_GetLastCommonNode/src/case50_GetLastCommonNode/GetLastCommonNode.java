package case50_GetLastCommonNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * 题目：输入树的两个结点，求他们的最低公共祖先。
 * 
 * @author WangSai
 *
 */
public class GetLastCommonNode {

	/**
	 * 1>:若树是二叉搜索树，则可以根据这个两个结点和二叉搜索的的特点遍历完成。
	 * 
	 * @param root,二叉树的根节点
	 * @param node1，二叉树中的指定节点
	 * @param node2，二叉树中的指定节点
	 * @return 二叉树中的最低公共祖先
	 */
	private TreeNode getMyNode1(TreeNode root, TreeNode node1, TreeNode node2) {
		// 异常值检测
		if (root == null)
			return null;
		// 递归调用，判断。
		// 当树中当前节点的值大于node1和node2的值得时候，最低公共祖先在左子节点中。
		if (root.data > node1.data && root.data > node2.data) {
			return getMyNode1(root.lchild, node1, node2);
		}
		// 当树中当前节点的值小于node1和node2的值得时候，最低公共祖先在右子节点中。
		else if (root.data < node1.data && root.data < node2.data) {
			return getMyNode1(root.rchild, node1, node2);
		}
		// 当树中当前节点的值介于node1和node2的值之间的时候，该节点就是最低公共祖先。
		else if ((root.data >= node1.data && root.data <= node2.data)
				|| (root.data <= node1.data && root.data >= node2.data)) {
			return root;
		}
		return null;
	}

	/**
	 * 2>:若树是普通树，但是有指向父节点的parent指针。这种问题可以转换成求链表的第一个公共节点的问题。
	 * 
	 * @param root,二叉树的根节点
	 * @param node1，二叉树中的指定节点
	 * @param node2，二叉树中的指定节点
	 * @return 二叉树中的最低公共祖先
	 */
	private TreeNode getMyNode2(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null)
			return null;
		// 创建辅助栈1
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		while (node1 != null) {
			stack1.push(node1);
			node1 = node1.parent;
		}
		// 创建辅助栈2
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		while (node2 != null) {
			stack2.push(node2);
			node2 = node2.parent;
		}
		while (stack1.size() > 0 && stack2.size() > 0) {
			TreeNode tmp1 = stack1.pop();
			TreeNode tmp2 = stack2.pop();

			if (tmp2.data == tmp1.data) {
				return tmp1;
			}
		}
		return null;
	}

	/**
	 * 3>:若树是普通树，没有指向父节点的parent指针。我们可以从头根节点开始遍历，然后把包含node1和node2节点的路径保存下来。然后，
	 * 可以转换成求链表的第一个公共节点的问题。
	 * 
	 * @param root,二叉树的根节点
	 * @param node1，二叉树中的指定节点
	 * @param node2，二叉树中的指定节点
	 * @return 二叉树中的最低公共祖先
	 */
	private static TreeNode getMyNode3(TreeNode root, TreeNode node1, TreeNode node2) {
		// 异常值检测
		if (root == null)
			return null;
		// 辅助空间保存包含node1的路径
		ArrayList<TreeNode> list1 = new ArrayList<TreeNode>();
		// 辅助空间保存包含node2的路径
		ArrayList<TreeNode> list2 = new ArrayList<TreeNode>();
		// 寻找存在node1在以root为根节点的树中的路径
		findPath(root, node1, list1);
		// 寻找存在node2在以root为根节点的树中的路径
		findPath(root, node2, list2);
		// 把list1中保存的节点入栈
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Iterator<TreeNode> ite1 = list1.iterator();
		while (ite1.hasNext()) {
			stack1.push(ite1.next());
		}
		// 把list2中保存的节点入栈
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		Iterator<TreeNode> ite2 = list2.iterator();
		while (ite2.hasNext()) {
			stack2.push(ite2.next());
		}
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			TreeNode n1 = stack1.pop();
			TreeNode n2 = stack2.pop();
			if (n1 == n2)
				return n1;
		}
		return null;
	}

	/**
	 * 以root为根节点的树包含node节点的路径。
	 * 
	 * @param root,树的根节点
	 * @param node，树中的节点
	 * @param list,保存包含node1的路径
	 */
	private static void findPath(TreeNode root, TreeNode node, ArrayList<TreeNode> list) {
		if (root == null)
			return;
		list.add(root);
		if (root != node) {
			if (root.lchild == null && root.rchild == null && root.mchild == null) {
				list.remove(list.size() - 1);
				return;
			} else {
				findPath(root.lchild, node, list);
				for (TreeNode temp : list) {
					if (temp == node)
						return;
				}
				findPath(root.rchild, node, list);
				for (TreeNode temp : list) {
					if (temp == node)
						return;
				}
				findPath(root.mchild, node, list);
				for (TreeNode temp : list) {
					if (temp == node)
						return;
				}
				list.remove(list.size() - 1);
			}
		} else if (root == node) {
			return;
		}
	}

	public static void main(String[] args) {
		test1();
		test2();
	}

	/**
	 * 普通二叉树
	 * ..............1..............................................................
	 * ........../.......\...........................................................
	 * .........2.........3..........................................................
	 * ......./..\......./..\.........................................................
	 * ......4...5......6....7.......................................................
	 * ...../.../..\......./.|.\....................................................
	 * ....8...12..9......13.10.11...................................................
	 */
	private static void test1() {
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		TreeNode n11 = new TreeNode(11);
		TreeNode n12 = new TreeNode(12);
		TreeNode n13 = new TreeNode(13);

		root.lchild = n2;
		root.rchild = n3;
		n2.lchild = n4;
		n2.rchild = n5;
		n3.lchild = n6;
		n3.rchild = n7;
		n4.lchild = n8;
		n5.rchild = n9;
		n5.lchild = n12;
		n7.rchild = n11;
		n7.lchild = n13;
		n7.mchild = n10;

		System.out.print("普通二叉树，最低公共祖先为 1 ：");
		TreeNode node1 = getMyNode3(root, n8, n11);
		System.out.println(node1.data);
		System.out.print("普通树，最低公共祖先为 7 ：");
		TreeNode node2 = getMyNode3(root, n13, n11);
		System.out.println(node2.data);
		System.out.print("普通树n11为树中的节点，另一个节点为null，最低公共祖先为 null ：");
		TreeNode node3 = getMyNode3(root, null, n11);
		System.out.println(node3);
	}

	/**
	 * 退化二叉树
	 * ..............1..............................................................
	 * ........../..................................................................
	 * .........2...................................................................
	 * ......./......................................................................
	 * ......4.......................................................................
	 * ...../.......................................................................
	 * ....8.........................................................................
	 */
	private static void test2() {
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n4 = new TreeNode(4);
		TreeNode n8 = new TreeNode(8);

		root.lchild = n2;
		n2.lchild = n4;
		n2.rchild = n8;

		System.out.print("退化为斜树，最低公共祖先为 2 ：");
		TreeNode node1 = getMyNode3(root, n8, n4);
		System.out.println(node1.data);
	}
}
