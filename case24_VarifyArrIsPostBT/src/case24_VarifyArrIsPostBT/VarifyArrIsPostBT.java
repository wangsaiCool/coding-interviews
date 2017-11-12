package case24_VarifyArrIsPostBT;

public class VarifyArrIsPostBT {
	/**
	 * 题目：
	 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后续遍历的结果。如果是返回true，否则返回false。假设输入的数组的任意两个数字都不相同。
	 * 
	 * @param args
	 */

	// 采用递归的方式
	public static boolean VarifyPBT(int[] arr) {
		if (arr == null || arr.length < 1)
			return false;
		int low = 0;
		int high = arr.length - 1;
		return isPostBinaryTree(arr, low, high);
	}

	public static boolean isPostBinaryTree(int[] arr, int low, int high) {
		if (low >= high)
			return true;

		// arr序列的最后一个数字是后续遍历二叉树的根节点
		int root = arr[high];
		int i = low;

		// 判断 左子树序列 [low,i-1]是左子树
		for (; i < high; i++) {
			if (arr[i] > root)
				break;
		}

		// 判断 右子树序列 [i,high-1]是右子树
		int j = i;
		for (; j < high; j++) {
			if (arr[j] < root)
				return false;
		}

		// 递归左子树
		boolean left = isPostBinaryTree(arr, low, i - 1);

		// 递归右子树
		boolean right = isPostBinaryTree(arr, i, high - 1);

		return left && right;
	}

	// ****test case start*****//
	public static void main(String[] args) {
		// 10
		// / \
		// 6 14
		// /\ /\
		// 4 8 12 16
		int[] data = { 4, 8, 6, 12, 16, 14, 10 };
		System.out.println("true: " + VarifyPBT(data));

		// 5
		// / \
		// 4 7
		// /
		// 6
		int[] data2 = { 4, 6, 7, 5 };
		System.out.println("true: " + VarifyPBT(data2));

		// 5
		// /
		// 4
		// /
		// 3
		// /
		// 2
		// /
		// 1
		int[] data3 = { 1, 2, 3, 4, 5 };
		System.out.println("true: " + VarifyPBT(data3));

		// 1
		// \
		// 2
		// \
		// 3
		// \
		// 4
		// \
		// 5
		int[] data4 = { 5, 4, 3, 2, 1 };
		System.out.println("true: " + VarifyPBT(data4));

		// 树中只有1个结点
		int[] data5 = { 5 };
		System.out.println("true: " + VarifyPBT(data5));

		int[] data6 = { 7, 4, 6, 5 };
		System.out.println("false: " + VarifyPBT(data6));

		int[] data7 = { 4, 6, 12, 8, 16, 14, 10 };
		System.out.println("false: " + VarifyPBT(data7));
	}
	// ****test case end*****//

}
