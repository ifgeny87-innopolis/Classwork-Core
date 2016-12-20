package ru.innolearn.day09.unittesting;

/**
 * Created by marina on 15.12.2016.
 */
public class Calculator {
	public int sum(int a, int b ){
		return a+b;
	}

	public void doSome(int arg) throws Exception {
		if(arg == 5)
			throw new RuntimeException("Runtime something wrong");
	}
}
