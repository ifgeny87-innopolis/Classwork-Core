package sberteh.matorin;

/**
 * У enum сначала выполняется конструктор, лишь потом static init
 *
 * Created in project Inno-Classroom-Work in 11.01.17
 */
enum Values
{
	A(1), B(2), C(3);

	static {
		System.out.println("static");
	}

	Values(int i)
	{
		System.out.println(i);
	}
}

public class t06
{
	public static void main(String[] args)
	{
		System.out.println(Values.A);
	}
}
