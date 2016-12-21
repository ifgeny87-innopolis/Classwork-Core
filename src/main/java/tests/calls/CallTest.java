package tests.calls;

/**
 * Created by marina on 08.12.2016.
 */
public class CallTest {
	public static void main(String[] args) {
		Types c = new SomeClass2();
		c.perform(4444);
	}

	/*static class Types {
		public void perform() {
			System.out.print(1);
			Types.this.perform(2222);
		}

		public void perform(int val) {
			System.out.print(2);
		}
	}

	static class SomeClass2 extends Types {
		public void perform() {
			System.out.print(3);
			super.perform();
		}

		public void perform(int val) {
			System.out.print(4);
			super.perform();
		}
	}*/
}

