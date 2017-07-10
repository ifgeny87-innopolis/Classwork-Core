import org.junit.Test;

import java.util.stream.Stream;

/**
 * Created in project Inno-Classroom-Work on 18.01.17
 */
public class RegexTest
{
	@Test
	public void PasswordTest()
	{
		String PASSWORD_PATTERN =
				"(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20}";

		Stream.of("builder",
				"123",
				"Black123!@#$%^&*()_",
				"Black123",
				"BLACK123@",
				"Ab12@",
				"12Abca34sdqwe@%$")
				.forEach(s -> System.out.printf("%20s match %10b\n",
						s, s.matches(PASSWORD_PATTERN)));
	}

	@Test
	public void EmailTest()
	{
		String EMAIL_PATTERN =
				"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

		Stream.of("a@b.c",
				"123@1.2",
				"12Abca34sdqwe@a.$")
				.forEach(s -> System.out.printf("%20s match %10b\n",
						s, s.matches(EMAIL_PATTERN)));
	}
}
