package ru.innolearn.day25.patterns.models.Continent;

import ru.innolearn.day25.patterns.models.Foods;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created in project Inno-Classroom-Work in 17.01.17
 */
public class ContinentFood extends Foods
{
	private boolean isTasty;

	public boolean isTasty()
	{
		return isTasty;

	}

	public void setTasty(boolean tasty)
	{
		isTasty = tasty;
	}
}
