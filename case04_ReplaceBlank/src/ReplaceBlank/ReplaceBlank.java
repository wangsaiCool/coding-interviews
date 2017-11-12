package ReplaceBlank;

public class ReplaceBlank {

	/**
	 * 问题1：替换字符串，是在原字符串上替换，还是新开辟一个字符串做替换。 问题2：在原字符串上替换，怎么替换效率高？ 从前往后遍历一遍，从后往前替换。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer s1 = new StringBuffer("We Are Happy");
		String s2 = replaceBlank1(s1);
		System.out.println(s2);
		String s3 = replaceBlank2(s1);
		System.out.println(s3);
		System.out.println(s1);
		String s4 = replaceBlank2(null);
		System.out.println(s4);
	}

	// 方法1：新开辟一个字符串做替换
	public static String replaceBlank1(StringBuffer str) {
		StringBuffer newSb = new StringBuffer();
		if (str == null)
			return null;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				newSb.append("%20");
			else
				newSb.append(String.valueOf(str.charAt(i)));
		}
		return newSb.toString();
	}

	// 方法2：在原字符串上替换
	public static String replaceBlank2(StringBuffer str) {
		// 对空字符串做判断
		if (str == null)
			return null;
		// 统计空格数量
		int numOfBlank = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				numOfBlank++;
			}
		}

		int oldSbLength = str.length();
		int newSbLength = oldSbLength + numOfBlank * 2;
		int newIndex = 0;
		int oldIndex = 0;
		newIndex = newSbLength - 1;
		oldIndex = oldSbLength - 1;
		str.setLength(newSbLength);
		while (oldIndex > 0 && newIndex > oldIndex) {
			if (str.charAt(oldIndex) == ' ') {
				str.setCharAt(newIndex--, '0');
				str.setCharAt(newIndex--, '2');
				str.setCharAt(newIndex--, '%');

			} else {
				str.setCharAt(newIndex--, str.charAt(oldIndex));
			}
			oldIndex--;
		}
		return str.toString();
	}
}
