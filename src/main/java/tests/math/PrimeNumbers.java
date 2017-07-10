package tests.math;

import java.util.Arrays;

/**
 * Created in project Inno-Classroom-Work on 07.02.17
 */
public class PrimeNumbers
{
	public static void main(String[] args)
	{
		int N = 1_000_000;

		// создам массив флагов "простое/не простое"
		boolean[] prime = new boolean[N+1];
		Arrays.fill(prime, true);

		// 1 - это ислючение
		prime[1] = false;

		int itick = 0;
		int jtick = 0;

		for (int i = 2; i * i <= N; ++i) {
			++itick;
			if (prime[i])
				for (int j = i * i; j <= N; j += i) {
					prime[j] = false;
					++jtick;
				}
		}

		// print
		for (int i = 2; i <= N; ++i) {
			if (prime[i])
				System.out.printf("%d ", i);
		}

		System.out.printf("\nI ticks = %d\nJ ticks = %d", itick, jtick);
	}
}
