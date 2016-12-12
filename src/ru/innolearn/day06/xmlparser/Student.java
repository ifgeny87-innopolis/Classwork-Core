package ru.innolearn.day06.xmlparser;

/**
 * Класс Студент
 */
class Student extends Human {
	private int course;

	@Override
	public String toString() {
		return "Student {" +
				"name='" + name + '\'' +
				", age=" + age +
				", course=" + course +
				'}';
	}
}
