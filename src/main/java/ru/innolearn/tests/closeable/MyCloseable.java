package ru.innolearn.tests.closeable;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by marina on 16.12.2016.
 */
public class MyCloseable implements Closeable {
	@Override
	public void close() throws IOException {
		System.out.println("MyCloseable.close called");
	}
}
