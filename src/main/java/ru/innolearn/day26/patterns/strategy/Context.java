package ru.innolearn.day26.patterns.strategy;

/**
 * Created in project Inno-Classroom-Work on 18.01.17
 */
// Класс контекста использующий интерфейс стратегии
class Context
{
	private Strategy strategy;

	// Constructor
	public Context() { }

	// Set new strategy
	public void setStrategy(Strategy strategy)
	{
		this.strategy = strategy;
	}

	public int executeStrategy(int a, int b)
	{
		return strategy.execute(a, b);
	}
}