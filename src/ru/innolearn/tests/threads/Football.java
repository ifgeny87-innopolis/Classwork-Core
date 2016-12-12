package ru.innolearn.tests.threads;

/**
 * Created by marina on 08.12.2016.
 * <p>
 * Разбираемся с потомками.
 * Какому потоку ОС отдаст большее предпочтение?
 * <p>
 * Программа имитирует забивание голов.
 */
public class Football {

	static Object monitor = new Object();
	static long score = 0, count = 0;

	public static void main(String[] args) {
		synchronized (monitor) {
			new Spartak().start();
			new Zenit().start();
		}
	}

	static class Spartak extends Thread {
		@Override
		public void run() {
			while (!isInterrupted())
				synchronized (monitor) {
					score++;
					count++;
					System.out.printf("%,15d %,15d\n", count, score);
				}
		}
	}

	static class Zenit extends Thread {
		@Override
		public void run() {
			while (!isInterrupted())
				synchronized (monitor) {
					score--;
					count++;
					System.out.printf("%,15d %,15d\n", count, score);
				}
		}
	}
}
