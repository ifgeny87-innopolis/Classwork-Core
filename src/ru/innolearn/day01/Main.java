package ru.innolearn.day01;

/**
 * Created by marina on 05.12.2016.
 * В какой очередности будут вызываться методы инициализации и констркторы.
 */
public class Main {

    public static void main(String[] args) {
        new C(1);
    }
}

class A
{
    {
        System.out.println("A init");
    }

    A() {
        System.out.println("A() construct");
    }

    A(int i) {
        System.out.printf("A(%d) construct\n", i);
    }
}

class B extends A
{
    {
        System.out.println("B init");
    }

    B() {
        this(2);
        System.out.println("B() construct");
    }

    B(int i) {
        // super();
        System.out.printf("B(%d) construct\n", i);
    }
}

class C extends B
{
    {
        System.out.println("C init");
    }

    C() {
        // super();
        System.out.println("C() construct");
    }

    C(int i) {
        this();
        System.out.printf("C(%d) construct\n", i);
    }
}