package sberteh.matorin;

/**
 * Когда выведет false?
 *
 * 1) не скомпилируется потому что нельзя привести разные типы
 * 2,3) false - потому что equals и hashcode у StringBuilder не переопределен
 *
 * Created in project Inno-Classroom-Work in 11.01.17
 */
public class t01
{
	public static void main(String[] args)
	{
		String s = "abc";
		StringBuilder sb1 = new StringBuilder("abc");
		StringBuilder sb2 = new StringBuilder("abc");



		// первая строка не скомпилируется
//		System.out.println(s == sb1); // 1
		System.out.println(s.equals(sb1)); // 2
		System.out.println(sb1.equals(sb2)); // 3
	}
}
