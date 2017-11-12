package case25_FindPathInTree;

/**
 * 题目：题目：输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
import java.util.ArrayList;

public class FindMyPath {

	private void findThePath(MyNode root, int expectedSum) {
		// 异常值检测
		if (root == null)
			throw new IllegalArgumentException("非法参数");
		ArrayList<Integer> mylist = new ArrayList<>();
		// 递归实现当前节点和上一个节点求和，并且记录当前节点到容器中
		findThePathCore(root, 0, expectedSum, mylist);
	}

	/**
	 * 
	 * @param root,二叉树根节点
	 * @param currentSum,当前记录的和（还未加上当前结点的值）
	 * @param expectedSum,期望的和
	 * @param mylist,根结点到当前处理结点的所经过的结点，（还未包括当前结点）
	 */
	private void findThePathCore(MyNode root, int currentSum, int expectedSum, ArrayList<Integer> mylist) {
		// 当前节点不为空的情况下，做处理
		// 求当前节点的值root.data,加上根节点到上一个节点路径上所有节点的值得和
		// 把当前节点放入容器mylist中
		// 判断目前为止求得的currentsum的值
		// 若 < expectedSum，则继续递归左右子节点
		// 若 == expectedSum,判断是否==expectedSum，如果当前节点是子节点，则打印路径
		// 执行到这一步说明，打印完成或者当前路径不满足条件，则应该删除最后一个进入容器的元素。
		if (root == null)
			return;
		currentSum += root.data;
		mylist.add(root.data);
		if (currentSum < expectedSum) {
			findThePathCore(root.lchild, currentSum, expectedSum, mylist);
			findThePathCore(root.rchild, currentSum, expectedSum, mylist);

		} else if (currentSum == expectedSum) {
			if (root.lchild == null && root.rchild == null)
				System.out.println(mylist.toString());
		}
		// 删除最后进入容器的元素
		mylist.remove(mylist.size() - 1);
	}

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	// 普通二叉树，有满足条件的值
	// 1
	// / \
	// 2 3
	private static void test1() {
		FindMyPath fmp = new FindMyPath();
		MyNode N1 = new MyNode(1);
		MyNode N2 = new MyNode(2);
		MyNode N3 = new MyNode(3);
		N1.lchild = N2;
		N1.rchild = N3;
		System.out.println("普通二叉树，有	满足条件的值:");
		fmp.findThePath(N1, 3);
	}

	// 普通二叉树，没有满足条件的值
	private static void test2() {
		FindMyPath fmp = new FindMyPath();
		MyNode N1 = new MyNode(1);
		MyNode N2 = new MyNode(2);
		MyNode N3 = new MyNode(3);
		N1.lchild = N2;
		N1.rchild = N3;
		System.out.println("普通二叉树，没有	 满足条件的值:");
		fmp.findThePath(N1, 10);
	}

	// 只有一个节点的二叉树， 有 满足条件的值
	private static void test3() {
		FindMyPath fmp = new FindMyPath();
		MyNode N1 = new MyNode(1);
		System.out.println("只有一个节点的二叉树， 有	 满足条件的值:");
		fmp.findThePath(N1, 1);
	}

	// 只有一个节点的二叉树， 没有 满足条件的值
	private static void test4() {
		FindMyPath fmp = new FindMyPath();
		MyNode N1 = new MyNode(1);
		System.out.println("只有一个节点的二叉树， 没有	 满足条件的值:");
		fmp.findThePath(N1, 10);
	}

}
