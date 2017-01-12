package tests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created in project Inno-Classroom-Work in 12.01.17
 */
public class tt1
{
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<>();
		list.add(Integer.class.toString());
		list.add(Integer.class.getClass().toString());
		list.add(Integer.class.getCanonicalName());
		list.add(Integer.class.getSimpleName());
		list.add(Integer.class.getTypeName());
		list.add(Integer.class.toGenericString());
		System.out.println(list);

		// [class java.lang.Integer, class java.lang.Class, java.lang.Integer, Integer, java.lang.Integer, public final class java.lang.Integer]
	}
}
