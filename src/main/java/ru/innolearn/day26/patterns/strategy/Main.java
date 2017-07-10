package ru.innolearn.day26.patterns.strategy;

/**
 * Пример реализации паттерна Strategy.
 *
 * Стратегия (англ. Strategy) — поведенческий шаблон проектирования, предназначенный для определения семейства алгоритмов, инкапсуляции каждого из них и обеспечения их взаимозаменяемости. Это позволяет выбирать алгоритм путём определения соответствующего класса. Шаблон Strategy позволяет менять выбранный алгоритм независимо от объектов-клиентов, которые его используют.
 *
 * Created in project Inno-Classroom-Work on 18.01.17
 */
public class Main
{
	public static void main(String[] args)
	{
		Context context = new Context();

		context.setStrategy(new ConcreteStrategyAdd());
		int resultA = context.executeStrategy(3, 4);

		context.setStrategy(new ConcreteStrategySubtract());
		int resultB = context.executeStrategy(3, 4);

		context.setStrategy(new ConcreteStrategyMultiply());
		int resultC = context.executeStrategy(3, 4);

		System.out.println("Result A : " + resultA);
		System.out.println("Result B : " + resultB);
		System.out.println("Result C : " + resultC);
	}
}
