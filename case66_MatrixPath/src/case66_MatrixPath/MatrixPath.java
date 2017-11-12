package case66_MatrixPath;

/**
 * 
 * 题目要求：
 * 
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 
 * @author WangSai
 * 
 * 
 */
public class MatrixPath {

	public static void main(String[] args) {
		char[] matrix = "abcesfcsadee".toCharArray();
		int rows = 3;
		int cols = 4;
		char[] str1 = "bcced".toCharArray();
		char[] str2 = "abcb".toCharArray();
		System.out.println("true:" + isMatrixPath(matrix, rows, cols, str1));
		System.out.println("false:" + isMatrixPath(matrix, rows, cols, str2));
	}

	/**
	 * 矩阵matrix中是否存在str的路径
	 * 
	 * @param matrix,待查找的矩阵，用一维模拟二维数组
	 * @param rows，矩阵的行数
	 * @param cols，矩阵的列数
	 * @param str，待查找的字符串
	 * @return 若存在符合条件的路径，则返回true;否则，返回false
	 */
	public static boolean isMatrixPath(char[] matrix, int rows, int cols, char[] str) {
		// 异常值检测
		if (matrix == null || matrix.length <= 0)
			return false;
		boolean[] visted = new boolean[matrix.length];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (isMatrixPathCore(matrix, rows, cols, i, j, 0, str, visted))
					return true;
			}
		}
		return false;
	}

	/**
	 * 递归处理当前格子的字符和他四周的格子
	 * 
	 * @param matrix，待处理的矩阵，一维数组模拟二维矩阵
	 * @param rows，矩阵的行数
	 * @param cols，矩阵的列数
	 * @param row，当前格子的行号
	 * @param col，当前格子的列号
	 * @param k，字符串的第k给字符
	 * @param str，待处理的字符串
	 * @param visted，状态数组，标识是否访问过相应的格子
	 * @return 若当前格子和它的下一个格子的字符符合str的路径字符，则返回true；否则，返回false
	 */
	private static boolean isMatrixPathCore(char[] matrix, int rows, int cols, int row, int col, int k, char[] str,
			boolean[] visted) {
		int index = row * cols + col;
		if (row < 0 || row >= rows || col < 0 || col >= cols // 是否越界
				|| visted[index] // 是否访问过
				|| str[k] != matrix[index]) // 当前的格子的字符是否和str[k]相等
			return false;
		// 标志该格子已经被访问过
		visted[index] = true;
		// 访问过得路径是否已经完全等于字符串str
		if (k == str.length - 1)
			return true;
		// 在当前格子，向四个方向进行遍历
		if (isMatrixPathCore(matrix, rows, cols, row - 1, col, k + 1, str, visted)
				|| isMatrixPathCore(matrix, rows, cols, row + 1, col, k + 1, str, visted)
				|| isMatrixPathCore(matrix, rows, cols, row, col - 1, k + 1, str, visted)
				|| isMatrixPathCore(matrix, rows, cols, row, col + 1, k + 1, str, visted))
			return true;
		// 回溯法
		visted[index] = false;
		return false;
	}
}
