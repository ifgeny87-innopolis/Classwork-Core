package tests;

/**
 * Created in project Inno-Classroom-Work in 08.01.17
 *
 * Тест показывает работу инверсии битов в числах (символ тильда перед числом)
 */
public class CastTest
{
	public static void main(String[] args)
	{
		String mask = "%8d | %8x | %32s | %8d | %8x | %32s\n";

		String headMask = mask.replaceAll("[dx]+", "s");
		String head = String.format(headMask, "DEC", "HEX", "BIN", "~DEC", "~HEX", "~BIN");

		System.out.println("Integer test:");
		System.out.println(head);

		for (int i : new int[]{-1, 0, 1, 255, 1024, -1024, 65535, -65535}) {
			System.out.printf(mask,
					i, i, Integer.toBinaryString(i),
					~i, ~i, Integer.toBinaryString(~i));
		}

		System.out.println("\nShort test:");
		System.out.println(head);

		for (short i : new short[]{-1, 0, 1, 1000, -1001, 32767, -32767}) {
			System.out.printf(mask,
					i, i, Integer.toBinaryString(i & 0xFFFF),
					~i, ~i, Integer.toBinaryString(~i & 0xFFFF));
		}

		System.out.println("\nByte test:");
		System.out.println(head);

		for (byte i : new byte[]{-1, 0, 1, 127, -128}) {
			System.out.printf(mask,
					i, i, Integer.toBinaryString(i & 0xFF),
					~i, ~i, Integer.toBinaryString(~i & 0xFF));
		}
	}
}
