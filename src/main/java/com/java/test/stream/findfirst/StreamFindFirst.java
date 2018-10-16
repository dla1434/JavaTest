package com.java.test.stream.findfirst;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.SynchronousQueue;

public class StreamFindFirst {
	public static void main(String[] args) {
		Arrays.asList("a1", "a2", "a3").stream()
			.findFirst()
			.ifPresent(System.out::println);
	}
}
