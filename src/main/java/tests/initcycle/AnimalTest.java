package tests.initcycle;

/**
 * Created in project Inno-Classroom-Work in 08.01.17
 */
public class AnimalTest
{
	public static void main(String  args[])
	{
		new AnimalTest().new Dog();

		for(long l : new int[] {}) {}
	}

	class Animal {
		String name = "noname";

		Animal() {
			print();
		}

		public void print() {
			System.out.println(name);
			System.out.println(getName());
		}

		public String getName() {
			return name;
		}
	}

	class Dog extends Animal {
		String name = "Michael";

		Dog() {
			print();
		}

		@Override
		public String getName() {
			return name;
		}
	}
}

