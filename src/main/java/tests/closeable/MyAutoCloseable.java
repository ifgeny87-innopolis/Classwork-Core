package tests.closeable;

/**
 * Created by marina on 16.12.2016.
 */
public class MyAutoCloseable implements AutoCloseable {
	@Override
	public void close() throws Exception {
		System.out.println("MyAutoCloseable.close called");
	}
}
