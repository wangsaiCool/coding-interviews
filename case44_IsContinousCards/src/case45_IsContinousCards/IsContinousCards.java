package case45_IsContinousCards;

/**
 * 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2~10为数字本身，A为1， J为11，
 * Q为12，K为13，而大、小王可以看成任意数字。
 * 
 * 思路：1，把两个王定义为0。2，然后对这5个数字排序。3，统计排序数组中的0的个数，即王的个数。4，非0相邻数字的差值，即是否连续，
 * 若不连续则应插入几个数字。5，相同数字出现，类似于扑克牌中对子的出现，即不连续。
 * 
 * @author WangSai
 *
 */
public class IsContinousCards {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 没有王，且数字是连续的
		int[] arr1 = { 2, 3, 4, 5, 6 };
		System.out.println("true:" + myIsContinous(arr1));
		// 没有王，且数字是不连续的
		int[] arr2 = { 1, 2, 4, 5, 6 };
		System.out.println("false:" + myIsContinous(arr2));
		// 有王，且非0数字是连续的
		int[] arr3 = { 0, 3, 4, 5, 6 };
		System.out.println("true:" + myIsContinous(arr3));
		// 有王，且非0数字是不连续的，但是插入王之后可以保证连续
		int[] arr4 = { 0, 2, 4, 5, 6 };
		System.out.println("true:" + myIsContinous(arr4));
		// 有王，且非0数字是不连续的，但是插入王之后不能保证连续
		int[] arr5 = { 0, 1, 4, 5, 6 };
		System.out.println("false:" + myIsContinous(arr5));
		// 出现非0重复数字
		int[] arr6 = { 1, 1, 4, 5, 6 };
		System.out.println("false:" + myIsContinous(arr6));
	}

	private static boolean myIsContinous(int[] arr) {
		// 异常值检测
		if (arr == null || arr.length < 5)
			throw new IllegalArgumentException("非法输入参数，请重新检查...");

		// 排序数组
		quickSort(arr, 0, arr.length - 1);
		// 统计数组中0的个数 cnt0
		int cnt0 = 0;
		// 相邻数字之间的差值
		int dif = 0;
		// 统计相邻数字之间总共需要插入的数字的个数
		int insertSum = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			dif = arr[i + 1] - arr[i];
			// 判断数组前面0的个数
			if (arr[i] == 0)
				cnt0++;
			// 判断相邻的数字之间的可以插入的数字的个数,若大于等于1，说明不是对子
			else if (dif >= 1) {
				insertSum += dif - 1;
			}
			// 非0相邻数字之间的差值为0,说明两个数字相同，即出现了对子。不连续
			else if (dif == 0) {
				return false;
			}

		}
		// 若需要插入的数字的个数insertSum 小于等于0的个数cnt0，即连续
		if (insertSum <= cnt0)
			return true;
		return false;

	}

	// 快速排序数组
	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivotPos = partition(arr, low, high);
			quickSort(arr, low, pivotPos - 1);
			quickSort(arr, pivotPos + 1, high);
		}
	}

	// 分治算法
	private static int partition(int[] arr, int low, int high) {
		int pivotKey = arr[low];
		while (low < high) {
			while (low < high && pivotKey <= arr[high])
				high--;
			arr[low] = arr[high];
			while (low < high && pivotKey >= arr[low])
				low++;
			arr[high] = arr[low];
		}
		arr[low] = pivotKey;
		return low;
	}

}
