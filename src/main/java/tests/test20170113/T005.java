package tests.test20170113;

/**
 * 1. Что будет выведено после выполнения программы?
 *
 * Created in project untitled in 13.01.17
 */
public class T005
{
	public static void main(String[] args)
	{
		B5 b = new B5(new B5(new B5(null, 1), 2), 3);
		while(b != null) {
			System.out.print(b.index);
			b = b.value;
		}
	}
}

class A5<T> {
	int index;
	T value;

	A5(T value, int index) {
		System.out.print("A");
		this.index = index;
		this.value = value;
	}
}

class B5 extends A5<B5>
{

	B5(B5 value, int index)
	{
		super(value, index);
		System.out.print("B");
	}
}