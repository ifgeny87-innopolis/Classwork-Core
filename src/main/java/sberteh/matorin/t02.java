package sberteh.matorin;

/**
 * Final строковые переменные тоже хранятся в пуле строк
 *
 * Created in project Inno-Classroom-Work in 11.01.17
 */
public class t02
{
	public static void main(String[] args)
	{
		String s1 = "hello";
		final String s2 = "hel";
		String s3 = "lo";
		String s4 = "hello";

		System.out.println(s1 == s4);   // true
		System.out.println(s1 == s2 + s3);  // false
		System.out.println(s1 == s2 + "lo");    // true
	}
}
