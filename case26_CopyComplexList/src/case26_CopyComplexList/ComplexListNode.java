
package case26_CopyComplexList;

/**
 * 复杂链表中节点结构的定义
 * 
 * @author WangSai
 *
 */
public class ComplexListNode {
	int data;
	ComplexListNode next;
	ComplexListNode sibling;

	public ComplexListNode() {
	}

	public ComplexListNode(int data) {
		this.data = data;
	}
}
