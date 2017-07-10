package ru.innolearn.day25.patterns.decorator_test;

/**
 * Created in project Inno-Classroom-Work on 17.01.17
 */
public class Кофейко implements КофейныйКомпонент
{
	@Override
	public void показатьИнгридиенты()
	{
		System.out.println("Кофейко");
	}
}
