import org.junit.Test;

/**
 * Created in project Inno-Classroom-Work on 18.01.17
 */
public class MathTest
{
	@Test
	public void A()
	{
		//ругается на
//		Double d = 10;
//		Float f = 10;
//		Long l = 10;

		//не ругается на
		double d2 = 10;
		Double d3 = 10d;
		float f2 = 10;
		Float f3 = 10f;
		long l2 = 10;
		Long l3 = 10l;
		byte b2 = 10;
		Byte b3 = 10;

		//но, не ругается и на шорт, понятно, что у него приведения через s нету
		short s = 10;
		Short s2 = 10;
	}
}
