package case58_GetBinaryTreeNextNode;

/**
 * 二叉树节点定义，子节点和父节点。
 * 
 * @author WangSai
 *
 */
public class BinaryTreeNode {

	int data;

	BinaryTreeNode lchild;
	BinaryTreeNode rchild;
	BinaryTreeNode parent;

	public BinaryTreeNode() {
	}

	public BinaryTreeNode(int data) {
		this.data = data;
	}

}
