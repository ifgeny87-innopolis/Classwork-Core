package ru.innolearn.tests.closeable;

import java.io.*;

public class Main {
	public static void main(String[] args) {
		try (MyCAC cl = new MyCAC()) {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

interface A {
	void a();
}

abstract class MySupa implements AutoCloseable {
}

class MyCAC extends MySupa implements A {

	@Override
	public void close() throws IOException {
		System.out.println("MyCAC");
	}

	@Override
	public void a() {

	}
}
