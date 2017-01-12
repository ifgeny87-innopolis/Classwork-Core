package week01;

import java.util.*;

/**
 * Вариант 2:
 Реализовать программу из 2-х потоков. Один из потоков каждую секунду генерирует случайное число в интервале [0;99]. Второй поток раз в пять секунд выводит количество раз, которое каждое из чисел было сгенерированно. После того, как какое-либо из чисел будет сгенерированно не менее, чем 5 раз, оба потока должны остановить свое выполнение.
 */
public class Variant2 {
	public static void main(String[] args) throws InterruptedException {
		WT1 wt1 = new WT1();
		WT2 wt2 = new WT2();

		wt1.start();
		wt2.start();

		while(wt1.isAlive())
			synchronized (wt1) {
				wt1.wait(10);
			}

		wt2.interrupt();
	}
}

/**
 * Настройки приложения
 * Для поставленной задачи работает слишком быстро, вывод не появляется
 */
class Config2 {
	// количество уникальных значений
	final static int uniqueNumbersCount = 100;

	// ограничение на количество чисел
	final static int numbersCountMax = 5;

	// периодичность вывода во втором потоке
	final static int thread2Sleep = 5000;
}

/**
 * Класс-хранилище
 */
class Summer {
	public static Map<Integer,Integer> numbers = new HashMap<>();
}

/**
 * Класс первого потока
 * Выполняет генерацию и запоминает числа
 */
class WT1 extends Thread {
	Random random = new Random();

	@Override
	public void run() {
		while(!isInterrupted()) {
			int n = random.nextInt(Config2.uniqueNumbersCount);
			int count = Summer.numbers.getOrDefault(n, 0);
			Summer.numbers.put(n, ++count);
			if(count >= Config2.numbersCountMax)
				break;
		}
	}
}

/**
 * Класс второго потока
 * Просто выводит текущее состояние работы
 */
class WT2 extends Thread {
	@Override
	public void run() {
		while(!isInterrupted()) {
			try {
				Thread.sleep(Config2.thread2Sleep);
				Summer.numbers.forEach((n, count) -> {
					System.out.printf("%d\t%,d\n", n, count);
				});
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
