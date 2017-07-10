package ru.innolearn.day26.patterns.strategy;

/**
 * Created in project Inno-Classroom-Work on 18.01.17
 */
// Класс реализующий конкретную стратегию, должен реализовывать этот интерфейс
// Класс контекста использует этот интерфейс для вызова конкретной стратегии
interface Strategy
{
	int execute(int a, int b);
}