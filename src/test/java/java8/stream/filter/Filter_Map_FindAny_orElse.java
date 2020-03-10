package java8.stream.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import common.consts.CommonConst;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Filter_Map_FindAny_orElse {
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
	public void test1_Classic() {
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
	public void test2_FilterMapFound(){
		log.info(CommonConst.title, "testFilterFound");
		String name = persons.stream()
				.filter(x -> "jack".equals(x.getName()))
				.map(Person::getName)						//convert stream to String
				.findAny()
				.orElse("");

		System.out.println("name : " + name);
		log.info(CommonConst.line);
	}
	
	@Test
	public void test3_FilterMapFound(){
		log.info(CommonConst.title, "testFilterFound");
		List<String> collect = persons.stream()
			.map(Person::getName)
			.collect(Collectors.toList());

		collect.forEach(System.out::println);
		log.info(CommonConst.line);
	}
}
