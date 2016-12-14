package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day28 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = 6;
		String[] list = {
				"riya riya@gmail.com",
				"julia julia@julia.me",
				"julia sjulia@gmail.com",
				"julia julia@gmail.com",
				"samantha samantha@gmail.com",
				"tanya tanya@gmail.com"
		};

		List<String> names = new ArrayList<>();
		Pattern pattern = Pattern.compile("^([\\w]+) [\\w]+@gmail.com$");

		for (int i = 0; i < T; i++) {
			Matcher m =pattern.matcher(list[i]);
			if(m.find())
				names.add(m.group(1));
		}

		names.stream().sorted().forEach(s -> System.out.println(s));
	}
}
