package tests.calls;

/**
 * Created by marina on 08.12.2016.
 */
public class SomeClass2 extends Types {
	public void perform() {
		System.out.print(3);
		super.perform();
	}

	public void perform(int val) {
		System.out.print(4);
		super.perform();
	}
}
