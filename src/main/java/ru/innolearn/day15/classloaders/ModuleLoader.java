package ru.innolearn.day15.classloaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created in project Inno-Classroom-Work in 23.12.2016
 *
 * Класс умеет дефайнить .class файлы
 *
 * Ему нужно передать путь до папки с .class файлами и родительский ClassLoader
 */
public class ModuleLoader extends ClassLoader {
	// мето хранения файлов .class
	private final String classPath;

	/**
	 * Обязательно в конструкторе надо "запустить" родителя
	 *
	 * @param classPath путь к файлам .class
	 * @param parent    родитель
	 */
	ModuleLoader(String classPath, ClassLoader parent) {
		super(parent);
		this.classPath = classPath;
	}

	/**
	 * Выполняет поиск файла .class и "дефайнит" его байткод
	 *
	 * @param name Имя класса без пакета
	 * @return Вернет класс
	 * @throws ClassNotFoundException Ошибка чтения описания класса
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String classFile = classPath + name + ".class";

		File file = new File(classFile);

		if (!file.canRead()) {
			throw new ClassNotFoundException("File " + classFile + " is not readable");
		}

		byte[] buf = new byte[(int) file.length()];

		boolean ok = false;

		try (FileInputStream is = new FileInputStream(file)) {
			int len = is.read(buf);
			if (len == buf.length) {
				ok = true;
			}
		} catch (IOException e) {
			throw new ClassNotFoundException("File " + classFile + " can't be read", e);
		}

		if (!ok) {
			throw new ClassNotFoundException("Class in file " + classFile + " was not read");
		}

		return defineClass(name, buf, 0, buf.length);
	}
}
