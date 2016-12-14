package ru.innolearn.tests.calls;

/**
 * Created by marina on 08.12.2016.
 */
public class Types {
	public void perform() {
		System.out.print(1);
		this.perform(2222);
	}

	public void perform(int val) {
		System.out.print(2);
	}
}
