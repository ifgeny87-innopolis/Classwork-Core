package ru.innolearn.day26.patterns.bridge;

/**
 * Пример реализации паттерна Bridge (мост).
 *
 * Bridge - Структура, позволяющая изменять интерфейс обращения и интерфейс реализации класса независимо.
 *
 * Created in project Inno-Classroom-Work on 18.01.17
 */
public class Main
{
	public static void main(String[] args)
	{
		Shape[] shapes = {
				new Circle(5, 10, 10, new LargeCircleDrawer()),
				new Circle(20, 30, 100, new SmallCircleDrawer())};

		for (Shape next : shapes) {
			next.draw();
		}
	}
}
