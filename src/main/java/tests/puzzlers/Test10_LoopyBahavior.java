package tests.puzzlers;

/**
 * Created by marina on 09.12.2016.
 */
class Test10_LoopyBahavior {
	public static void main(String[] args) {
		final int start = Integer.MAX_VALUE - 10;
		final int end = Integer.MAX_VALUE;

		System.out.printf("%d %d\n", start, end);

		int count = 0;
		for (int i = start; i <= end && count < 20; i++) {
			count++;
			System.out.println(i + ": " + count);
		}
	}
}