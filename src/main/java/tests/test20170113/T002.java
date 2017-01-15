package tests.test20170113;

/**
 * 1. Какими способами можно создать объекты от A2.B2?
 * 2. Тот же вопрос, только сделать класс A2.B2 статическим
 * 3. Что будет выведено при выполнении блока 3?
 *
 * Created in project untitled in 13.01.17
 */
public class T002
{
	public static void main(String[] args)
	{
		// 1. и 2.
//		A2.B2 b1  = new A2.B2();    // 1

//		A2.B2 b2 = new x.B2();      // 2

		A2.B2 b3 = new A2().new B2();       // 3

		A2.B2 b4 = (new A2()).new B2();     // 4

		// 3.

		A2 _a = new A2();
		A2.B2 _b = _a.new B2();

		System.out.println(_b.a + ", " + _b.b.toString());

		_b.a = 200;
		_b.b.append("B");

		_a.print();
	}
}

class A2
{
	private Integer w = 100;

	private StringBuilder sb = new StringBuilder("A");

	class B2
	{
		Integer a = w;
		StringBuilder b = sb;
	}

	void print()
	{
		System.out.println("2. " + w);
		System.out.println("2. " + sb.toString());
	}
}