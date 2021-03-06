package ru.innolearn.day04.threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marina on 08.12.2016.
 * <p>
 * Пример синхронизации потоков.
 * Создается 10 потоков, выполняющих инкремент.
 */
public class CalcTest {

    static int workThreads = 100;
    static int count;
    static volatile int volCount;

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();

        List<Thread> guys = new ArrayList<>();
        final Summator summator = new Summator();

        for (int i = 0; i < workThreads; i++)
            guys.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1_000_000; j++) {
//                        synchronized (summator) {
                            count++;
                            summator.count++;
                            volCount++;
//                        }
                    }

                    synchronized (summator) {
                        workThreads--;
                        summator.notify();
                    }
                }
            }));

        for (Thread guy : guys) {
            guy.start();
        }

        synchronized (summator) {
            while (workThreads > 0) {
                System.out.println("APP: Wait for " + workThreads + " threads...");
                summator.wait(100);
            }
        }

        System.out.printf("Count: %,d\n", count);
        System.out.printf("Summator.count: %,d\n", summator.count);
        System.out.printf("volCount: %,d\n", volCount);

        long finish = System.nanoTime();
        long totalLenth = finish - start;
        System.out.printf("Work time: %,.3f ms\n", totalLenth / 1_000_000.);
    }

    static class Summator {
        private int count;
    }
}
