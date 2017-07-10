package ru.innolearn.day25.patterns.models.Continent;

import ru.innolearn.day25.patterns.models.Foods;
import ru.innolearn.day25.patterns.models.Tech;

/**
 * Created in project Inno-Classroom-Work in 17.01.17
 */
public class ContinentTech extends Tech
{
	private boolean isSale;

	public boolean isSale()
	{
		return isSale;
	}

	public void setSale(boolean sale)
	{
		isSale = sale;
	}
}
