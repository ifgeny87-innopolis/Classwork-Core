package tests;

/**
 * Created by marina on 12.12.2016.
 */
public class ClassTest {
	public static void main(String[] args) {
		System.out.println("Class: " + Integer.class);
		System.out.println("Class of class: " + Integer.class.getClass());
		System.out.println("Canonical class name: " + Integer.class.getCanonicalName());
		System.out.println("Simple name: " + Integer.class.getSimpleName());
		System.out.println("Type name: " + Integer.class.getTypeName());
		System.out.println("Package: " + Integer.class.getPackage());
		System.out.println("Protection domain: " + Integer.class.getProtectionDomain());
		System.out.println("Generic string: " + Integer.class.toGenericString());
		System.out.println("Declared fields: " + Integer.class.getDeclaredFields());
		System.out.println("Declared methods: " + Integer.class.getDeclaredMethods());

		// попробую создать новый объект по имени класса
		try {
			Object i = Class.forName("java.lang.Integer").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
