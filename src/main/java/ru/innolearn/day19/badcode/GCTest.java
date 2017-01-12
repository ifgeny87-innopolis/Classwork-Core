package ru.innolearn.day19.badcode;

import java.util.*;

/**
 * Создаем плохой код для проверки в профайлерах
 * Команда вводится в консоли:
 * C) создает большой объект, объект не запоминается и будет очищен
 * L) создает большой объект и ложит в массив, хранит на него ссылку, не будет очищен
 * T) запускает много "спящих" потоков
 * I) выводит информацию о хипе (heap info)
 *
 * Created in project untitled in 09.01.17
 */
public class GCTest
{
	static List<Object> cache = new LinkedList<>();

	public static void main(String[] args) throws InterruptedException
	{
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("Type C/L/T/I:");
			String cmd = scan.next().toLowerCase();
//			String cmd = "c";

			long startTime = System.nanoTime();

			switch (cmd) {
				case "c":
					createBigObject();
					break;

				case "l":
					cache.add(createBigObject());
					break;

				case "t":
					threadsCreate();
					break;

				case "i":
					printHeapInfo();
					break;

				default:
					System.out.println("Bye-bye...");
					return;
			}

			System.out.printf("Done in %,3f ms\n", (System.nanoTime() - startTime) / 1_000_000.);
		}
	}

	/**
	 * Создает большой объект
	 * @return
	 */
	static Object createBigObject()
	{
		List<String> list = new ArrayList<>();

		int count = 5_000_000;

		for (int i = 0; i < count; i++) {
			list.add("" + i);
		}

		return list;
	}

	/**
	 * Запускает большое количество потоков
	 */
	static void threadsCreate()
	{
		for (int i = 0; i < 100_000; i++) {
			final int j = i;
			Thread t = new Thread(() -> {
				int w = new Random().nextInt(10_000) + 1_000;
				System.out.println(j + " | wait for " + w);
				try {
					Thread.sleep(w);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(j + " | end");
			});
			t.start();
		}
	}

	/**
	 * Выводит информацию о хипе
	 */
	static void printHeapInfo()
	{
		// Get current size of heap in bytes
		long heapSize = Runtime.getRuntime().totalMemory();

// Get maximum size of heap in bytes. The heap cannot grow beyond this size.// Any attempt will result in an OutOfMemoryException.
		long heapMaxSize = Runtime.getRuntime().maxMemory();

		// Get amount of free memory within the heap in bytes. This size will increase // after garbage collection and decrease as new objects are created.
		long heapFreeSize = Runtime.getRuntime().freeMemory();

		System.out.printf("Heap now: %f MB %f%%\nHeap max: %f MB\nHeap free: %f MB %f%%\n",
				heapSize / 1_000_000.,
				100. / heapMaxSize * heapSize,
				heapMaxSize / 1_000_000.,
				heapFreeSize / 1_000_000.,
				100. / heapMaxSize * heapFreeSize);
	}
}
