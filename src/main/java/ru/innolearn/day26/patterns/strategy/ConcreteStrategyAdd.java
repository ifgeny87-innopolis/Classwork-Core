package ru.innolearn.day26.patterns.strategy;

/**
 * Created in project Inno-Classroom-Work on 18.01.17
 */
// Реализуем алгоритм с использованием интерфейса стратегии
class ConcreteStrategyAdd implements Strategy
{
	public int execute(int a, int b)
	{
		System.out.println("Called ConcreteStrategyAdd's execute()");
		return a + b;  // Do an addition with a and b
	}
}