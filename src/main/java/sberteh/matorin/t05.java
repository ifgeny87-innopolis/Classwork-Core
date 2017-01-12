package sberteh.matorin;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Три способа переобъявить методы интерфейсов с throws
 *
 * Метод не может расширить список исключений, но может сузить его
 *
 * Created in project Inno-Classroom-Work in 11.01.17
 */
interface I1
{
	void copy() throws IOException, IllegalArgumentException;
}

interface I2
{
	void copy() throws FileNotFoundException, InterruptedException;
}

class C1 implements I1, I2
{
	@Override
	public void copy() throws FileNotFoundException { }
}

class C2 implements I1, I2
{
	@Override
	public void copy() throws IllegalArgumentException { }
}

class C3 implements I1, I2
{
	@Override
	public void copy() {}
}

public class t05
{
}
