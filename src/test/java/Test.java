/**
 * Created in project Inno-Classroom-Work in 09.01.17
 */
public class Test
{
	/*public final static class A {}

	static private class B {}

	abstract static class C {}

	static private final class D {}*/
//	final public abstract class E{}
//	static final abstract class F{}

	public static void main(String[] args) throws IllegalAccessException, InstantiationException
	{
//		double d = Double.NaN / 0;
//		System.out.println(Double.isNaN(d));
//
//		int i = 0;
//		for(foo("A"); foo("B") && i < 2; foo("C")) {
//			i++;
//			foo("D");
//		}
//
//		System.out.println();
//
//		System.out.println(.1f + .1f + .1f + .1f + .1f + .1f + .1f + .1f + .1f + .1f);
//		System.out.println(.1d+.1d+.1d+.1d+.1d+.1d+.1d+.1d+.1d+.1d);

//		Float f1 = new Float(Float.NaN);
//		Float f2 = new Float(Float.NaN);
//		System.out.println(f1==f2);
//		System.out.println(f1.equals(f2));
//		System.out.println(Float.NaN == Float.NaN);

//		long x = Long.MAX_VALUE;
//		double y = (double)Long.MAX_VALUE;
//		long z= Long.MAX_VALUE-1;
//
//		System.out.println(x == y);
//		System.out.println(x == z);
//		System.out.println(y == z);

//		System.out.println(new A().d);

//		Boolean b= true;
//		System.out.println(b.hashCode());

//		class Sync implements Runnable {
//
//			@Override
//			public void run()
//			{
//				synchronized ("X") {
//					System.out.println("X ");
//					run2();
//				}
//			}
//
//			public void run2()
//			{
//				synchronized ("X") {
//					System.out.println("X2 ");
//				}
//			}
//		}
//
//		Sync s = new Sync() ;
//		Thread t1 = new Thread(s);
//		Thread t2 = new Thread(s);
//		t2.start();
//		t1.start();

		Object o = true ? new Float("1") : new Double("5");
		System.out.println(o.getClass() + " " + o);

		Long l1 = 100L;
		Long l2 = 100L;

		Long l3 = 200L;
		Long l4 = 200L;

		System.out.println(l1 == l2);
		System.out.println(l3 == l4);
	}

	static void f(int a, Integer... b) {}

	static void f(Integer a, int b) {}

	static boolean foo(String a)
	{
		System.out.print(a);
		return true;
	}
}

class O1 {
	class P1 {}
}

class Q1 extends O1.P1 {
	Q1(O1 o) {
		o.super();
	}
}

class A
{
	public int d = 1;

	{
		d = new A().d;
	}
}

class P {
	public static void main(String[] args)
	{

	}
}

class Q extends P {
	public static void main(String[] args)
	{
		synchronized ("X") {}
	}
}

class X<X> {

}