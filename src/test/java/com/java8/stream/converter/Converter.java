package com.java8.stream.converter;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.java.test.consts.CommonConst;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Converter {
	Stream<String> language = null;
	Stream<Integer> number = null;
	
	@Before
	public void init(){
		language = Stream.of("java", "python", "node");
		number = Stream.of(1, 2, 3, 4, 5);
	}
	
	@Test
	public void test1_Classic() {
		log.info(CommonConst.title, "testClassic");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test2_ConverterStreamToList(){
		log.info(CommonConst.title, "test2_ConverterStreamToList");
		//Convert a Stream to List
		List<String> result = language.collect(Collectors.toList());
		result.forEach(System.out::println);
		log.info(CommonConst.line);
	}
	
	@Test
	public void test3_ConverterStreamFilterToList(){
		log.info(CommonConst.title, "test3_ConverterStreamFilterToList");
		List<Integer> result2 = number
				.filter(x -> x != 3).collect(Collectors.toList());
		result2.forEach(x -> System.out.println(x));
		log.info(CommonConst.line);
	}
	
	@Test
	public void test4_(){
		log.info(CommonConst.title, "test3");
		log.info(CommonConst.line);
	}
}
