package ru.innolearn.tests.threads.concurent;

import java.util.HashMap;
import java.util.Map;

public class RunnerMain {
	static public Map<Integer, Integer> map = new HashMap();

	public static void main(String[] args) {
		new RunnerThread().start();
		new RunnerThread().start();
		new RunnerThread().start();
	}
}

class RunnerThread extends Thread {
	@Override
	public void run() {
		int k = 2;
		while(k <= 0xFF) {
			for(int i = 1; i <= k; ++i)
				if(RunnerMain.map.containsKey(i)) {
					int v = RunnerMain.map.get(i);
					if(v == 0)
						System.out.println(Thread.currentThread().getName() + " - i=" + i + " k=" + k);
					RunnerMain.map.put(i, ++v);
				}
				else
					RunnerMain.map.put(i, 0);

			k *= 2;
		}
	}
}