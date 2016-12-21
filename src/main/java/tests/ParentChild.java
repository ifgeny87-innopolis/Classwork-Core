package tests;

/**
 * Created by marina on 08.12.2016.
 */
public class ParentChild {
	public static void main(String[] args) {
		Parent p = new Parent();
		System.out.println("# Parent");
		p.a();

		Child c = new Child();
		System.out.println("# Child");
		c.a();

		Parent c1 = new Child();
		System.out.println("# Parent as Child");
		c1.a();
	}

	static class Parent {
		protected String name = "parent";
		protected String key;

		{
			key = "parent";
		}

		void a() {
			System.out.println("Parent a: " + name + ", " + key);
			b();
		}

		void b() {
			System.out.println("Parent b: " + name + ", " + key);
		}
	}

	static class Child extends Parent {
		String name = "child";

		{
			key = "child";
		}

		void b() {
			System.out.println("Child b: " + name + ", " + key);
		}
	}
}
