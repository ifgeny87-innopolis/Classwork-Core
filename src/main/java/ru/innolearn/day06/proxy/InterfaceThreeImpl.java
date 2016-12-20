package ru.innolearn.day06.proxy;

/**
 * Created by marina on 12.12.2016.
 */
class InterfaceThreeImpl implements InterfaceThree {
	@Override
	public void doSome(int number) {
		System.out.println("3: Number is " + number);
	}

	@Override
	public void doSome(String s) {
		System.out.println("3: String is " + s);
	}
}
