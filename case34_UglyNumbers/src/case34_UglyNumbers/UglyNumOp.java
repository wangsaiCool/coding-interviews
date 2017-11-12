package case34_UglyNumbers;

/**
 * 题目：我们把只包含因子2、3 和5 的数称作丑数（Ugly Number）。求从小到大的顺序的第1500个丑数。
 * 思路：创建数组保存已经找到的丑数，用空间换时间的解法
 * 
 * @author WangSai
 *
 */
public class UglyNumOp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UglyNumOp myTest = new UglyNumOp();
		System.out.println(myTest.getUglyNumbers(11));
	}

	// 获取第index个丑数
	private int getUglyNumbers(int index) {
		if (index <= 0)
			return -1;
		// 数组保存index个丑数，并且arr[index-1]就是所要求的的丑数
		int[] arr = new int[index];
		arr[0] = 1;
		int nextIndex = 1;
		// T2位置的数字乘以2之后得到数据大于当前丑数序列，保存T2的位置。
		int T2 = 0;
		int T3 = 0;
		int T5 = 0;
		while (nextIndex < index) { // arr数组中丑数个数不到index个数
			int min = minOf3(arr[T2] * 2, arr[T3] * 3, arr[T5] * 5);
			arr[nextIndex] = min;
			while (arr[T2] * 2 <= arr[nextIndex])
				T2++;
			while (arr[T3] * 3 <= arr[nextIndex])
				T3++;
			while (arr[T5] * 5 <= arr[nextIndex])
				T5++;
			// 下一个丑数保存的位置
			nextIndex++;
		}
		return arr[index - 1];
	}

	// 获取i，j,k三个数中的最小者
	private int minOf3(int i, int j, int k) {
		int min = i < j ? i : j;
		min = min < k ? min : k;
		return min;
	}

}
