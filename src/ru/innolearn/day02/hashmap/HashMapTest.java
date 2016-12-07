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
        // создаем Ивана
        Human human = new Human(25, "Ivan");

        // создаем Машину
        Car car = new Car("Vesta", 2016);

        // создаем точно того же Ивана
        Human human2 = getFromDb();

        Map map = new HashMap();

        map.put(human, car);

        // Иван равен Ивану?
        System.out.println("Ivan = " + human);
        System.out.println("Ivan2 = " + human2);
        System.out.println("Ivan == Ivan2: " + (human == human2));
        System.out.println("Ivan equals Ivan2: " + (human.equals(human2)));

        // А вот машина Ивана
        System.out.println("Ivan's car = " + map.get(human));
        System.out.println("Ivan2's car = " + map.get(human2));

        // А что если у Ивана изменится имя или возраст?
        human.setAge(45);
        System.out.println("Old Ivan's car = " + map.get(human));
        System.out.println("Ivan2's car = " + map.get(human2));

        // Иван снова молодеет, и у него опять появилась машина
        human.setAge(25);
        System.out.println("Ivan's car = " + map.get(human));
        System.out.println("Ivan2's car = " + map.get(human2));
    }

    public static Human getFromDb() {
        return new Human(25, "Ivan");
    }
}
