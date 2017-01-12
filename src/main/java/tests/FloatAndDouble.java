package tests;

/**
 * Сравниваем значения Double B Float
 *
 * Тест m1 сравнивает значения float и double
 *
 * Тест m2 показывает, что Float более хранит числа степени двойки (1, .5, .25 и тд)
 *
 * Created in project Inno-Classroom-Work in 11.01.17
 */
public class FloatAndDouble
{
	public static void main(String[] args)
	{
		// m1();
		m2();
	}

	static void m1()
	{
		for (long i = 0; i < 2_000_000_000L; i++) {
			float f = i / 100_000_000f;
			double d = i / 100_000_000d;


			if (f == d) {
				System.out.printf("F = %.20f, D = %.20f, N = %f\n",
						f, d, d / 0.00048828125);
			}
		}
	}

	static void m2()
	{
		printi(Float.NEGATIVE_INFINITY);
		printi(Float.POSITIVE_INFINITY);
		printi(Float.NaN);

		for (int i = 0; i < 100; i++) {
			printi(i * .625f);
			printi(-i * .625f);
		}
	}

	static void printi(float f)
	{
		int bin = Float.floatToIntBits(f);
		String s = Integer.toBinaryString(bin);
		System.out.printf("%10f %34s\n", f, s);
	}
}
