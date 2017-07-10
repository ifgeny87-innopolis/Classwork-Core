package ru.innolearn.day25.patterns.models.AzbukaVkusa;

import ru.innolearn.day25.patterns.models.Weapon;

/**
 * Created in project Inno-Classroom-Work in 17.01.17
 */
public class AzbukaWeapon extends Weapon
{
	private boolean isStraziki;

	public boolean isStraziki()
	{
		return isStraziki;
	}

	public void setStraziki(boolean straziki)
	{
		isStraziki = straziki;
	}
}
