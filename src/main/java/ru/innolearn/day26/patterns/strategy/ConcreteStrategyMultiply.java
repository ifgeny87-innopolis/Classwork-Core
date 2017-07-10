package ru.innolearn.day26.patterns.strategy;

/**
 * Created in project Inno-Classroom-Work on 18.01.17
 */
// Реализуем алгоритм с использованием интерфейса стратегии
class ConcreteStrategyMultiply implements Strategy {

	public int execute(int a, int b) {
		System.out.println("Called ConcreteStrategyMultiply's execute()");
		return a * b;   // Do a multiplication with a and b
	}
}