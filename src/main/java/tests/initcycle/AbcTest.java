package tests.initcycle;

/**
 * Created by marina on 05.12.2016.
 *
 * Логика вызова инитов и констркуторов:
 * - static init блок будет вызван лишь один раз при обращении к классу.
 * - init блок вызывается каждый раз при создании нового экземпляра.
 * - при создании экземпляра дочернего класса, выполняется последовательность:
 * 1. Если не указан super() или this(), то выпонится super();
 * 2. Выполняется init если еще не выполнялся для этого объекта;
 * 3. Выполняются остальные операции в конструкторе.
 * В какой очередности будут вызываться методы инициализации и констркторы.
 * Что будет выведено в консоль?
 */
public class AbcTest
{
	public static void main(String[] args)
	{
		System.out.println("--- Test01: A.out(); ---");
		A.out();

		System.out.println("--- Test02: new B(); ---");
		new B();

		System.out.println("--- Test03: new C(1); ---");
		new C();
	}
}

/**
 * Class A -> Object
 */
class A
{
	static int a = 10;
	int a_ = 100;

	static {
		System.out.println("A static init:\t" + a++);
	}

	static void out()
	{
		System.out.println("A static out():\t" + a++);
	}

	{
		System.out.println("Instance of A init:\t" + a++ + ", " + a_++);
	}

	A()
	{
		System.out.println("A() construct:\t" + a++ + ", " + a_++);
	}
}

/**
 * Class B -> A -> Object
 */
class B extends A
{
	static int b = 20;
	int b_ = 200;

	static {
		System.out.println("B static init:\t" + b++);
	}

	{
		System.out.println("B init:\t" + b++);
	}

	B()
	{
		// Тут компилятор добавит super();
		System.out.println("B() construct:\t" + b++ + ", " + b_++);
	}

	B(int i)
	{
		this();
		System.out.printf("B(%d) construct:\t%d, %d\n", i, b++, b_++);
	}
}

/**
 * Class C -> B -> A -> Object
 */
class C extends B
{
	static int c = 30;
	int c_ = 300;

	static {
		System.out.println("C static init:\t" + c++);
	}

	{
		System.out.println("C init:\t" + c++ + ", " + c_++);
	}

	C()
	{
		this(2);
		System.out.println("C() construct:\t" + c++ + ", " + c_++);
	}

	C(int i)
	{
		super(i + 1);
		System.out.printf("C(%d) construct:\t%d, %d\n", i, c++, c_++);
	}
}