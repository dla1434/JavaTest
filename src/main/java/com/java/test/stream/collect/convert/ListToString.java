package com.java.test.stream.collect.convert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListToString {
	public static void main(String[] args) {
		List<String> programing = Arrays.asList("Javascript", "C", "C++", "Nodejs", "Java", "Oracle", "MariaDB", "PHP", "ASP");
		String collectResult = programing.stream()
			.collect(Collectors.joining(" "));
		
		System.out.println("collectResult : " + collectResult);
	}
}
