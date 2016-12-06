package ru.innolearn.day01;

import ru.innolearn.day01.another.Map;
import ru.innolearn.day01.maps.*;

/**
 * Created by marina on 05.12.2016.
 */
public class MapTest
{
    static public void main(String[] args)
    {
        // Очередность определения класса:
        // 1. Прямой import. В данном случае: ru.another.Map
        // 2. Класс текущего пакета: ru.test
        // 3. Класс подключаемых пакетов со звездочкой: ru.maps.Map

        Map m1 = new Map();
        ru.innolearn.day01.another.Map m2 = new ru.innolearn.day01.another.Map();
        ru.innolearn.day01.maps.Map m3 = new ru.innolearn.day01.maps.Map();

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
    }
}
