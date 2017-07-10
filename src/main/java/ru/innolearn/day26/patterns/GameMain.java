package ru.innolearn.day26.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created in project Inno-Classroom-Work on 18.01.17
 */
public class GameMain
{
	public static void main(String[] args)
	{
		List<String> list = Stream.of("hi_123", "3423", "bell")
				.map(s -> s.replaceAll("_.*", "a"))
				.collect(Collectors.toList());

		System.out.println(String.join(",", list));

	}
}
