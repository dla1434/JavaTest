package com.java8.map.sort;


import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
public class MapSort {
	Map<String, Integer> unsortMap;
	
	@Before
	public void init(){
		unsortMap = new HashMap<>();
		unsortMap.put("z", 10);
		unsortMap.put("b", 5);
		unsortMap.put("a", 6);
		unsortMap.put("c", 20);
		unsortMap.put("d", 1);
		unsortMap.put("e", 7);
		unsortMap.put("y", 8);
		unsortMap.put("n", 99);
		unsortMap.put("g", 50);
		unsortMap.put("m", 2);
		unsortMap.put("f", 9);
	}
	
	@Test
	public void test1_Classic() {
		log.info(CommonConst.title, "test1_Classic");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test2_SortByKey(){
		log.info(CommonConst.title, "test2_SortByKey");
		// sort by keys, a,b,c..., and return a new LinkedHashMap
		// toMap() will returns HashMap by default, we need LinkedHashMap to keep the order.
		Map<String, Integer> result = unsortMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println(result);
		log.info(CommonConst.line);
	}
	
	/**
	 * Not Recommend, but it works.
	 */
	@Test
	public void test3_SortByKey(){
		log.info(CommonConst.title, "test3_SortByKey");
		//Alternative way to sort a Map by keys, and put it into the "result" map
		Map<String, Integer> result2 = new LinkedHashMap<>();
		unsortMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

		System.out.println("Sorted...");
		System.out.println(result2);
		log.info(CommonConst.line);
	}
	
	@Test
	public void test4_SortReverseByValue(){
		log.info(CommonConst.title, "test4_SortReverseByValue");
		 //sort by values, and reserve it, 10,9,8,7,6...
		Map<String, Integer> result = unsortMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println(result);
		log.info(CommonConst.line);
	}
	
	@Test
	public void test5_SortByValue(){
		log.info(CommonConst.title, "test5_SortByValue");
		//Alternative way
		Map<String, Integer> result2 = new LinkedHashMap<>();
		unsortMap.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

		System.out.println("Sorted...");
		System.out.println(result2);
		log.info(CommonConst.line);
	}
	
	@Test
	public void test6_(){
		log.info(CommonConst.title, "test6_");
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
