package ru.innolearn.tests.puzzlers;

/**
 * Created by marina on 09.12.2016.
 */
public class Test01 {
	public static void main(String args[]) {
		Dog dog = new Dog();
		Dog nipper = new Basenji();
		Basenji basenji = new Basenji();

		new Dog().bark();
		new Basenji().bark();
		dog.bark();
		nipper.bark();
		basenji.bark();
	}
}

class Dog {
	static String bark = "woof";

	public static void bark() {
		System.out.println("woof: " + bark);
	}
}

class Basenji extends Dog {
	static String bark = "basenji";

	public static void bark() {
		System.out.println("basenji: " + bark);
	}
}