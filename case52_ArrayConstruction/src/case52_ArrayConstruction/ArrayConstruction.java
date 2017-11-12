package case52_ArrayConstruction;

/**
 * 题目：给定一个数组A[0，1，2，...,N-1],请构建一个数组B[0，1，2，...,N-1]，其中B中的元素:
 * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]*A[n]。不能用除法。
 * 
 * @author WangSai
 *
 */
public class ArrayConstruction {

	public static void main(String[] args) {
		double[] A1 = { 1, 2, 3 };
		double[] B1 = multiply(A1);

		MyPrint(B1);
		double[] A2 = { 1, 2 };
		double[] B2 = multiply(A2);
		MyPrint(B2);

		double[] A3 = { 1, 2, 3, 4 };
		double[] B3 = multiply(A3);
		MyPrint(B3);

		double[] A4 = { 0, 2, 3, 4 };
		double[] B4 = multiply(A4);
		MyPrint(B4);
	}

	/**
	 * @param A2
	 * @param B2
	 */
	public static void MyPrint(double[] B) {
		for (int i = 0; i < B.length; i++) {
			System.out.print(B[i] + " ");
		}
		System.out.println();
	}

	/**
	 * 把B[i]的值看成由一个矩阵来创建
	 * 
	 * @param A，给定的数组
	 * @return 构建出来的成绩数组
	 */
	private static double[] multiply(double[] A) {
		// A必须至少有两个元素，才可以生成B数组
		if (A == null || A.length <= 1) {
			return null;
		}
		// 创建B数组
		double[] B = new double[A.length];
		// 根据矩阵，自上而下创建C数组。可以暂时把B数组当做C数组使用
		B[0] = 1;
		for (int i = 1; i < A.length; i++) {
			B[i] = B[i - 1] * A[i - 1];
		}
		// 根据矩阵，自下而上创建数组D[i]。创建数组后需要遍历C[i]*D[i]得到B[i]。
		// 所以可以用一个变量temp替代D[i],就可以C[i]*temp得到B[i]
		double temp = 1;
		for (int i = A.length - 1 - 1; i >= 0; i--) {
			temp *= A[i + 1];
			// B[i] = C[i]*D[i]
			B[i] = temp * B[i];
		}
		return B;
	}

}
