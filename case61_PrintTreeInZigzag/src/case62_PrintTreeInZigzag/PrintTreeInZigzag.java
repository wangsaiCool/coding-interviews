package case62_PrintTreeInZigzag;

import java.util.Stack;

/**
 * 题目：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二行按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，
 * 其他行以此类推。例如按照之字形打印下图二叉树的结果为：
 * 
 * 1
 * 
 * 3 2
 * 
 * 4 5 6 7
 * 
 * 15 14 13 12 11 10 9 8
 * 
 * ..............1...............................................................
 * ........../.......\............................................................
 * .........2..........3...........................................................
 * ......./...\....../....\........................................................
 * ......4.....5....6......7.......................................................
 * ..../..\../..\../..\..../...\...................................................
 * ...8...9.10..11.12..13.14....15.................................................
 * 
 * @author WangSai
 *
 */
public class PrintTreeInZigzag {
	/**
	 * 利用两个辅助栈，其中一个保存奇数行节点，另一个保存偶数行节点。
	 * 奇数行节点按照从左到右打印，则需要按照从右到左入栈。偶数行节点数据按照从右到左打印，则需要按照从左到右入栈。
	 * 
	 * @param root,待打印二叉树的根节点
	 */
	private void myPrint(MyNode root) {
		// 异常值检测
		if (root == null)
			throw new IllegalArgumentException("非法输入参数，请重新检查...");
		// 创建两个容器分别保存奇数行和偶数行数据
		Stack<MyNode> stackOdd = new Stack<>();
		Stack<MyNode> stackEven = new Stack<>();
		stackOdd.push(root);
		// 创建两个变量，countToBePrint当前行待打印的元素数量;countNextRows下一行的元素数量
		int countToBePrint = 1;
		int countNextRows = 0;
		// 当两个栈都不为null时，说明二叉树还未处理完成。
		while (!stackOdd.empty() || !stackEven.empty()) {
			MyNode tempNode = new MyNode();
			// stackOdd出栈奇数行数据节点,并且打印出栈节点的数据；stackEven入栈偶数行结点
			while (countToBePrint > 0) {
				// stackOdd出栈,并打印出栈节点的数据，当前行待打印的元素数量-1，
				tempNode = stackOdd.pop();
				System.out.print(tempNode.data + " " + '\t');
				countToBePrint--;
				// 把偶数行压栈，并且压入节点之后，元素数量增加。
				if (tempNode.lchild != null) {
					stackEven.push(tempNode.lchild);
					countNextRows++;
				}
				if (tempNode.rchild != null) {
					stackEven.push(tempNode.rchild);
					countNextRows++;
				}
			}
			// 打印完一行之后，换行
			System.out.println();
			countToBePrint = countNextRows;
			countNextRows = 0;
			// stackEven出栈，并且打印出栈节点的数据，stackOdd入栈
			while (countToBePrint > 0) {
				tempNode = stackEven.pop();
				System.out.print(tempNode.data + " " + '\t');
				countToBePrint--;
				// 把奇数行节点压栈，并且压入节点之后，元素数量增加。
				if (tempNode.rchild != null) {
					stackOdd.push(tempNode.rchild);
					countNextRows++;
				}
				if (tempNode.lchild != null) {
					stackOdd.push(tempNode.lchild);
					countNextRows++;
				}
			}
			// 打印完一行之后，换行
			System.out.println();
			countToBePrint = countNextRows;
			countNextRows = 0;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("test1() :");
		test1();
		System.out.println("test2() :");
		test2();
		System.out.println("test3() :");
		test3();
	}

	// 满二叉树
	// ..............1...............................................................
	// ........../.......\............................................................
	// .........2..........3...........................................................
	// ......./...\....../....\........................................................
	// ......4.....5....6......7.......................................................
	// ..../..\../..\../..\..../...\...................................................
	// ...8...9.10..11.12..13.14....15.................................................
	private static void test1() {
		PrintTreeInZigzag ptiz = new PrintTreeInZigzag();
		MyNode root = new MyNode(1);
		MyNode N2 = new MyNode(2);
		MyNode N3 = new MyNode(3);
		MyNode N4 = new MyNode(4);
		MyNode N5 = new MyNode(5);
		MyNode N6 = new MyNode(6);
		MyNode N7 = new MyNode(7);
		MyNode N8 = new MyNode(8);
		MyNode N9 = new MyNode(9);
		MyNode N10 = new MyNode(10);
		MyNode N11 = new MyNode(11);
		MyNode N12 = new MyNode(12);
		MyNode N13 = new MyNode(13);
		MyNode N14 = new MyNode(14);
		MyNode N15 = new MyNode(15);
		root.lchild = N2;
		root.rchild = N3;
		N2.lchild = N4;
		N2.rchild = N5;
		N3.lchild = N6;
		N3.rchild = N7;
		N4.lchild = N8;
		N4.rchild = N9;
		N5.lchild = N10;
		N5.rchild = N11;
		N6.lchild = N12;
		N6.rchild = N13;
		N7.lchild = N14;
		N7.rchild = N15;

		ptiz.myPrint(root);
	}

	// 斜二叉树
	// ............8...............................................................
	// ........../.................................................................
	// .........6..................................................................
	// ......./.....................................................................
	// ......5......................................................................
	private static void test2() {
		PrintTreeInZigzag ptiz = new PrintTreeInZigzag();
		MyNode root = new MyNode(8);
		MyNode N2 = new MyNode(6);
		MyNode N4 = new MyNode(5);
		root.lchild = N2;
		N2.lchild = N4;
		ptiz.myPrint(root);
	}

	// 普通二叉树
	// ............8...............................................................
	// ........../....\............................................................
	// .........6......10...........................................................
	// ......./..\..................................................................
	// ......5...7..................................................................
	private static void test3() {
		PrintTreeInZigzag ptiz = new PrintTreeInZigzag();
		MyNode root = new MyNode(8);
		MyNode N2 = new MyNode(6);
		MyNode N3 = new MyNode(10);
		MyNode N4 = new MyNode(5);
		MyNode N5 = new MyNode(7);
		root.lchild = N2;
		root.rchild = N3;
		N2.lchild = N4;
		N2.rchild = N5;
		ptiz.myPrint(root);
	}
}
