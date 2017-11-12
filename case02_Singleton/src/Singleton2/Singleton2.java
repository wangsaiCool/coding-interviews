package Singleton2;

/**
 * 饿汉模式 类一加载，就创建对象。
 * 
 * @author WangSai
 *
 */
public class Singleton2 {
	private static Singleton2 s = new Singleton2();
	private Singleton2(){
		
	}

	public static Singleton2 getInstance() {
		return s;
	}


}
