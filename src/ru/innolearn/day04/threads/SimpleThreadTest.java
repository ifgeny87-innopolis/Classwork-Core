package ru.innolearn.day04.threads;

/**
 * Created by marina on 08.12.2016.
 *
 * Тестирование работы потоков.
 */
public class SimpleThreadTest {
    public static void main(String[] args) {
        Thread t = new SimpleThread();

        t.start();  // не t.run(); !!!!!

        Thread r = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread me = Thread.currentThread();

                int i = 0;
                while (!me.isInterrupted()) {
                    i++;
                    System.out.println("Runnable Thread: " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }

                    if (i > 10)
                        break;
                }

                System.out.println("Runnable stop");
            }
        });

        r.start();

        int i = 0;

        while (t.isAlive() && r.isAlive()) {
            i++;
            if (i % 10000000 == 0)
                System.out.println("App: " + i);
        }

        // try to stop
        System.out.println("APP thread status: t = " + t.isAlive() + ", r = " + r.isAlive());
        System.out.println("APP: Interrupt threads...");
        t.interrupt();
        r.interrupt();
    }

    static class SimpleThread extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (!isInterrupted()) {
                i++;
                System.out.println("Thread: " + i);
                try {
                    this.sleep(100);
                } catch (InterruptedException e) {
                }

                if (i > 10)
                    break;
            }

            System.out.println("Thread stop");
        }
    }

}
