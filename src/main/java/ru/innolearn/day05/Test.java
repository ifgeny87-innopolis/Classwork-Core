package ru.innolearn.day05;

/**
 * Created by marina on 09.12.2016.
 */
public class Test {
	public static void main(String[] args) {
		System.out.printf("%,d\n", 1 << 29);
		System.out.printf("%,d\n", 1 << 30);
		System.out.printf("%,d\n", 1 << 31);
		System.out.printf("%,d\n", 1 << 32);

		String s = "/tmp/usr".substring(4);
		String s1 = s;
		System.out.println(s + " " + s1);
	}
}
