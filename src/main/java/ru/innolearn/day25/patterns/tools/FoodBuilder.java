package ru.innolearn.day25.patterns.tools;

import ru.innolearn.day25.patterns.models.Foods;

/**
 * Created in project Inno-Classroom-Work in 17.01.17
 */
public abstract class FoodBuilder
{
	protected Foods foods;

	public Foods getFoods() {
		return foods;
	}

	public abstract void createFoods();

	public abstract void buildName();
	public abstract void buildPrice();
}
