package ru.innolearn.day02.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by marina on 06.12.2016.
 *
 * Играемся с HashMap:
 * 1. Создаем два объекта Human, которые равны по equals() и hashCode()
 * 2. Для первого в HashMap добавим машину
 * 3. Проверим, оба Ивана имеют эту машину
 * 4. Первый Иван внезапно стареет, и теперь машина ему не доступна
 * 4*. Но и для второго Ивана, которому 25 лет, машина тоже перестала быть доступной
 * 5. Иван молодеет и теперь для обоих Иванов доступна машина
 */
public class HashMapTest {
	public static void main(String[] args) {
		// создаем Ивана 1
		Human human1 = new Human(25, "Ivan");

		// создаем Машину 1 для Ивана 1
		Car car1 = new Car("Vesta", 2016);

		// создаем точно того же Ивана
		Human human2 = getFromDb();

		// создаем Машину 2 для Ивана 2
		Car car2 = new Car("Belarus", 1970);

		Map map = new HashMap();

		map.put(human1, car1);
		map.put(human2, car2);

		// Иван равен Ивану?
		System.out.println("1. Humans:");
		System.out.println("Ivan1 = " + human1);
		System.out.println("Ivan2 = " + human2);
		System.out.println("Ivan1 == Ivan2: " + (human1 == human2));
		System.out.println("Ivan1 equals Ivan2: " + (human1.equals(human2)));

		// А вот машины Иванов
		System.out.println("2. Cars:");
		System.out.println("Car1 " + car1.getBrand() + ", " + car1);
		System.out.println("Car2 " + car2.getBrand() + ", " + car2);
		System.out.println("Ivan1's car = " + map.get(human1));
		System.out.println("Ivan2's car = " + map.get(human2));

		// А что если у Ивана изменится имя или возраст?
		human1.setAge(45);
		System.out.println("3. Ivan1 45 years old:");
		System.out.println("Ivan1 = " + human1);
		System.out.println("Ivan2 = " + human2);
		System.out.println("Ivan1 == Ivan2: " + (human1 == human2));
		System.out.println("Ivan1 equals Ivan2: " + (human1.equals(human2)));
		System.out.println("Ivan1's car = " + map.get(human1));
		System.out.println("Ivan2's car = " + map.get(human2));

		// Иван снова молодеет, и у него опять появилась машина
		human1.setAge(25);
		System.out.println("4. Ivan1 25 again:");
		System.out.println("Ivan1's car = " + map.get(human1));
		System.out.println("Ivan2's car = " + map.get(human2));

		// А что если у Ивана изменится имя или возраст?
		human2.setAge(45);
		System.out.println("5. Ivan5 45 years old:");
		System.out.println("Ivan1's car = " + map.get(human1));
		System.out.println("Ivan2's car = " + map.get(human2));
	}

	public static Human getFromDb() {
		return new Human(25, "Ivan");
	}
}
