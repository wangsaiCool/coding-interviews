package ReplaceBlank;

public class 第二次做 {

	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("we are happy");
		System.out.println(replaceSpace(str));
	}

	public static String replaceSpace(StringBuffer str) {
		if (str == null || str.length() <= 0)
			return "";
		int len = str.length();
		// int count = 0;
		// for (int i = 0; i < len; i++) {
		// if (str.charAt(i) == ' ')
		// count++;
		// }
		// StringBuilder sb = new StringBuilder(len + 2 * count);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == ' ') {
				sb.append("%20");
				continue;
			} else {
				sb.append(str.charAt(i));
			}
		}
		// sb.trimToSize();
		return sb.toString();
	}

}
