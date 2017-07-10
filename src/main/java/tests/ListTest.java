package tests;

import org.hibernate.internal.util.collections.IdentitySet;
import org.springframework.beans.factory.support.ManagedSet;

import java.util.*;

import static tests.ListTest.t01;

/**
 * Created in project Inno-Classroom-Work on 24.01.17
 */
public class ListTest
{
	public static void main(String[] args)
	{
		t01();
		t02();
		t03();
		t04();
	}

	static void print(Iterable<String> arg)
	{
		System.out.print(arg.getClass().getSimpleName());
		for (String entry : arg)
			System.out.print(", " + entry);
		System.out.println();
	}

	static void fillSet(Set<String> set)
	{
		set.add("2");
		set.add("1");
		set.add("2");
		set.add("4000");
		set.add("333333");
		set.add("555");
	}

	static void t01()
	{
		Set<String> set = new HashSet<>();
		fillSet(set);
		print(set);
	}

	static void t02()
	{
		Set<String> set = new LinkedHashSet<>();
		fillSet(set);
		print(set);
	}

	static void t03()
	{
		Set<String> set = new ManagedSet<>();
		fillSet(set);
		print(set);
	}

	static void t04()
	{
		Set<String> set = new TreeSet<>();
		fillSet(set);
		print(set);
	}

	static void t05()
	{
		Set<String> set = new IdentitySet();
		fillSet(set);
		print(set);
	}
}

class Super {
	static final int i = 10;

	int i() { return i; }
}

class Child extends Super {
	static int i = 20;

	int i() { return i; }

	public static void main(String[] args)
	{
		System.out.println(new Child().i());
	}
}