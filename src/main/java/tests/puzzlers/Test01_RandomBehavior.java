package tests.puzzlers;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by marina on 09.12.2016.
 * <p>
 * What does it print?
 * (T006) A number close to 1
 * (b) A number close to 50
 * (c) A number close to 100
 * (d) None of the above
 */
public class Test01_RandomBehavior {
	public static void main(String[] args) {
		Set s = new HashSet<>();
		for (int i = 0; i < 100; i++)
			s.add(randomInteger());
		System.out.println(s.size());
	}

	private static Integer randomInteger() {
		return new Integer(new Random().nextInt());
	}
}