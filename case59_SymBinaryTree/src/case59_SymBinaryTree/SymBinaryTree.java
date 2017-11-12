package case59_SymBinaryTree;

/**
 * 对称的二叉树。题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 例如，在下图中三棵二叉树中，第一棵二叉树是对称的，而另外两棵不是。
 * 
 * ............1........................1........................7............
 * ........../....\.................../....\.................../....\.........
 * .........2......2.................2......3.................7......7........
 * ......./..\.../...\............./..\.../...\............./..\.../...\......
 * ......4...5...5....4...........4...5...6....7...........7...7...7....7.....
 * ...../.....\../......\......../.....\../......\......../.....\../..........
 * ....8.....9...9......8......8.....9..10......11.......7......7..7..........
 * 
 * @author WangSai
 *
 */
public class SymBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	/**
	 * 前序遍历二叉树的时候，是先遍历左子节点，然后再遍历右子节点。如果我们定义一个前序遍历方法，先遍历右子节点，
	 * 再遍历左子节点（称为对称前序遍历），那么如果用这两种方法遍历同一棵二叉树，那么遍历出来的结果应该是一样的。
	 * 
	 * @param root,待处理的二叉树的根节点
	 * @return 该二叉树是否是对称二叉树
	 */

	private static boolean isSym(BinaryTreeNode root) {
		// 如果根节点为null，认为是对称的。
		if (root == null)
			return true;
		return isSymCore(root.lchild, root.rchild);
	}

	/**
	 * 递归处理
	 * 
	 * @param root1,左子节点
	 * @param root2,右子节点
	 * @return root1和root2,这两个节点是否相同
	 */
	private static boolean isSymCore(BinaryTreeNode root1, BinaryTreeNode root2) {
		// 若对应的点 都 为null，则点相同
		if (root1 == null && root2 == null)
			return true;
		// 若两个节点中，有一个为null，另一个不为null，则肯定不同
		if (root1 == null || root2 == null)
			return false;
		if (root1.data != root2.data)
			return false;
		// 采用前序遍历的方式，对该二叉树进行遍历。有一个进行左子节点为先遍历的前序遍历，有一个为右子节点为先遍历的前序遍历。
		return isSymCore(root1.lchild, root2.rchild) && isSymCore(root1.rchild, root2.lchild);
	}
}
