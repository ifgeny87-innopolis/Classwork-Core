package ru.innolearn.day04.threads;

/**
 * Created by marina on 08.12.2016.
 *
 * Задача:
 */
public class Test {
	public static void main(String[] args) {
		(new Test()).run();
	}

	void run() {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
	}

	//-------------------------

	class MyThread1 extends Thread {
		MyThread1() {
		}

		@Override
		public void run() {
			super.run();
		}
	}

	//-------------------------

	class MyThread2 extends Thread {
		MyThread2() {
		}

		@Override
		public void run() {
			super.run();
		}
	}
}
