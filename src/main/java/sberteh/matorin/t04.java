package sberteh.matorin;

/**
 * Что выведет?
 *
 * Будет ошибка NoClassDefFoundError. Потому что нельзя использовать класс, который вызвал ошибку при инициализации.
 *
 * Created in project Inno-Classroom-Work in 11.01.17
 */
class Test
{
	static {
		if (true) throw new NullPointerException();
	}

	static void run()
	{
		System.out.println("Runned!");
	}
}

public class t04
{
	public static void main(String[] args)
	{
		try {
			Test.run();
		} catch (Throwable e) {
			Test.run();
		}
	}
}
