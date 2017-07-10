package quizful;

/**
 * Created in project Inno-Classroom-Work on 18.01.17
 */
class Class1 {
	Class1(int i) {
		System.out.println("Class1(int)");
	}
}

public class Test01 extends Class1 {
	Test01(int d) {              // 1
		super(d);
		System.out.println("Class2(double)");
	}

	public static void main(String[] args) {
		new Test01(0);
	}
}