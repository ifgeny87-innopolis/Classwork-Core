package ru.innolearn.day21.singeroficiant;

/**
 * Пример описывает проблему "Поющего официанта".
 * Мы не сможем наследовать класс от двух классов.
 *
 * А этот пример показывает, что интерфейс требует реализации методов, даже если описан default метод в другом интерфейсе.
 *
 * Created in project untitled in 11.01.17
 */
public class SingerOficiant implements Oficiant, Singer
{

	public static void main(String[] args)
	{
		new SingerOficiant().dowork();
	}

	/**
	 * Этот метод необходимо реализовать, этого требует интерфейс Oficiant
	 */
	@Override
	public void dowork()
	{
		System.out.println("Bla");
	}
}
