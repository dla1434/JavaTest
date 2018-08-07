package com.java8.filter;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.java.test.consts.CommonConst;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Filter_FindAny_orElse {
	List<Person> persons = null;

	@Before
	public void init() {
		persons = Arrays.asList(
			new Person("mkyong", 30),
			new Person("jack", 20),
			new Person("lawrence", 40),
			new Person("jack", 50)
		);
	}

	@Test
	public void test1Classic() {
		log.info(CommonConst.title, "testClassic");
		Person result = null;
		for (Person temp : persons) {
			if ("jack".equals(temp.getName())) {
				result = temp;
				break;
			}
		}
		
		System.out.println(result);
		log.info(CommonConst.line);
	}
	
	@Test
	public void test2FilterFound(){
		log.info(CommonConst.title, "testFilterFound");
		Person result1 = persons.stream() 					// Convert to steam
			.filter(x -> "jack".equals(x.getName())) 		// we want "jack" only
			.findAny() 										// If 'findAny' then return found
			.orElse(null); 									// If not found, return null

		System.out.println(result1);
		log.info(CommonConst.line);
	}
	
	@Test
	public void test3FilterNotFound(){
		log.info(CommonConst.title, "testFilterNotFound");
		Person result2 = persons.stream()
			.filter(x -> "ahmook".equals(x.getName()))
			.findAny()
			.orElse(null);
		System.out.println(result2);
		log.info(CommonConst.line);
	}
	
	@Test
	public void testFilter3(){
		
	}

}
