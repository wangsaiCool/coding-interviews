package case63_KthNodeOfBST;

/**
 * 题目：给定一棵二叉搜索树，请找出其中的第K大的结点。例如在下图的二叉搜索树中，按节点数值大小顺序第三个结点的值是4
 * ............5...............................................................
 * ........../....\............................................................
 * .........3......7...........................................................
 * ......./..\.../...\..........................................................
 * ......2...4...6....8.........................................................
 * 
 * 
 * @author WangSai
 *
 */

public class KthNodeOfBST {

	public static void main(String[] args) {
		KthNodeOfBST kno = new KthNodeOfBST();
		MyNode root = new MyNode(5);
		MyNode N2 = new MyNode(3);
		MyNode N3 = new MyNode(7);
		MyNode N4 = new MyNode(2);
		MyNode N5 = new MyNode(4);
		MyNode N6 = new MyNode(6);
		MyNode N7 = new MyNode(8);
		root.lchild = N2;
		root.rchild = N3;
		N2.lchild = N4;
		N2.rchild = N5;
		N3.lchild = N6;
		N3.rchild = N7;
		System.out.println(kno.findKthOfBST(root, 6).data);

	}

	/**
	 * 二叉搜索树的左子节<父节点<右子节点，根据中序遍历，即可进行排序并获取第K个节点。
	 * 
	 * @param root，二叉搜索树的根节点
	 * @param k，k值
	 * @return 第k个二叉树节点
	 */
	private MyNode findKthOfBST(MyNode root, int k) {
		// 异常值检测
		if (root == null || k <= 0)
			throw new IllegalArgumentException("非法输入参数，请重新检查...");
		int[] temp = { k };
		// 采用中序遍历的方法，便可以得到第K大的值
		return findKthOfBSTCore(root, temp);
	}

	// 通过中序遍历二叉树
	private MyNode findKthOfBSTCore(MyNode root, int[] temp) {
		MyNode tempNode = null;
		if (root == null)
			return null;
		// 先在左子树中遍历
		tempNode = findKthOfBSTCore(root.lchild, temp);
		// 左子树中没有找到
		if (tempNode == null) {
			// 当前的根结点是所要找的结点
			if (temp[0] == 1)
				return root;
			// 当前的根结点不是要找的结点，但是已经找过了，所以计数器减一
			else
				temp[0]--;
		}
		// 左子树中没有找到，并且当前节点不是所要找的点，寻找右子节点
		if (tempNode == null)
			tempNode = findKthOfBSTCore(root.rchild, temp);
		return tempNode;
	}

}
