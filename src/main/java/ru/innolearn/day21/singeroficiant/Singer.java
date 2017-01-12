package ru.innolearn.day21.singeroficiant;

/**
 * Created in project untitled in 11.01.17
 */
public interface Singer
{
	default void dowork() {
		System.out.println("Aaa-a-a--a-a-a--aaa");
	}
}
