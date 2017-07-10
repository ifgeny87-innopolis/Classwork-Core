package tests;

/**
 * Created in project mea-app on 13.02.17
 */
public class SomeTest
{
	protected int name;

	public SomeTest(int name) {
		this.name = name;
	}

	public int getName() {
		return name;
	}

	public void print() {
		System.out.println("1) " + name);
	}
}

class ChildTest extends SomeTest
{
	public String name;

	public ChildTest(int name)
	{
		super(name);
		this.name = name + "SSSS";
	}

	public void print() {
		System.out.println("2) " + name);
	}

	public static void main(String[] args)
	{
		ChildTest c = new ChildTest(128);
		SomeTest b = new ChildTest(256);

		c.print();
		((SomeTest)c).print();
		System.out.println("3) " + c.getName());

		b.print();
		((SomeTest)b).print();
		System.out.println("3) " + b.getName());
	}
}
