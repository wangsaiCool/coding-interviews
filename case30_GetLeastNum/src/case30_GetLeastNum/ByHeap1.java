package case30_GetLeastNum;

/**
 * 通过使用大顶堆完成。时间复杂度O(nlogk)
 * 
 * @author WangSai
 *
 */
public class ByHeap1 {

	// 1，创建容器，并填充arr的前K个元素
	// 2，对这[0...K-1]序列创建大顶堆
	// 3，原序列从第K个开始，与[0...K-1]序列作比较，若大于堆顶元素则进行替换
	// 4，替换完成后，对序列重新调整变成大顶堆
	// 3,4步骤循环进行
	public static void main(String[] args) {
		int[] arr = { 8, 4, 12, 2, 6, 10, 14, 1, 3, 100, 7 };
		int k = 7;
		getLeatK(arr, k);
		int[] arr1 = { 1 };
		k = 1;
		getLeatK(arr1, k);
	}

	// 获取最小的K个元素的方法
	private static void getLeatK(int[] arr, int k) {
		// 异常情况检测
		if (arr == null || arr.length <= 0 || arr.length < k || k <= 0)
			throw new IllegalArgumentException("输入的参数非法，请重新检查...");
		// 创建容器，并填充arr的前K个元素
		int[] heap = new int[k];
		for (int i = 0; i < k; i++) {
			heap[i] = arr[i];
		}
		buildMaxTopHeap(heap);
		// arr中的元素从第K个开始依次与大顶堆heap作比较，如果大于对顶则替换，并对新的堆做处理。
		for (int i = k; i < arr.length; i++) {
			if (arr[i] < heap[0]) {
				heap[0] = arr[i];
				adjustDownToUp(heap, 0);
			}
		}
		for (int i = 0; i < heap.length; i++) {
			System.out.print(heap[i] + "     ");
		}
		System.out.println();
	}

	// 将含有K个元素的无序序列构建大顶堆
	private static void buildMaxTopHeap(int[] heap) {
		for (int i = heap.length / 2 - 1; i >= 0; i--) {
			// 自底向上调整堆
			adjustDownToUp(heap, i);
		}
	}

	// 自底向上调整堆为大顶堆
	private static void adjustDownToUp(int[] heap, int i) {
		// 判断该节点与其子节点的大小
		int temp = heap[i];
		for (int j = 2 * i + 1; j < heap.length - 1; j = 2 * j + 1) { // i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
			if (j <= heap.length - 1 && heap[j] < heap[j + 1]) // 取节点较大的子节点的下标
				j++; // 如果节点的右孩子>左孩子，则取右孩子节点的下标
			if (temp >= heap[j]) // 根节点 >=左右子女中关键字较大者，调整结束
				break;
			// 根节点 <左右子女中关键字较大者
			else {
				heap[i] = heap[j]; // 将左右子结点中较大值array[i]调整到双亲节点上
				i = j; // 【关键】修改k值，以便继续向下调整
			}
		}
		heap[i] = temp; // 被调整的结点的值放入最终位置
	}
}
