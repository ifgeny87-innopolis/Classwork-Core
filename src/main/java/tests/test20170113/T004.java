package tests.test20170113;

/**
 * 1. Какими способами можно получить класс String?
 *
 * Created in project untitled in 14.01.17
 */
public class T004
{
	public static void main(String[] args) throws ClassNotFoundException
	{
		// 1.
		Class.forName("String");

		// 2.
		Class.forName("java.lang.String");

		// 3.
		ClassLoader.getSystemClassLoader().loadClass("String");

		// 4.
		ClassLoader.getSystemClassLoader().loadClass("java.lang.String");
	}
}
