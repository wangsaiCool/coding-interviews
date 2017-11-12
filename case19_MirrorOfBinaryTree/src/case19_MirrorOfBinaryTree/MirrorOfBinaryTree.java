package case19_MirrorOfBinaryTree;

public class MirrorOfBinaryTree {

	// 完成二叉树的镜像操作
	public static void MirrorTree(BinaryTreeNode root) {
		BinaryTreeNode tmpNode = null;
		if (root == null) {
			return;
		}
		if (root.lchild == null && root.rchild == null)
			return;
		tmpNode = root.lchild;
		root.lchild = root.rchild;
		root.rchild = tmpNode;
		MirrorTree(root.lchild);
		MirrorTree(root.rchild);
	}

	// *****TestCase start*****//
	// 先序遍历二叉树
	public static void printTree(BinaryTreeNode btn) {
		if (btn == null)
			return;
		System.out.print(btn.data + " ");
		printTree(btn.lchild);
		printTree(btn.rchild);
	}

	/**
	 * 二叉树的镜像
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 8
		// / \
		// 6 10
		// / \ / \
		// 5 7 9 11
		BinaryTreeNode root = new BinaryTreeNode();
		root.data = 8;
		root.lchild = new BinaryTreeNode();
		root.lchild.data = 6;
		root.lchild.lchild = new BinaryTreeNode();
		root.lchild.lchild.data = 5;
		root.lchild.rchild = new BinaryTreeNode();
		root.lchild.rchild.data = 7;
		root.rchild = new BinaryTreeNode();
		root.rchild.data = 10;
		root.rchild.lchild = new BinaryTreeNode();
		root.rchild.lchild.data = 9;
		root.rchild.rchild = new BinaryTreeNode();
		root.rchild.rchild.data = 11;
		printTree(root);
		System.out.println();
		MirrorTree(root);
		printTree(root);
		// 1
		// /
		// 3
		// /
		// 5
		// /
		// 7
		// /
		// 9
		BinaryTreeNode root2 = new BinaryTreeNode();
		root2.data = 1;
		root2.lchild = new BinaryTreeNode();
		root2.lchild.data = 3;
		root2.lchild.lchild = new BinaryTreeNode();
		root2.lchild.lchild.data = 5;
		root2.lchild.lchild.lchild = new BinaryTreeNode();
		root2.lchild.lchild.lchild.data = 7;
		root2.lchild.lchild.lchild.lchild = new BinaryTreeNode();
		root2.lchild.lchild.lchild.lchild.data = 9;
		System.out.println("\n");
		printTree(root2);
		System.out.println();
		MirrorTree(root2);
		printTree(root2);

		// 0
		// \
		// 2
		// \
		// 4
		// \
		// 6
		// \
		// 8
		BinaryTreeNode root3 = new BinaryTreeNode();
		root3.data = 0;
		root3.rchild = new BinaryTreeNode();
		root3.rchild.data = 2;
		root3.rchild.rchild = new BinaryTreeNode();
		root3.rchild.rchild.data = 4;
		root3.rchild.rchild.rchild = new BinaryTreeNode();
		root3.rchild.rchild.rchild.data = 6;
		root3.rchild.rchild.rchild.rchild = new BinaryTreeNode();
		root3.rchild.rchild.rchild.rchild.data = 8;
		System.out.println("\n");
		printTree(root3);
		System.out.println();
		MirrorTree(root3);
		printTree(root3);
	}
	// *****TestCase end*****//
}
