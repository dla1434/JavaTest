package com.java.test.stream.typeConvert;

import java.util.stream.IntStream;

public class MapToObj {
	public static void main(String[] args) {
		IntStream.range(1, 4)
			.mapToObj(i -> "a" + i)
			.forEach(System.out::println);

		// a1
		// a2
		// a3
	}
}
