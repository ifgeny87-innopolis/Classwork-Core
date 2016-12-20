package ru.innolearn.day06.refletion;

/**
 * Created by marina on 12.12.2016.
 */
class Human {
	public String name;
	protected int age;
	private String state;
	final int money = 100;

	public Human(String name, int age, String state) {
		this.name = name;
		this.age = age;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
