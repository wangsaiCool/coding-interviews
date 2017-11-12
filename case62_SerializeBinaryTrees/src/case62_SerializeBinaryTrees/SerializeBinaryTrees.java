package case62_SerializeBinaryTrees;

/**
 * 题目：请实现两个函数，分别用来序列化和反序列化二叉树。
 * 
 * 思路：根据前序遍历规则完成序列化与反序列化。所谓序列化指的是遍历二叉树为字符串；所谓反序列化指的是依据
 * 字符串重新构造成二叉树。依据前序遍历序列来序列化二叉树，因为前序遍历序列是从根结点开始的。当在遍历二叉
 * 树时碰到Null指针时，这些Null指针被序列化为一个特殊的字符“#”。另外，结点之间的数值用逗号隔开。
 * 
 * @author WangSai
 *
 */
public class SerializeBinaryTrees {

	/**
	 * 序列化二叉树，用前序遍历的方法，
	 * 
	 * @param root,待遍历的二叉树的根节点
	 * @return 二叉树序列化的字符串
	 */
	public static String Serialize(TreeNode root) {
		// 异常值检测
		if (root == null)
			return null;
		StringBuilder sb = new StringBuilder();
		SerializeCore(root, sb);
		return sb.toString();
	}

	// 前序遍历二叉树
	private static void SerializeCore(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("#,");
			return;
		}
		sb.append(root.val + ",");
		SerializeCore(root.lchild, sb);
		SerializeCore(root.rchild, sb);
	}

	/**
	 * 反序列化二叉树
	 * 
	 * @param str，二叉树序列化之后的字符串
	 * @return 反序列化之后的二叉树
	 */
	public static TreeNode Deserialize(String str) {
		if (str == null || str.length() <= 0)
			return null;
		String[] split = str.split(",");
		int[] index = { 0 };
		TreeNode node = DeserializeCore(split, index);
		return node;
	}

	private static TreeNode DeserializeCore(String[] str, int[] index) {
		// 处理null节点
		if (str[index[0]].equals("#"))
			return null;
		if (index[0] >= str.length)
			return null;
		// 处理当前节点
		TreeNode root = new TreeNode(Integer.parseInt(str[index[0]]));
		index[0]++;
		root.lchild = DeserializeCore(str, index);
		index[0]++;
		root.rchild = DeserializeCore(str, index);
		return root;
	}

	// 前序遍历二叉树，查看效果
	private static void preTraverse(TreeNode node) {
		if (node == null) {
			System.out.print("$,");
			return;
		}
		System.out.print(node.val + ",");
		preTraverse(node.lchild);
		preTraverse(node.rchild);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		root.lchild = n2;
		root.rchild = n3;
		n2.lchild = n4;
		n2.rchild = n5;
		// 序列化之后的字符串
		System.out.println("序列化之后的字符串:");
		String s1 = Serialize(root);
		System.out.println(s1);
		// 反序列化二叉树
		TreeNode node = Deserialize(s1);
		System.out.println("反序列化之后的二叉树，再序列化之后查看字符串效果:");
		// 前序遍历
		preTraverse(node);
	}
}
