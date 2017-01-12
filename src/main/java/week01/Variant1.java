package week01;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Вариант 1:
 * Реализовать программу из 2-х потоков. Один из потоков каждую секунду генерирует случайное число в интервале [0;99]. Второй поток раз в пять секунд выводит количество уникальных чисел, сгенерированных первым потоком. После того, как будет сгенерировано все 100 чисел, оба потока должны остановить свое выполнение.
 */
public class Variant1 {
	public static void main(String[] args) throws InterruptedException {
		T1 t1 = new T1();
		T2 t2 = new T2();

		t1.start();
		t2.start();

		while(t1.isAlive())
			synchronized (t1) {
				t1.wait(10);
			}

		t2.interrupt();
	}
}

/**
 * Настройки приложения
 * Для поставленной задачи работает слишком быстро, вывод не появляется
 */
class Config {
	// количество уникальных значений
	final static int uniqueNumbersCount = 100;

	// периодичность вывода во втором потоке
	final static int thread2Sleep = 5000;
}

/**
 * Класс-хранилище
 */
class Counter {
	public static Set<Integer> numbers = new HashSet<>();
}

/**
 * Класс первого потока
 * Выполняет генерацию и запоминает числа
 */
class T1 extends Thread {
	Random random = new Random();

	@Override
	public void run() {
		while(!isInterrupted()) {
			int n = random.nextInt(Config.uniqueNumbersCount);
			Counter.numbers.add(n);
			if(Counter.numbers.size() == Config.uniqueNumbersCount)
				break;
		}
	}
}

/**
 * Класс второго потока
 * Просто выводит текущее состояние работы
 */
class T2 extends Thread {
	@Override
	public void run() {
		while(!isInterrupted()) {
			try {
				Thread.sleep(Config.thread2Sleep);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			System.out.println(Counter.numbers.size());
		}
	}
}