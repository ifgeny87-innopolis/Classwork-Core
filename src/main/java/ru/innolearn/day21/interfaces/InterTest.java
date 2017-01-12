package ru.innolearn.day21.interfaces;

/**
 * Проверка дефолтного метода и констант в интерфейсе
 *
 * Created in project untitled in 11.01.17
 */
public class InterTest implements MyIf
{
	@Override
	public void print()
	{
		System.out.println("Printed");
	}

	@Override
	public int getId()
	{
		return VAL;
	}

	public static void main(String[] args)
	{
		new InterTest().check();
	}
}

interface MyIf
{
	void print();

	int getId();

	int VAL =12;

	default void check()
	{
		if (getId() > 0)
			print();
	}
}
