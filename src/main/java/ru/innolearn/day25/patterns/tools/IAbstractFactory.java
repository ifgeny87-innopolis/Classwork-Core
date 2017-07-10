package ru.innolearn.day25.patterns.tools;

import ru.innolearn.day25.patterns.models.Foods;
import ru.innolearn.day25.patterns.models.Tech;
import ru.innolearn.day25.patterns.models.Weapon;

/**
 * Пример реализации паттерна Abstract Factory
 *
 * Created in project Inno-Classroom-Work in 17.01.17
 */
public interface IAbstractFactory
{
	Foods importFoods();

	Tech importTech();

	Weapon importWeapon();
}
