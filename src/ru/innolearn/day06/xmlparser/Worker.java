package ru.innolearn.day06.xmlparser;

/**
 * Класс Работник
 */
class Worker extends Human {
	private String jobtitle;

	@Override
	public String toString() {
		return "Worker{" +
				"name='" + name + '\'' +
				", age=" + age +
				", jobtitle='" + jobtitle + '\'' +
				'}';
	}
}
