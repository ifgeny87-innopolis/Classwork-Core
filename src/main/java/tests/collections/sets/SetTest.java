package tests.collections.sets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Проверяем как сортируются Set'ы
 *
 * Created in project Inno-Classroom-Work in 09.01.17
 */
public class SetTest
{
	public static void main(String[] args)
	{
		Set<String> s1 = add(new HashSet<>());
		Set<String> s2 = add(new TreeSet<>());
		Set<String> s3 = add(new LinkedHashSet<>());

		print(s1);
		print(s2);
		print(s3);
	}

	public final static void a() {}

	static Set<String> add(Set<String> set)
	{
		set.add("Alex");
		set.add("" + 123);
		set.add("" + 123.);
		set.add("Zumba");
		set.add("" + true);
		set.add("" + null);
		set.add("Optium");
		set.add("\0");
		return set;
	}

	static void print(Set<String> set)
	{
		System.out.println(set.getClass().getSimpleName() + ": " + set);
	}
}
