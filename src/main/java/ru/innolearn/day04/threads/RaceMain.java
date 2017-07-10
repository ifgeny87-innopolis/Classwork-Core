package ru.innolearn.day04.threads;

import java.util.Random;

/**
 * Created in project Inno-Classroom-Work on 17.01.17
 */
public class RaceMain
{
	static volatile boolean isInit;
	static volatile int i;

	static int i5, i6, i7;

	static class T1 extends Thread {
		@Override
		public void run()
		{
			try {
				Thread.sleep(new Random().nextInt(10));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			i = 5;

			isInit = true;

			i = 6;
		}
	}

	static class T2 extends Thread {
		@Override
		public void run()
		{
			try {
				Thread.sleep(new Random().nextInt(10));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			i = 7;

			if(isInit)
				System.out.println(i);
			else
				System.out.println("-----");
		}
	}

	public static void main(String[] args) throws InterruptedException
	{
		while(true) {
			T1 t1 = new T1();
			T2 t2 = new T2();

			t1.start();
			t2.start();

			t1.join();
			t2.join();

//			Thread.sleep();
			System.out.printf("%5d %5d %5d\n", i5, i6, i7);
		}
	}
}
