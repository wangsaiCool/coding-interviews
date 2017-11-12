package case51_FindDuplicateNumbers;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 题目：在一个长度为n的数组中的所有数字都在0~n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2,3,1,0,2,5,3},那么对应的输出是重复的数字2或者3。
 * 
 * @author WangSai
 *
 */
public class FindDuplicateNumbers {

	/**
	 * 方法1：根据map集合实现。遍历arr[]，把遍历到的数字作为map的键，若map键不包含，则不重复；若有该键，说明重复
	 * 时间复杂度O(n)，空间复杂度O(n)
	 * 
	 * @param arr,要被遍历的数组
	 */
	private void findTheNumbers(int[] arr) {
		// 异常值检测
		if (arr == null || arr.length <= 0)
			throw new IllegalArgumentException("非法的输入参数，请重新检查");
		// 遍历arr[]，把遍历到的数字作为map的键，若map键不包含，则不重复；若有该键，说明重复。
		HashMap<Integer, Integer> hp = new HashMap<>();
		for (Integer key : arr) {
			if (!hp.containsKey(key))
				hp.put(key, 1);
			else
				hp.put(key, hp.get(key) + 1);
		}
		// 遍历hp的键set集合，把>1的value的key保存到set中
		HashSet<Integer> hs = new HashSet<>();
		for (Integer key : hp.keySet()) {
			int value = hp.get(key);
			if (value > 1)
				hs.add(key);

		}
		System.out.println(hs.toString());

	}

	/**
	 * 方法2：在原数组的基础上，通过判断当前数字是否符合当前的位置判断。
	 * 
	 * 我们注意到数组中的数字都在0到n-1中。 如果这个数组中没有重复的数字，那么当数组排序之后数字i将出现在下标为i的位置。由于数组中有重复的
	 * 数字，有些位置可能存在多个数字，同时有些位置可 能没有数字。 现在让我们 重排这个数组，依然从头到尾一次扫描这个数组中的每个数字。当扫描到
	 * 下标为i的数字时，首先比较这个数字（用m表示）是不是等于i。如果是，接着扫描下一个数字。如果不是，再拿它和第m个数字进行比较。 如果它和第
	 * m个数字相等，就找到了一个 重复的 数字（该数字在下标为i和m的位置都出现了）。如果它和第m个数字不相等，就把第i个数字和第m个数字交换，把m
	 * 放到属于它 的位 置。接下来再重读这个比较、交换的过程，直到我们发现一 个重复的数字。
	 * 
	 * 时间复杂度O(n)，空间复杂度O(1)
	 * 
	 * @param arr，要寻找的数组
	 * @return true，arr数组有重复的数字
	 */
	private boolean findTheNumbers2(int[] arr) {
		// 异常值检测
		if (arr == null || arr.length <= 0)
			throw new IllegalArgumentException("非法参数，请重新检查...");
		// 数组是否有重复的数字
		boolean moreThanOne = false;
		// 保存重复的数字
		HashSet<Integer> hs = new HashSet<>();
		// 遍历arr
		for (int i = 0; i < arr.length; i++) {
			// 判断当前的数arr[i]是否应该在当前的数组角标上i
			while (arr[i] != i) {
				// 判断以arr[i]为角标的数arr[arr[i]]是否应该在当前的数组角标上arr[i]上。
				// arr[arr[i]]不属于角标arr[i],把arr[i]放到角标arr[i]上
				if (arr[arr[i]] != arr[i]) {
					int temp = arr[arr[i]];
					arr[arr[i]] = arr[i];
					arr[i] = temp;
				}
				// arr[i]和角标arr[i]上的数字arr[arr[i]],即存在相同的数字。
				// 标志位设置为true
				// 跳出当前循环，判断下一个位置，即i+1的值
				else {
					moreThanOne = true;
					// 把重复的值保存到set中
					hs.add(arr[i]);
					break;
				}
			}
		}
		System.out.println(hs.toString());
		return moreThanOne;
	}

	public static void main(String[] args) {
		System.out.println("test1() Found:");
		test1();
		System.out.println("test2() Found:");
		test2();
		System.out.println("test3() Found:");
		test3();
	}

	// 数组中没有重复元素 arr[]={0,1,2,3,4,5}
	private static void test1() {
		int[] arr = { 0, 1, 2, 3, 4, 5 };
		FindDuplicateNumbers fdn = new FindDuplicateNumbers();
		System.out.print("findTheNumbers:   ");
		fdn.findTheNumbers(arr);
		System.out.print("findTheNumbers2:   ");
		fdn.findTheNumbers2(arr);

	}

	// 数组中有重复元素 arr[]={1,2,2,4,4}
	private static void test2() {
		int[] arr = { 1, 2, 2, 4, 4 };
		FindDuplicateNumbers fdn = new FindDuplicateNumbers();
		System.out.print("findTheNumbers:   ");
		fdn.findTheNumbers(arr);
		System.out.print("findTheNumbers2:   ");
		fdn.findTheNumbers2(arr);
	}

	// 数组中有重复元素 arr[]={1,1,1}
	private static void test3() {
		int[] arr = { 1, 1, 1 };
		FindDuplicateNumbers fdn = new FindDuplicateNumbers();
		System.out.print("findTheNumbers:   ");
		fdn.findTheNumbers(arr);
		System.out.print("findTheNumbers2:   ");
		fdn.findTheNumbers2(arr);
	}
}
