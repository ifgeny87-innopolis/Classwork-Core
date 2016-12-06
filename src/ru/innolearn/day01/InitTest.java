package ru.innolearn.day01;

/**
 * Created by marina on 05.12.2016.
 *
 * Логика вызова инитов и констркуторов:
 *  - static init блок будет вызван лишь один раз при обращении к классу.
 *  - init блок вызывается каждый раз при создании нового экземпляра.
 *  - при создании экземпляра дочернего класса, выполняется последовательность:
 *      1. Если не указан super() или this(), то выпонится super();
 *      2. Выполняется init если еще не выполнялся для этого объекта;
 *      3. Выполняются остальные операции в конструкторе.
 * В какой очередности будут вызываться методы инициализации и констркторы.
 * Что будет выведено в консоль?
 */
public class InitTest {

    public static void main(String[] args) {
        System.out.println("--- Test01: A.out(); ---");
        A.out();

        System.out.println("--- Test02: new B(); ---");
        new B();

        System.out.println("--- Test03: new C(1); ---");
        new C();
    }
}

class A
{
    static {
        System.out.println("A static init");
    }

    static void out() {
        System.out.println("A static out()");
    }

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
    static {
        System.out.println("B static init");
    }

    {
        System.out.println("B init");
    }

    B() {
        // Тут компилятор добавит super();
        System.out.println("B() construct");
    }

    B(int i) {
        this();
        System.out.printf("B(%d) construct\n", i);
    }
}

class C extends B
{
    static {
        System.out.println("C static init");
    }

    {
        System.out.println("C init");
    }

    C() {
        this(2);
        System.out.println("C() construct");
    }

    C(int i) {
        super(i + 1);
        System.out.printf("C(%d) construct\n", i);
    }
}