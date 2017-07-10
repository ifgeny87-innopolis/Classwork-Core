package ru.innolearn.day25.patterns.factories;

import ru.innolearn.day25.patterns.models.*;
import ru.innolearn.day25.patterns.models.AzbukaVkusa.AzbukaFoods;
import ru.innolearn.day25.patterns.models.AzbukaVkusa.AzbukaTech;
import ru.innolearn.day25.patterns.models.AzbukaVkusa.AzbukaWeapon;
import ru.innolearn.day25.patterns.tools.IAbstractFactory;

/**
 * Created in project Inno-Classroom-Work in 17.01.17
 */
public class AzbukaFactory implements IAbstractFactory
{
	@Override
	public Foods importFoods()
	{
		return new AzbukaFoods();
	}

	@Override
	public Tech importTech()
	{
		return new AzbukaTech();
	}

	@Override
	public Weapon importWeapon()
	{
		return new AzbukaWeapon();
	}
}
