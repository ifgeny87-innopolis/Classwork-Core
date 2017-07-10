package ru.innolearn.day25.patterns.decorator_test;

/**
 * Created in project Inno-Classroom-Work on 17.01.17
 */
public class Молочко extends КофейныйДекоратор
{
	public Молочко(КофейныйКомпонент компонент)
	{
		super(компонент);
	}

	@Override
	public void показатьИнгридиенты()
	{
		super.показатьИнгридиенты();

		System.out.println("Молочко");
	}
}
