package case67_movingCount;

/**
 * 题目：
 * 
 * 题目：地上有个m行n列的方格。一个机器人从坐标(0,0)的格子开始移动，它每一次可以向左、右、上、下移动一格，
 * 但不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格(35,37)，因为3+5
 * +3+7=18.但它不能进入方格(35,38)，因为3+5+3+8=19.请问该机器人能够达到多少格子？
 * 
 * @author WangSai
 * @Time 2017年6月5日17:16:58
 *
 */
public class MovingCount {

	/**
	 * @param argsm
	 */
	public static void main(String[] args) {
		System.out.println("getMovingCount:" + getMovingCount(4, 6, 6));
	}

	/**
	 * 获取机器人可以到达的格子数
	 * 
	 * @param threshold，门限值
	 * @param m，矩阵的行数
	 * @param n，矩阵的列数
	 * @return 机器人可以到达的格子数量
	 */
	public static int getMovingCount(int threshold, int m, int n) {
		// 异常值检测
		if (m <= 0 || n <= 0 || threshold < 0)
			return -1;
		boolean[] visted = new boolean[m * n];
		return getMovingCountCore(threshold, m, n, 0, 0, visted);
	}

	// 递归访问当前格子四周的格子
	private static int getMovingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visted) {
		// 判断边界值，是否越界，是否访问过，坐标和列坐标的数位之和是否大于k
		if (row < 0 || row >= rows || col < 0 || col >= cols || visted[row * cols + col]
				|| checkSum(row, col) > threshold)
			return 0;
		visted[row * cols + col] = true;
		return 1 + getMovingCountCore(threshold, rows, cols, row - 1, col, visted)
				+ getMovingCountCore(threshold, rows, cols, row + 1, col, visted)
				+ getMovingCountCore(threshold, rows, cols, row, col - 1, visted)
				+ getMovingCountCore(threshold, rows, cols, row, col + 1, visted);

	}

	/**
	 * 坐标和列坐标的数位之和
	 * 
	 * @param row,当前的行号
	 * @param col，当前的列号
	 * @return row坐标和col坐标的数位之和
	 */
	private static int checkSum(int row, int col) {
		int sum = 0;
		while (row > 0) {
			sum += row % 10;
			row /= 10;
		}
		while (col > 0) {
			sum += col % 10;
			col /= 10;
		}
		return sum;
	}
}