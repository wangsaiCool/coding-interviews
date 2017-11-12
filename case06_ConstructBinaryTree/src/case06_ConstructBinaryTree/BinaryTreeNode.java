package case06_ConstructBinaryTree;

//构造二叉树节点
public class BinaryTreeNode {
	public int data;
	public BinaryTreeNode lchild; // 左子树节点
	public BinaryTreeNode rchild; // 右子树节点

	public BinaryTreeNode() {
	}

	public BinaryTreeNode(int data) {
		this.data = data;
	}

}
