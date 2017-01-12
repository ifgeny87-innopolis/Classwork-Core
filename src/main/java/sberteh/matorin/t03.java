package sberteh.matorin;

/**
 * ВНИМАНИЕ!!!
 * Пример зависнет и будет жрать 100% CPU
 *
 * Все просто - рекурсия вызовет StackOverflowError и снова запустит work() и так бесконечно
 *
 * Created in project Inno-Classroom-Work in 11.01.17
 */
public class t03
{
	public static void main(String[] args)
	{
		// ну только не надо это запускать
		//work();
	}

	static void work() {
		try {
			work();
		}
		finally {
			work();
		}
	}
}
