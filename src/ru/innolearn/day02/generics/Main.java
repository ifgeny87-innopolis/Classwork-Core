package ru.innolearn.day02.generics;

import java.util.*;

/**
 * Created by marina on 06.12.2016.
 */
public class Main {

    public static void main(String[] args) {
        // 1 тест)
        // создаем массив кошек
        List<Cat> catSrcList = getCatList();

        // копируем один массив в другой
        // FIXME тут по идее кошки должны скопироваться из src в dest, но поучему-то вылетает IndexOutOfBoundsException
        List<Cat> catDestList = new ArrayList<>();
        Collections.copy(catDestList, catSrcList);

        for (Pet pet : catDestList)
            pet.call();

        // 2 тест)
        List<Dog> dogDestList = new ArrayList<>();
        // но мы не можем заставить кошек гавкать
        // следующая строка не скомпилируется
        //////// Collections.copy(dogDestList, catSrcList);
        for (Dog dog : dogDestList)
            dog.bark();
    }

    public static List<Cat> getCatList() {
        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        return catList;
    }

    /**
     * Animal class
     */
    static class Animal {
        public void feed() {
        }
    }

    /**
     * Pet class
     */
    static class Pet extends Animal {
        public void call() {
        }
    }

    /**
     * Cat class
     */
    static class Cat extends Pet {
        public void meow() {
        }
    }

    /**
     * Dog class
     */
    static class Dog extends Pet {
        public void bark() {
        }
    }

}
