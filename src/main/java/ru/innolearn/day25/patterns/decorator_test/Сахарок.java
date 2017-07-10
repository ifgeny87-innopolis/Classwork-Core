package ru.innolearn.day25.patterns.decorator_test;

/**
 * Created in project Inno-Classroom-Work on 17.01.17
 */
public class Сахарок extends КофейныйДекоратор
{
	public Сахарок(КофейныйКомпонент компонент)
	{
		super(компонент);
	}

	@Override
	public void показатьИнгридиенты()
	{
		super.показатьИнгридиенты();

		System.out.println("Сахарок");
	}
}
