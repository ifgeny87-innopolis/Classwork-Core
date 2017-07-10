package tests.threads;

/**
 * Created by marina on 11.12.2016.
 */
public class VolatileTest {
	static long nanoStart = System.nanoTime();

	public static void main(String[] args) throws InterruptedException {
		T1 p = new T1();
		T2 q = new T2(1);
		T2 s = new T2(2);
		T2 t = new T2(3);

		p.start();
		q.start();
		s.start();
		t.start();

		while (p.isAlive()) ;

		q.interrupt();
		s.interrupt();
		t.interrupt();

		System.out.printf("%f ms\n", (System.nanoTime() - nanoStart) / 1000000.);
	}
}

class RR {
	static /*volatile*/ int a;
	static /*volatile*/ boolean flag;
}

class T1 extends Thread {
	@Override
	public void run() {
		while (!isInterrupted() && RR.a < Integer.MAX_VALUE - 1) {
			RR.a++; // нечетное
			RR.flag = false;
			RR.a++; // четное
			RR.flag = true;
		}
	}
}

class T2 extends Thread {
	int index;

	T2(int index) {
		this.index = index;
	}

	@Override
	public void run() {
		while (!isInterrupted())
			// условие номер один, CloneTest.T006 - должно быть четным!
			if (RR.flag) {
				int a = RR.a;
				if (a % 2 == 0)
					continue;

				// T006 <= CloneTest.T006 - закон
				System.out.printf("%d   %,d   %,d   %b\n", index, a, RR.a, RR.flag);
			}
	}
}
