package tests.math;

/**
 * https://www.youtube.com/watch?time_continue=577&v=V94Fae8dbgE
 *
 * 1) Бинарный поиск
 *
 * 2) Поиск квадратного корня через брутфорс
 *
 * 3) Поиск квадратного корня через бинарный поиск
 */
public class FindInArray
{
	public static void main(String[] args)
	{
		// бинарный поиск выполняется только для отсортированного массива
		int[] array = new int[10_000_000];
		for(int i = 0; i < array.length;i++)
			array[i] = i * 2;

		// выполняем бинарный поиск в массиве первых 1000 четных чисел
		FindInArray.findInArray(array, 256000);
		FindInArray.findInArray(array, 127);

		// поиск квадратного корня числа брут форсом
		FindInArray.bruteForceSquareRoot(123.456789, .001);

		// поиск того же числа бинарным поиском
		FindInArray.binarySquareRoot(123.456789, .001);
	}

	static void findInArray(int[] array, int what) {
		int left = 0;
		int right = array.length;
		int middle;
		int times=0;

		while(left < right - 1) {
			++times;
			middle = (left + right) / 2;

			if(array[middle] == what) {
				System.out.printf("Found %d at index %d in %d times\n", what, middle, times);
				return;
			}
			// else
			if(array[middle] > what) {
				right = middle;
			}
			else {
				left = middle;
			}
		}

		System.out.printf("Value %d not found in array in %d times\n", what, times);
	}

	static void bruteForceSquareRoot(double a, double epicilon) {
		int times = 0;
		double ans = .0;
		double ans2 = ans*ans;

		while(Math.abs(ans2 - a) >= epicilon) {
			++times;
			ans += .000001;
			ans2 = ans*ans;
		}

		if(Math.abs(ans2 - a) >= epicilon) {
			System.out.printf("Cannot found square root for %f in %d times\n", a, times);
		}
		else {
			System.out.printf("Found square root %f for %f in %d times\n", ans, a, times);
		}

	}

	static void binarySquareRoot(double a, double epicilon) {
		int times = 0;
		double low = .0;
		double high = a;
		double ans = (low + high) / 2.0;
		double ans2 = ans*ans;

		while(Math.abs(ans2 - a) >= epicilon) {
			++times;
			if(ans2 < a) {
				low = ans;
			}
			else {
				high = ans;
			}
			ans = (low + high) / 2.0;
			ans2 = ans * ans;
		}

		if(Math.abs(ans2 - a) >= epicilon) {
			System.out.printf("Cannot found square root for %f in %d times\n", a, times);
		}
		else {
			System.out.printf("Found square root %f for %f in %d times\n", ans, a, times);
		}

	}
}
