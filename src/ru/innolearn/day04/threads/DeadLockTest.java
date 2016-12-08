package ru.innolearn.day04.threads;

/**
 * Created by marina on 08.12.2016.
 */
public class DeadLockTest {
    public static void main(String[] args) {
        Object m1 = new Object();
        Object m2 = new Object();

        Thread t1 = new MyThread(m1, m2);
        Thread t2 = new MyThread(m2, m1);

        t1.start();
        t2.start();
    }

    static class MyThread extends Thread {
        private Object m1, m2;

        MyThread(Object m1, Object m2) {
            this.m1 = m1;
            this.m2 = m2;
        }

        @Override
        public void run() {
            synchronized (m1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Goto dead lock");
                synchronized (m2) {
                    System.out.println("Im here");
                }
            }
        }
    }
}
