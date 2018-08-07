package com.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamMap {
	@Test
	public void beforeJava8() {
		List<String> alpha = Arrays.asList("a", "b", "c", "d");
		
		//Before Java8 
		//For로 하나씩 가지고 와서 처리
		List<String> alphaUpper = new ArrayList<>();
		for (String s : alpha) {
			alphaUpper.add(s.toUpperCase());
		}
		
		log.info("before : {}", alpha); //[a, b, c, d]
		log.info("after : {}", alphaUpper); //[A, B, C, D]
	}
	
	@Test
	public void afterJava8(){
		List<String> alpha = Arrays.asList("a", "b", "c", "d");
		
		// Java 8
		//map은 return type이 stream이다.
		//map 처리 결과를 list로 받기 위해서는 collect(Collectors.toList()) 수행해야 한다.
		List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
		log.info("java8 np : {}", collect); // [A, B, C, D]

		// Extra, streams apply to any data type.
		List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
		log.info("java8 np : {}", collect1); // [2, 4, 6, 8, 10]
	}
}
