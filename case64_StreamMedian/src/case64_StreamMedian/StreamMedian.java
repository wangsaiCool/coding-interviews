package case64_StreamMedian;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目：如何得到一个数据流中的中位数？
 * 
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 
 * 思路：
 * 
 * Java的PriorityQueue
 * 是从JDK1.5开始提供的新的数据结构接口，默认内部是自然排序，结果为小顶堆，也可以自定义排序器，比如下面反转比较，完成大顶堆。
 * 
 * 为了保证插入新数据(时间复杂度O(lgN))和取中位数(时间复杂度O(1))的时间效率都高效，这里使用大顶堆+小顶堆的容器，并且满足：
 * 
 * 1、两个堆中的数据数目差不能超过1，这样可以使中位数只会出现在两个堆的交接处；
 * 
 * 2、大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。
 * 
 * @author WangSai
 *
 */
public class StreamMedian {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StreamMedian sm = new StreamMedian();
		int[] arr = { 1, 2, 3, 5, 6, 8, 0 };
		for (int i = 0; i < arr.length; i++) {
			sm.Insert(arr[i]);
			System.out.print(sm.GetMedian() + " ");
		}
	}

	// 创建小顶堆
	private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	// 创建大顶堆
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
		// PriorityQueue默认是小顶堆，实现大顶堆，需要反转默认排序器
		public int compare(Integer num1, Integer num2) {
			return num2.compareTo(num1);
			// return num1.compareTo(num2);,这是小顶堆的排序方式
		}
	});
	// 统计已经插入的数据总数，未包含刚刚读取出来的数据。
	private int count = 0;

	public void Insert(Integer num) {
		// 当数据总数为偶数时，新加入的元素，应当进入大顶堆
		// （注意不是直接进入大顶堆，而是经小顶堆筛选后取大顶堆中最大元素进入小顶堆）
		if ((count & 1) == 0) {// 判断偶数的高效方法
			if (num > minHeap.peek() && !minHeap.isEmpty()) {
				// 1.新加入的元素先入到小顶堆，由小顶堆筛选出堆中最小的元素
				minHeap.offer(num);
				// 2.筛选后的【小顶堆中的最大元素】进入大顶堆
				maxHeap.offer(minHeap.poll());
			} else
				maxHeap.offer(num);
		}
		// 当数据总数为奇数时，新加入的元素，应当进入小顶堆
		else {
			if (num < maxHeap.peek() && !maxHeap.isEmpty()) {
				maxHeap.offer(num);
				minHeap.offer(maxHeap.poll());
			} else
				minHeap.offer(num);
		}
		// 统计大顶堆和小顶堆中的数据总数+1
		count++;
	}

	public Double GetMedian() {
		if (count == 0)
			throw new RuntimeException("no available number,please check");
		if ((count & 1) == 0) {// 判断奇偶数的高效写法
			return (minHeap.peek() + maxHeap.peek()) / 2.0;
		} else {
			return maxHeap.peek() * 1.0;
		}
	}
}
