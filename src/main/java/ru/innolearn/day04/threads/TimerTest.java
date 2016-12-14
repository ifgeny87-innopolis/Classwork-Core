package ru.innolearn.day04.threads;

import java.util.Scanner;

/**
 * Created by marina on 08.12.2016.
 * <p>
 * Задача 1: Напишите программу, которая каждую секунду отображает на экране данные о времени, прошедшем от начала сессии, а другой ее поток выводит сообщение каждые 5 секунд. Предусмотрите возможность ежесекундного оповещения потока, воспроизводящего сообщение, потоком, отсчитывающим время.
 * <p>
 * Задача 2: Не внося изменений в код потока-"хронометра" , добавьте еще один поток, который выводит на экран другое сообщение каждые 7 секунд. Предполагается использование методов wait(), notifyAll().
 */
public class TimerTest {

	static Object monitor = new Object();
	static int counter;

	public static void main(String[] args) {
		(new TimerTest()).run();
		Scanner scan = new Scanner(System.in);
	}

	void run() {
		Thread t1 = new MyTimer1();
		Thread t2 = new MyTimer2(5);
		Thread t3 = new MyTimer2(7);

		t1.start();
		t2.start();
		t3.start();
	}

	/**
	 * Класс MyTimer1
	 * Поток каждую секунду увеличивает счетчик секунд с момента запуска.
	 */
	class MyTimer1 extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				counter++;
				System.out.println("Counter: " + counter);

				synchronized (monitor) {
					monitor.notify();
				}
			}
		}
	}

	/**
	 * Класс MyTimer2
	 * Ожидает значение счетчика, кратное 5 и выводит свою фразу.
	 */
	class MyTimer2 extends Thread {
		private int key;
		private int lastCounter;

		MyTimer2(int key) {
			this.key = key;
		}

		@Override
		public void run() {
			while (!isInterrupted()) {
				synchronized (monitor) {
					try {
						monitor.wait();
						monitor.notifyAll();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (counter % key == 0 && counter != lastCounter) {
					System.out.println("Tic-Tak           " + key);
					lastCounter = counter;
				}
			}
		}
	}

}
