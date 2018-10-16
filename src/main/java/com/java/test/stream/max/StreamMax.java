package com.java.test.stream.max;

import java.util.stream.Stream;

public class StreamMax {
	public static void main(String[] args) {
		Stream.of("a1", "a2", "a3")
		.map(s -> s.substring(1))
		.mapToInt(Integer::parseInt)
		.max()
		.ifPresent(s -> System.out.println(s));
		
		
		Stream.of("a1", "a2", "a3")
			.map(s -> s.substring(1))
			.mapToInt(Integer::parseInt)
			.max()
			.ifPresent(System.out::println);
		
		// 3
	}
}
