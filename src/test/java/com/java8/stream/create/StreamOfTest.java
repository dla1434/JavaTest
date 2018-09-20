package com.java8.stream.create;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamOfTest {
	@Test
	public void testStreamOf() {
		Stream<String> stream = Stream.of("Using", "Stream", "API", "From", "Java8");
	}
	
	@Test
	public void testStreamOfSplit() {
		String contents = "Javascript C C++ Nodejs Java Oracle MariaDB PHP ASP";
		Stream<String> stream = Stream.of(contents.split("[\\P{L}]+"));
	}
}
