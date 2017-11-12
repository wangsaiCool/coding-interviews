package case18_isTree1IsSubtreeOfTree2;

public class Subtree {

	// (tree2,tree1) 树tree1是否是tree2的子树
	// tree2:.................tree1:
	// ..........8................8
	// ....... /...\ .......... /....\
	// .......8.....7..........9......2
	// ...../...\
	// ....9.....2
	// ........./..\
	// ........4....7
	/**
	 * 在树tree2中寻找与树tree1的根值节点相同的节点。
	 * 
	 * @param tree2被参考的大一点的树
	 * @param tree1子树
	 * @return true，tree1是tree2的子树
	 */
	private static boolean isTree1IsSubtreeOfTree2(myTreeNode tree2, myTreeNode tree1) {
		// 异常情况检测
		if (tree1 == null)
			return true;
		if (tree2 == null)
			return false;
		//
		boolean result = false;
		if (tree1.data == tree2.data)
			result = isDoesSubtree(tree2, tree1);
		if (!result)
			result = isTree1IsSubtreeOfTree2(tree2.lchild, tree1);
		if (!result)
			result = isTree1IsSubtreeOfTree2(tree2.rchild, tree1);

		return result;
	}

	/**
	 * 判断以R为根节点的子树tree2和tree1是否具有相同的子结构。
	 * 
	 * @param tree2,参考树的R节点
	 * @param tree1,子树的节点
	 * @return true,tree1是tree2的子树
	 */

	private static boolean isDoesSubtree(myTreeNode tree2, myTreeNode tree1) {
		// 这一步说明 tree1已经到达子节点
		if (tree1 == null)
			return true;
		// 这一步说明 tree2已经到达子节点，但是tree1没有到达子节点
		if (tree2 == null)
			return false;
		if (tree2.data != tree1.data)
			return false;
		// 递归判断tree1的左子节点，tree2的左子节点，他们是否相等
		boolean left = isDoesSubtree(tree2.lchild, tree1.lchild);
		// 递归判断tree1的右子节点，tree2的右子节点，他们是否相等
		boolean right = isDoesSubtree(tree2.rchild, tree1.rchild);
		return left && right;

	}

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	// 普通二叉树，树B是树A的子树
	// （数字是节点值，字母为节点名称）
	// 1 a 2j
	// / \ / \
	// 2b 3c 4k 5l
	// /\ / \
	// 4d 5e 6f 7g
	private static void test1() {
		myTreeNode a = new myTreeNode(1);
		myTreeNode b = new myTreeNode(2);
		myTreeNode c = new myTreeNode(3);
		myTreeNode d = new myTreeNode(4);
		myTreeNode e = new myTreeNode(5);
		myTreeNode f = new myTreeNode(6);
		myTreeNode g = new myTreeNode(7);
		a.lchild = b;
		a.rchild = c;
		b.lchild = d;
		b.rchild = e;
		e.lchild = f;
		e.rchild = g;
		myTreeNode j = new myTreeNode(2);
		myTreeNode k = new myTreeNode(4);
		myTreeNode l = new myTreeNode(5);
		j.lchild = k;
		j.rchild = l;
		System.out.print("//普通二叉树，树B是树A的子树--test1():");
		System.out.println(isTree1IsSubtreeOfTree2(a, j));
	}

	// 普通二叉树，树B 不 是树A的子树
	// （数字是节点值，字母为节点名称）
	// 树A： 树B
	// 1 a 2j
	// / \ / \
	// 2b 3c 3k 5l
	// /\ / \
	// 4d 5e 6f 7g
	private static void test2() {
		myTreeNode a = new myTreeNode(1);
		myTreeNode b = new myTreeNode(2);
		myTreeNode c = new myTreeNode(3);
		myTreeNode d = new myTreeNode(4);
		myTreeNode e = new myTreeNode(5);
		myTreeNode f = new myTreeNode(6);
		myTreeNode g = new myTreeNode(7);
		a.lchild = b;
		a.rchild = c;
		b.lchild = d;
		b.rchild = e;
		e.lchild = f;
		e.rchild = g;
		myTreeNode j = new myTreeNode(2);
		myTreeNode k = new myTreeNode(3);
		myTreeNode l = new myTreeNode(5);
		j.lchild = k;
		j.rchild = l;
		System.out.print("普通二叉树，树B 不 是树A的子树--test2():");
		System.out.println(isTree1IsSubtreeOfTree2(a, j));
	}

	// 普通二叉树，树B是普通二叉树，树A是null
	// （数字是节点值，字母为节点名称）
	// 树A： 树B：为null
	// 1 a
	// / \
	// 2b 3c
	// /\ / \
	// 4d 5e 6f 7g
	private static void test3() {
		myTreeNode j = new myTreeNode(2);
		myTreeNode k = new myTreeNode(4);
		myTreeNode l = new myTreeNode(5);
		j.lchild = k;
		j.rchild = l;
		System.out.print("树B是普通二叉树，树A是null--test3():");
		System.out.println(isTree1IsSubtreeOfTree2(null, j));
	}

	// 普通二叉树，树B null，树A是普通二叉树
	// （数字是节点值，字母为节点名称）
	// 树A：null, 树B:
	// 2j
	// / \
	// 4k 5l
	private static void test4() {
		myTreeNode a = new myTreeNode(1);
		myTreeNode b = new myTreeNode(2);
		myTreeNode c = new myTreeNode(3);
		myTreeNode d = new myTreeNode(4);
		myTreeNode e = new myTreeNode(5);
		myTreeNode f = new myTreeNode(6);
		myTreeNode g = new myTreeNode(7);
		a.lchild = b;
		a.rchild = c;
		b.lchild = d;
		b.rchild = e;
		e.lchild = f;
		e.rchild = g;
		System.out.print("树B null，树A是普通二叉树--test4():");
		System.out.println(isTree1IsSubtreeOfTree2(a, null));
	}

}
