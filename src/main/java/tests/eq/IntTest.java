package tests.eq;

/**
 * Created in project Inno-Classroom-Work in 09.01.17
 */
public class IntTest
{
	public static void main(String[] args)
	{
		int i = 0;
		System.out.println(++i == i++); // true
		System.out.println(i++ == i++); // false
		System.out.println(++i == ++i); // false

		byte a = 0, b = 0;
		System.out.println(a++ == b++);
	}
}
