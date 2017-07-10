package tests;

/**
 * Created in project Inno-Classroom-Work on 16.03.17
 */
public class TestPreDefine
{
	public static void main(String[] args)
	{
		int O = 4000;
		int B = 0;
		int R = O >>>= ((++B) - O--);
		System.out.println(Integer.toBinaryString(O));
		System.out.println(Integer.toBinaryString(B));
		System.out.println(Integer.toBinaryString(R));
		System.out.printf("%d\t%d\t%d\n", O, B, R);
	}
}
