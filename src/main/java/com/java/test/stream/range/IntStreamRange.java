package com.java.test.stream.range;

import java.util.stream.IntStream;

public class IntStreamRange {
	public static void main(String[] args) {
		//0부터 4개 출력 : 0,1,2,3 출력
		IntStream.range(0, 4).forEach(System.out::println);
		System.out.println("--------------------------------------------------------------");
		// 0
		// 1
		// 2
		// 3
		
		
		//0부터 4개 출력하는데 1부터 시작 : 1,2,3 출력
		IntStream.range(1, 4).forEach(System.out::println);
		
		// 1
		// 2
		// 3
		
	}
}
