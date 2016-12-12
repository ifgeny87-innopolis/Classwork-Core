package ru.innolearn.day06.xmlparser;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс-помощник
 */
class ClassLib {
	/**
	 * Поулчает на вход класс, возвращает список полей с иерархией
	 * Составляет список полей класса, потом родительского класса и так до Object
	 *
	 * @param clazz Класс, поля которого нужно получить
	 * @return Список полей класса с учетом иерархии
	 */
	static Map<String, Field> getClassFields(Class clazz) {
		// собираю все поля класса с родительскими классами до Object
		Map<String, Field> fields = new HashMap<>();
		Class cls = clazz;
		while (cls != Object.class) {
			Arrays.stream(cls.getDeclaredFields()).forEach(f -> {
				if (!fields.containsKey(f.getName()))
					fields.put(f.getName(), f);
			});
			// перехожу к родительскому классу
			cls = cls.getSuperclass();
		}

		// конвертирую в массив
		return fields;
	}
}
