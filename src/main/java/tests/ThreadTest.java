package tests;

/**
 * Created by marina on 08.12.2016.
 */
public class ThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            (new MyThread(i)).start();

        System.out.println("Waiting...");
    }

    static class MyThread extends Thread {
        private int index;

        public MyThread(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            long sum = 0;

            for (long i = 0; i < 1 << 30; i++)
                sum += i;

            System.out.println("Thread " + index + ": " + sum);
        }
    }
}
