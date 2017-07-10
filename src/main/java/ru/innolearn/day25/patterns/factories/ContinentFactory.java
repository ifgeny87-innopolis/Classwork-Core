package ru.innolearn.day25.patterns.factories;

import ru.innolearn.day25.patterns.models.Continent.ContinentFood;
import ru.innolearn.day25.patterns.models.Continent.ContinentTech;
import ru.innolearn.day25.patterns.models.Continent.ContinentWeapon;
import ru.innolearn.day25.patterns.models.Foods;
import ru.innolearn.day25.patterns.models.Tech;
import ru.innolearn.day25.patterns.models.Weapon;
import ru.innolearn.day25.patterns.tools.IAbstractFactory;

/**
 * Created in project Inno-Classroom-Work in 17.01.17
 */
public class ContinentFactory implements IAbstractFactory
{
	@Override
	public Foods importFoods()
	{
		return new ContinentFood();
	}

	@Override
	public Tech importTech()
	{
		return new ContinentTech();
	}

	@Override
	public Weapon importWeapon()
	{
		return new ContinentWeapon();
	}
}
