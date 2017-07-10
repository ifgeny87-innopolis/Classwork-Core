package tests;

/**
 * Created in project Inno-Classroom-Work on 24.01.17
 */
public class ClassTest01
{
	public static void main(String[] args)
	{
		byte b = 42;

	}
}

interface I1{
	final int p = 10;
	public int get();

}

class B implements I1{
	private int p = 20;
	public int get() {
		return p;
	}
}

class C extends B implements I1{
	public int get() {
		return p;
	}
}

class A{

	public static void main(String...args){
		B obj = new C();
		System.out.print(obj.get());

	}
}