package case55_FirstCharInStream;

import java.util.LinkedHashMap;

/**
 * 题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符“go”时，第一个只出现一次的字符是‘g’。
 * 当从该字符流中读出前六个字符“google”时，第一个只出现一次的字符是‘l’。
 * 
 * @author WangSai
 *
 */
public class FirstCharInStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("findMyFirsChar1   :");
		System.out.println(findMyFirsChar1("g") + " : " + "g");
		System.out.println(findMyFirsChar1("go") + " : " + "go");
		System.out.println(findMyFirsChar1("goo") + " : " + "goo");
		System.out.println(findMyFirsChar1("goog") + " : " + "goog");
		System.out.println(findMyFirsChar1("googl") + " : " + "googl");
		System.out.println(findMyFirsChar1("google") + " : " + "google");
		System.out.println("new CharStatistics().findFisrtCharInStream:vvvvv");
		System.out.println(new CharStatistics().findFisrtCharInStream("g") + ":" + "g");
		System.out.println(new CharStatistics().findFisrtCharInStream("go") + ":" + "go");
		System.out.println(new CharStatistics().findFisrtCharInStream("goo") + ":" + "goo");
		System.out.println(new CharStatistics().findFisrtCharInStream("goog") + ":" + "goog");
		System.out.println(new CharStatistics().findFisrtCharInStream("googl") + ":" + "googl");
		System.out.println(new CharStatistics().findFisrtCharInStream("google") + ":" + "google");
	}

	/**
	 * 
	 * @param str，待处理的字符
	 * @return 第一个不重复的字符
	 */
	private static char findMyFirsChar1(String str) {
		// 异常值检测
		if (str == null)
			throw new IllegalArgumentException("非法输入参数，请重新检查...");
		// 读取字符串的字符，并且按照读取的顺序依次存入容器中，键就是字符，值是出现的次数
		int len = str.length();
		LinkedHashMap<Character, Integer> lhm = new LinkedHashMap<>();
		for (int i = 0; i < len; i++) {
			// 容器中不存在，则添加
			char key = str.charAt(i);
			// 每读取一个字符，就判断容器中已经存在的不重复的第一个键，即value为1的键
			if (!lhm.containsKey(key)) {
				lhm.put(key, 1);
			}
			// 容器中已经存在则，值置为-1
			else
				lhm.put(key, -1);
		}
		char theKey = '#';
		for (Character key : lhm.keySet()) {
			if (lhm.get(key) == 1) {
				theKey = key;
				return theKey;
			}
		}
		return theKey;
	}

	/**
	 * 自己创建哈希表容器，实现O(1)时间插入字符。 实现字符流中查找第一个不重复的数字。
	 * 
	 * @author WangSai
	 *
	 */
	public static class CharStatistics {
		// 创建辅助容器，存储字符在字符串中的位置，以字符对应的int值作为arr的角标。
		// 容器中的值初始化为-1，存在重复的值得时候-2，只出现一次存储字符在字符串中的位置角标。
		int[] arr = new int[255];
		// 字符串的角标，默认为0角标
		int strIndex = 0;

		// 创建对象时，初始化辅助数组arr
		public CharStatistics() {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = -1;
			}
		}

		public char findFisrtCharInStream(String str) {
			// 异常值检测
			if (str == null)
				throw new IllegalArgumentException("非法输入参数，请重新检查...");
			// 遍历str，把字符串以字符流的形式给Insert函数
			for (int i = 0; i < str.length(); i++) {
				// 把字符串以字符流的形式给Insert函数
				Insert(str.charAt(i));
			}
			char theKey = '#';
			// 获取arr中的最小非负值
			int minIndex = Integer.MAX_VALUE;
			// 遍历容器arr，获取最小的角标
			for (int i = 0; i < arr.length; i++) {
				// 保存的为角标，若不为负数，则说明出现而且只出现了一次。
				if (arr[i] >= 0) {
					if (arr[i] < minIndex) {
						minIndex = arr[i];
						theKey = (char) i;
					}
				}
			}

			return theKey;
		}

		// 处理从字符串中读到的每一个字符，并判断之前是否出现过。arr中存储了-1(没有出现过), -2(出现过至少2次) ,
		// strindex值(只出现过一次且该值为在str中的角标)。
		private void Insert(char ch) {
			int arrIndex = (int) ch;
			if (arr[arrIndex] == -1) {
				arr[arrIndex] = strIndex;
			}
			// ch已经出现过1次或者出现过多次
			else {
				arr[arrIndex] = -2;
			}
			strIndex++;
		}
	}

}
