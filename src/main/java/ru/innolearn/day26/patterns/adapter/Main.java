package ru.innolearn.day26.patterns.adapter;

/**
 * Пример Адаптера через наследование.
 *
 * Адаптер - Объект, обеспечивающий взаимодействие двух других объектов, один из которых использует, а другой предоставляет несовместимый с первым интерфейс.
 *
 * Created in project Inno-Classroom-Work on 18.01.17
 */
public class Main
{
	public static void main(String[] args)
	{
		Chief ch = new ChiefAdapter();
		Object dish = ch.makeLunch();
		System.out.println(dish);
	}
}

// Target
interface Chief
{
	Object makeLunch();
}

// Adaptee
class Plumber
{
	public Object getCake()
	{
		return "Cake";
	}
}

// Adapter
class ChiefAdapter extends Plumber implements Chief
{
	public Object makeLunch()
	{
		return getCake();
	}
}