package case29_MoreThanHalfNum;

import java.util.HashMap;

public class ByHashMap {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 3 };
		System.out.println(moreThanHalf(arr));
	}

	// 出现次数超过一半的数字
	private static int moreThanHalf(int[] arr) {
		if (arr == null || arr.length <= 0)
			throw new RuntimeException("输入的数组非法...");
		// 创建map集合
		HashMap<Integer, Integer> hp = new HashMap<>();
		// 把出现的数字和该数字出现的次数分别作为键和值，存储到map中
		for (int j = 0; j < arr.length; j++) {
			if (!hp.containsKey(arr[j]))
				hp.put(arr[j], 1);
			else {
				hp.put(arr[j], hp.get(arr[j]) + 1);
			}
		}
		// 迭代
		for (Integer key : hp.keySet()) {
			// System.out.println(hp.get(key));
			if (hp.get(key) >= arr.length / 2)
				return key;
		}
		throw new RuntimeException("输入的数组非法......");

	}
}
