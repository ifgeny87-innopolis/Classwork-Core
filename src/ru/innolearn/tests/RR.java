package ru.innolearn.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by marina on 08.12.2016.
 */
public class RR {
    public static void main(String[] args) {
        String[] list = {"Alpha", "Delta", "Bravo", "Omnega"};

        Object o = Arrays.asList(list).stream().map(line -> {
            System.out.println(line);
            return !line.equals("Bravo");
        });

        System.out.println(o);
    }
}
