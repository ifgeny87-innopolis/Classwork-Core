package ru.innolearn.day25.patterns.models.AzbukaVkusa;

import ru.innolearn.day25.patterns.models.Foods;

import java.util.Random;

/**
 * Created in project Inno-Classroom-Work in 17.01.17
 */
public class AzbukaFoods extends Foods
{
	private double price;

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public void setRandomPrice() {
		this.price = new Random().nextDouble();
	}
}
