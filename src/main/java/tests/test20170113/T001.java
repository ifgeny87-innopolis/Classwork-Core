package tests.test20170113;

/**
 * 1. Что будет выведено после выполнения программы?
 *
 * Created in project untitled in 13.01.17
 */
public class T001
{
	public static void main(String[] args)
	{
		C1 c = new C1();
		c.a();
		c.b();

		I1 g = new C1();
		I1.a();
		g.b();
	}
}

interface I1
{
	static void a() { System.out.print(1); }

	default void b() { System.out.print(2); }
}

class C1 implements I1
{
	static void a() { System.out.print(3); }

	void b(int a) { System.out.println(4); }
}