package ru.innolearn.day25.patterns.models.Continent;

import ru.innolearn.day25.patterns.models.Foods;
import ru.innolearn.day25.patterns.models.Weapon;

/**
 * Created in project Inno-Classroom-Work in 17.01.17
 */
public class ContinentWeapon extends Weapon
{
	private int safety;

	public int getSafety()
	{
		return safety;
	}

	public void setSafety(int safety)
	{
		this.safety = safety;
	}
}
