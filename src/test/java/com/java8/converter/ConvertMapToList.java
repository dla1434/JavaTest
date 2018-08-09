package com.java8.converter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.java.test.consts.CommonConst;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConvertMapToList {
	Map<Integer, String> map;

	@Before
	public void init(){
		map = new HashMap<>();
		map.put(10, "apple");
		map.put(20, "orange");
		map.put(30, "banana");
		map.put(40, "watermelon");
		map.put(50, "dragonfruit");
	}
	
	@Test
	public void test1_Classic() {
		log.info(CommonConst.title, "test1_Classic");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test2_ConvertMapkeyToList(){
		log.info(CommonConst.title, "test2_ConvertMapkeyToList");
		List<Integer> result = new ArrayList(map.keySet());
		result.forEach(System.out::println);
		log.info(CommonConst.line);
	}
	
	@Test
	public void test3_ConvertMapValueToList(){
		log.info(CommonConst.title, "test3_ConvertMapValueToList");
		List<String> result2 = new ArrayList(map.values());
		result2.forEach(System.out::println);
		log.info(CommonConst.line);
	}
	
	@Test
	public void test4_ConvertMapkey_StreamCollect_ToList(){
		log.info(CommonConst.title, "test4_ConvertMapkey_StreamCollect_ToList");
		List<Integer> result = map.keySet().stream()
				.collect(Collectors.toList());
		result.forEach(System.out::println);
		log.info(CommonConst.line);
	}
	
	@Test
	public void test5_ConvertMapValue_StreamCollect_ToList(){
		log.info(CommonConst.title, "test5_");
		//map -> stream > collect -> list
		List<String> result2 = map.values().stream()
				.collect(Collectors.toList());
		result2.forEach(System.out::println);
		
		//map -> stream > filter > collect -> list
		List<String> result3 = map.values().stream()
				.filter(x -> !"banana".equalsIgnoreCase(x))
				.collect(Collectors.toList());
		result3.forEach(System.out::println);
		log.info(CommonConst.line);
	}
	
	/**
	 * resultSortedKey : map key값을 역순으로 정렬할 값을 list로 저장
	 * resultValues : map value 값에서 banana를 제외하여 list로  저장
	 */
	@Test
	public void test6_ConvertMapToSplitedList(){
		log.info(CommonConst.title, "test6_ConvertMapToSplitedList");
		List<Integer> resultSortedKey = new ArrayList<>();
		
		// split a map into 2 List
		List<String> resultValues = map.entrySet().stream()
			.sorted(Map.Entry.<Integer, String>comparingByKey().reversed())		//sort a Map by key and stored in resultSortedKey
			.peek(e -> resultSortedKey.add(e.getKey()))
			.map(x -> x.getValue())
			.filter(x -> !"banana".equalsIgnoreCase(x))							// filter banana and return it to resultValues
			.collect(Collectors.toList());

		resultSortedKey.forEach(System.out::println);
		resultValues.forEach(System.out::println);
		
		log.info(CommonConst.line);
	}
	
	@Test
	public void test7_(){
		log.info(CommonConst.title, "test7_");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test8_(){
		log.info(CommonConst.title, "test8_");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test9_(){
		log.info(CommonConst.title, "test9_");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test10_(){
		log.info(CommonConst.title, "test10_");
		log.info(CommonConst.line);
	}
}
