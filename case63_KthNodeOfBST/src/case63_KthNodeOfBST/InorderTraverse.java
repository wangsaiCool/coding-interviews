package case63_KthNodeOfBST;

public class InorderTraverse {

	public static void main(String[] args) {
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
		myTraverse(root);
	}

	// ÖÐÐò±éÀú¶þ²æÊ÷
	private static void myTraverse(MyNode root) {
		if (root == null)
			return;
		myTraverse(root.lchild);
		System.out.print(root.data + " ");
		myTraverse(root.rchild);
	}

}
