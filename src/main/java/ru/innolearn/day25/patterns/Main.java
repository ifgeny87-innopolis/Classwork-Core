package ru.innolearn.day25.patterns;

import ru.innolearn.day25.patterns.decorator_test.Ванилька;
import ru.innolearn.day25.patterns.decorator_test.Кофейко;
import ru.innolearn.day25.patterns.decorator_test.Молочко;
import ru.innolearn.day25.patterns.decorator_test.Сахарок;

/**
 * Created in project Inno-Classroom-Work in 17.01.17
 */
public class Main
{
	public static void main(String[] args)
	{
		Кофейко кофе = new Кофейко();
		Сахарок сахар = new Сахарок(кофе);
		Молочко молоко = new Молочко(сахар);
		Ванилька ваниль = new Ванилька(молоко);

		System.out.println("Вот просто кофе:");
		кофе.показатьИнгридиенты();

		System.out.println("Кофе с сахаром:");
		сахар.показатьИнгридиенты();

		System.out.println("Кофе с сахаром и молоком:");
		молоко.показатьИнгридиенты();

		System.out.println("Кофе фул:");
		ваниль.показатьИнгридиенты();
	}
}
