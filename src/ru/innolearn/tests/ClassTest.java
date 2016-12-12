package ru.innolearn.tests;

/**
 * Created by marina on 12.12.2016.
 */
public class ClassTest {
	public static void main(String[] args) {
		System.out.println(Integer.class);
		System.out.println(Integer.class.getClass());
		System.out.println(Integer.class.getCanonicalName());
		System.out.println(Integer.class.getSimpleName());
		System.out.println(Integer.class.getTypeName());
		System.out.println(Integer.class.getPackage());
		System.out.println(Integer.class.getProtectionDomain());
		System.out.println(Integer.class.toGenericString());
		System.out.println(Integer.class.getDeclaredFields());
		System.out.println(Integer.class.getDeclaredMethods());

		// попробую создать новый объект по имени класса
		try {
			Object i = Class.forName("java.lang.Integer").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
