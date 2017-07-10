package ru.innolearn.day25.patterns.factorymethods;

import ru.innolearn.day25.patterns.models.Continent.ContinentFood;
import ru.innolearn.day25.patterns.models.Foods;
import ru.innolearn.day25.patterns.tools.FabricCreator;

/**
 * Created in project Inno-Classroom-Work on 17.01.17
 */
public class ContinentCreator extends FabricCreator
{
	@Override
	public Foods createFoods()
	{
		return new ContinentFood();
	}
}
