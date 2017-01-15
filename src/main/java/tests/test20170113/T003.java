package tests.test20170113;

/**
 * 1. Что будет выведено после выполнения программы?
 *
 * Created in project untitled in 13.01.17
 */
public class T003
{
	public static void main(String[] args) throws ClassNotFoundException
	{
		ClassLoader sys = ClassLoader.getSystemClassLoader();
		System.out.println(sys);

		ClassLoader ext = sys.getParent();
		System.out.println(ext);

		ClassLoader boots = ext.getParent();
		System.out.println(boots);

		ClassLoader exboots = boots.getParent();
		System.out.println(exboots);
	}
}
