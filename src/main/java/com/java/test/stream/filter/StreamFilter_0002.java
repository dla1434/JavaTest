package com.java.test.stream.filter;

import java.util.Arrays;
import java.util.List;

public class StreamFilter_0002 {
	public static void main(String[] args) {
		List<String> programing = Arrays.asList("Javascript", "C", "C++", "Nodejs", "Java", "Oracle", "MariaDB", "PHP", "ASP");

		// filter 메서드의 인자는 Predicate<T>, T 타입를 받아서 Boolean 타입을 리턴
		programing.stream()
			.filter(str -> str.length() > 3)
			.forEach(str -> System.out.print("[" + str + "]"));
	}
}
