package ru.innolearn.day01;

import ru.innolearn.day01.cartoon.another.Cartoon;

/**
 * Created by marina on 05.12.2016.
 */
public class CartoonTest
{
    static public void main(String[] args)
    {
        // Очередность определения класса:
        // 1. Прямой import. В данном случае: ru.another.Cartoon
        // 2. Класс текущего пакета: ru.serialize
        // 3. Класс подключаемых пакетов со звездочкой: ru.maps.Cartoon

        Cartoon m1 = new Cartoon();
        Cartoon m2 = new Cartoon();
        ru.innolearn.day01.maps.Cartoon m3 = new ru.innolearn.day01.maps.Cartoon();

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
    }
}
