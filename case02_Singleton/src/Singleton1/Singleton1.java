package Singleton1;

/**
 * 懒汉模式 类加载进来，没有创建对象。当调用getInstance方法时，才创建对象。
 * 
 * @author WangSai
 * 
 *
 */
public class Singleton1 {
	private static Singleton1 s = null;

	private Singleton1() {
	}

	public static Singleton1 getInstance() {
		if (s == null)
			s = new Singleton1();
		return s;
	}
}