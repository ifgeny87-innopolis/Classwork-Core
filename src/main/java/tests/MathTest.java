package tests;

/**
 * Created in project Inno-Classroom-Work on 22.01.17
 */
public class MathTest
{
	public static void main(String[] args)
	{
		int a = 1, b = 2, c = 3, d = 4;

		a ^= b *= c /= d ^= a << b << c << d;

//		a += b += ++b + --a;
//		a = a + (b = b + ++b + --a);

		System.out.println(a + "\t" + b + "\t" + c + "\t" + d);
	}
}
