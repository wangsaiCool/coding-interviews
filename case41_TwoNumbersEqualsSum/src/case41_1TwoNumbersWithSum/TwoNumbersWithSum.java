package case41_1TwoNumbersWithSum;

/**
 * 题目1:输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s,输出 任意一对即可。
 * 例如输入数组{1,2,4,7,11,15}和数字15.由于4+11=15，一次输出4+11。
 * 
 * @author WangSai
 *
 */
public class TwoNumbersWithSum {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 7, 11, 15 };
		int s = 14;
		int[] result = new int[2];
		System.out.println(findMyNumbers(arr, s, result));
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	/**
	 * 
	 * @param arr,递增排序的数组
	 * @param s，数组中待查找数字的和
	 * @param result，保存满足条件的两个数字的容器
	 * @return arr中是否存在满足条件的两个数字
	 */
	private static boolean findMyNumbers(int[] arr, int s, int[] result) {
		// 异常值检测
		if (arr == null || arr.length <= 0)
			throw new IllegalArgumentException("非法输入参数，请重新检查...");
		// 递增排序的数组的左侧角标和右侧角标
		int left = 0;
		int right = arr.length - 1;
		boolean Found = false;
		// 暂存找到的两个数字
		while (left < right) {
			int temp = arr[left] + arr[right];
			// 若arr[left]+arr[right]的值大于s，则取arr[right-1]
			if (temp > s)
				right--;
			// 若arr[left]+arr[right]的值大于s，则取arr[right-1]
			else if (temp < s)
				left++;
			// 若arr[left]+arr[right]的值等于s，返回arr[left]和arr[right]
			else {
				result[0] = arr[left];
				result[1] = arr[right];
				Found = true;
				left++;
			}
		}
		return Found;
	}
}
