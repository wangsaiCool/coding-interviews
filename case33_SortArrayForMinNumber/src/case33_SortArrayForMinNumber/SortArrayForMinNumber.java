package case33_SortArrayForMinNumber;

import java.util.Comparator;

/**
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数字{3,32,321}，则打印出这3个数字能拍成的最小数字321323。
 * 
 * @author WangSai
 *
 */
public class SortArrayForMinNumber {

	/**
	 *
	 * 思路：
	 *
	 * 举例，先拼接两个，例如3和32能拼接成的最小的数字为323。即（3,32） 要 大于 (32,3)。把两个数字拼接之后若ab<ba,
	 * 则把a放在b的前边， 类似于数组中的排序。自定义排序规则之后，可以利用快速排序算法实现。
	 * 自定义排序规则：从数组中取出两个数字a和b，把数字a和数字b转换成字符串之后进行拼接，然后，利用字符串自身的compareTo()方法，比较两个
	 * 串的大小关系。
	 * 
	 * 这里同时解决了大数问题。比如a=Integer.MAX_VALUE,b=Integer.MAX_VALUE,ab拼接之后，会出现大数问题。
	 * 转换成字符串之后，巧妙 的避免了大数问题。
	 */

	public static void main(String[] args) {
		int[] arr1 = { 1 };
		System.out.println(mySort(arr1));
		int[] arr2 = { 1,2,2,3 };
		System.out.println(mySort(arr2));
		int[] arr3 = { 123,3,4,21 };
		System.out.println(mySort(arr3));
	}

	/**
	 * 
	 * @param arr,带排序的数组
	 * @return 数组排序之后组成的最小的数字字符串
	 */
	private static String mySort(int[] arr) {
		// TODO Auto-generated method stub
		// 异常值检查
		if (arr == null || arr.length <= 0)
			return null;
		// 快速排序，自定义比较规则
		myComparator myCmp = new myComparator();
		mySortCore(arr, 0, arr.length - 1, myCmp);
		// 排序之后，把arr转换成字符串输出
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		// return arr.toString();
		return sb.toString();

	}

	/**
	 * 
	 * @param arr,带排序数组
	 * @param low,带排序数组的最左侧角标
	 * @param high,带排序数组的最右侧角标
	 * @param comp,自定义比较器
	 */
	// 快速排序算法
	private static void mySortCore(int[] arr, int low, int high, Comparator<Integer> comp) {
		if (low < high) {
			int pivotPos = partition(arr, low, high, comp);
			mySortCore(arr, low, pivotPos - 1, comp);
			mySortCore(arr, pivotPos + 1, high, comp);
		}
	}

	// 分治算法
	private static int partition(int[] arr, int low, int high, Comparator<Integer> comp) {
		int pivotKey = arr[low];
		while (low < high) {
			while (low < high && comp.compare(pivotKey, arr[high]) <= 0)
				high--;
			arr[low] = arr[high];
			while (low < high && comp.compare(pivotKey, arr[low]) >= 0)
				low++;
			arr[high] = arr[low];
		}
		arr[low] = pivotKey;
		return low;
	}

	// 自定义比较器，实现Comparator接口
	private static class myComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			// 把数字拼接成字符串，同时解决了大数问题
			String str1 = o1 + "" + o2;
			String str2 = o2 + "" + o1;
			// 根据字符串自己的compateTo方法比较str1-str2的大小
			return str1.compareTo(str2);
		}
	}
}
