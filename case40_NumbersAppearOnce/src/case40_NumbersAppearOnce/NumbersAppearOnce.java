package case40_NumbersAppearOnce;

public class NumbersAppearOnce {
	/**
	 * 需求：在一个整型数组中，除了某两个数字之外，其他的数字都出现了两次。 请写程序找出这两个数字。要求时间复杂度为O(n),空间复杂度为O(1)
	 * 思路：
	 * 
	 * 前提知识：
	 * 
	 * 1，任何一个数字与其自身做 异或运算，结果都是零。
	 * 
	 * 2，任何数字和 0 做异或运算都是数字本身。
	 * 
	 * 解题方法： 若数组中只有1个数字不相同呢？
	 * 
	 * 0，遍历数组，从头到尾依次异或，异或得到的结果就是那个不相同的数字。 若数组中有2个数字不相同呢？
	 * 1，遍历数组，从头到尾依次异或，异或得到的结果是要找的2个不同的数字的异或结果。
	 * 2，根据异或结果将两个数字分配到两个子数组中，其他数字也分别分配到这两个子数组中，然后再分别异或。
	 * 3，因为2个相同的数字会分配到同一个子数组中去，所以这两个数字异或的结果为0，不会影响结果。 4，得到的结果
	 * 
	 * @author WangSai
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 5, 5, 1, 2, 3, 3 };
		NumbersAppearOnce nao = new NumbersAppearOnce();
		nao.NumberAppearOnce(arr); // 小技巧，new对象之后，可以在main里调用非静态函数。
	}

	// 数组中只出现1次的数字
	public void NumberAppearOnce(int[] arr) {
		// 处理异常情况
		if (arr == null)
			return;
		if (arr.length < 2)
			return;
		int resultOr = 0;
		int num1 = 0;
		int num2 = 0;
		// 遍历数组，得到异或结果
		for (int i = 0; i < arr.length; i++) {
			resultOr ^= arr[i];
		}
		int index = FindFirstBitIs1(arr, resultOr);
		// 根据reusltOr低位第一个为1的位数，判断其他数字在该位上是否为1，分为两组。
		for (int j = 0; j < arr.length; j++) {
			if (isBit1(arr[j], index) == 1) {
				num1 ^= arr[j];
			} else
				num2 ^= arr[j];
		}
		System.out.println(num1);
		System.out.println(num2);
	}

	// 寻找第几位是1
	public int FindFirstBitIs1(int[] arr, int resultOr) {
		// 异或结果中，第1个位1的低位
		int bitNum = 0;
		while ((resultOr & 1) == 0 && bitNum < Integer.SIZE) {
			resultOr >>>= 1;
			bitNum++;
		}
		return bitNum;
	}

	public int isBit1(int data, int index) {
		data >>>= index;
		return data & 1;
	}

}
