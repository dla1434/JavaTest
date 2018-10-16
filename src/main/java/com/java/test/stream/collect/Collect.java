package com.java.test.stream.collect;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collect {
	public static void main(String[] args) {
		//Stream 획득
		Stream<Integer> stream = Arrays.asList(1, 2, 3).stream();
		
		//Stream + iterator
		Iterator<Integer> iterator = Arrays.asList(1, 2, 3).stream().iterator();
		while( iterator.hasNext() ){
			System.out.println(iterator.next());
		}
		
		//Stream + collect(Collectors.toList())
		//Collectors.toList()를 Stream --> List로 반환이 가능하다.
		List<Integer> collect = Arrays.asList(1, 2, 3).stream()
			.collect(Collectors.toList());
		collect.forEach(System.out::println);
		
		
	}
}
