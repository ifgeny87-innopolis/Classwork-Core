package tests;

/**
 * Created by marina on 08.12.2016.
 */
public class CloneTest {
	public static void main(String[] args) {
		new CloneTest().x();
	}

	void x() {
		P o = new P();
		O a;
		try {
			a = o.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return;
		}
		System.out.println(o);
		System.out.println(a);
		System.out.println(o == a);
		System.out.println(o.equals(a));
		System.out.println(o.getClass());
		System.out.println(a.getClass());
		System.out.println(o.getClass() == a.getClass());
	}
}

class O implements Cloneable {

}

class P extends O {
	int x = 123;
	@Override
	public O clone() throws CloneNotSupportedException {
		return (O)super.clone();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		P r = (P) o;

		return x == r.x;
	}

	@Override
	public int hashCode() {
		return x;
	}
}