package case06_ConstructBinaryTree;

public class ConstructBinaryTree {

	/**
	 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含有重复的数字。 例如：
	 * 输入的前序遍历序列{1,2,4,7,3,5,6,8} 输入的后序遍历序列{4,7,2,1,5,3,8,6} 重建出如下二叉树，并且输出其头结点。
	 * 1 / \ 2 3 / / \ 4 5 6 \ / 7 8
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		test1();
		System.out.println();
		test2();
		System.out.println();
		test3();
		System.out.println();
		test4();
		System.out.println();
		test5();
		System.out.println();
		test6();
		System.out.println();
		test7();
		System.out.println();
	}

	/**
	 * 
	 * @param preArr
	 *            前序遍历序列
	 * @param inArr
	 *            中序遍历序列
	 * @return 重建二叉树的头结点
	 */
	public static BinaryTreeNode construct(int[] preArr, int[] inArr) {
		// 输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同
		if (preArr == null || inArr == null || preArr.length != inArr.length || preArr.length < 1)
			return null;
		return constructTree(preArr, 0, preArr.length - 1, inArr, 0, inArr.length - 1);
	}

	/**
	 * 
	 * @param preArr
	 *            前序遍历序列
	 * @param pStartIndex
	 *            前序遍历的开始位置
	 * @param pEndIndex
	 *            前序遍历的结束位置
	 * @param inArr
	 *            中遍历序列
	 * @param iStartIndex
	 *            中序遍历的开始位置
	 * @param iEndIndex
	 *            中序遍历的结束位置
	 * @return root 二叉树的根节点
	 */
	public static BinaryTreeNode constructTree(int[] preArr, int pStartIndex, int pEndIndex, int[] inArr,
			int iStartIndex, int iEndIndex) {

		BinaryTreeNode root = new BinaryTreeNode();
		// 开始位置大于结束位置说明已经没有需要处理的元素了
		if (pStartIndex > pEndIndex)
			return null;
		// 取前序遍历的第一个数字，就是当前的根结点
		root.data = preArr[pStartIndex];
		int index = iStartIndex;
		while (index <= iEndIndex && inArr[index] != root.data) {
			index++;
		}
		if (index > iEndIndex)
			throw new RuntimeException("input invalid.");

		// 递归构建当前根结点的左子树，左子树的元素个数：index-iStartIndex 个
		// 左子树对应的前序遍历的位置在[pStartIndex+1, pStartIndex+index-iStartIndex]
		// 左子树对应的中序遍历的位置在[iStartIndex, index-1]
		root.lchild = constructTree(preArr, pStartIndex + 1, index - iStartIndex + pStartIndex, inArr, iStartIndex,
				index - 1);
		// 递归构建当前根结点的右子树，右子树的元素个数：iEndIndex-index个
		// 右子树对应的前序遍历的位置在[pStartIndex+index-iStartIndex+1, pEndIndex]
		// 右子树对应的中序遍历的位置在[index+1, iEndIndex]
		root.rchild = constructTree(preArr, pStartIndex + index - iStartIndex + 1, pEndIndex, inArr, index + 1,
				iEndIndex);

		return root;
	}

	// *****测试start*****//

	// 中序遍历二叉树
	public static void printTree(BinaryTreeNode btn) {
		if (btn != null) {
			printTree(btn.lchild);
			System.out.print(btn.data + " ");
			printTree(btn.rchild);
		}
	}

	// 普通二叉树
	// 1
	// / \
	// 2 3
	// / / \
	// 4 5 6
	// \ /
	// 7 8
	private static void test1() {
		int[] preArr = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inArr = { 4, 7, 2, 1, 5, 3, 8, 6 };
		BinaryTreeNode root = construct(preArr, inArr);
		printTree(root);
	}

	// 所有结点都没有右子结点
	// 1
	// /
	// 2
	// /
	// 3
	// /
	// 4
	// /
	// 5
	private static void test2() {
		int[] preArr = { 1, 2, 3, 4, 5 };
		int[] inArr = { 5, 4, 3, 2, 1 };
		BinaryTreeNode root = construct(preArr, inArr);
		printTree(root);
	}

	// 所有结点都没有左子结点
	// 1
	// \
	// 2
	// \
	// 3
	// \
	// 4
	// \
	// 5
	private static void test3() {
		int[] preArr = { 1, 2, 3, 4, 5 };
		int[] inArr = { 1, 2, 3, 4, 5 };
		BinaryTreeNode root = construct(preArr, inArr);
		printTree(root);
	}

	// 树中只有一个结点
	private static void test4() {
		int[] preArr = { 1 };
		int[] inArr = { 1 };
		BinaryTreeNode root = construct(preArr, inArr);
		printTree(root);
	}

	// 完全二叉树
	// 1
	// / \
	// 2 3
	// / \ / \
	// 4 5 6 7
	private static void test5() {
		int[] preArr = { 1, 2, 4, 5, 3, 6, 7 };
		int[] inArr = { 4, 2, 5, 1, 6, 3, 7 };
		BinaryTreeNode root = construct(preArr, inArr);
		printTree(root);
	}

	// 输入空指针
	private static void test6() {
		construct(null, null);
	}

	// 输入的两个序列不匹配
	private static void test7() {
		int[] preorder = { 1, 2, 4, 5, 3, 6, 7 };
		int[] inorder = { 4, 2, 8, 1, 6, 3, 7 };
		BinaryTreeNode root = construct(preorder, inorder);
		printTree(root);
	}

	// *****测试 end*****//
}
