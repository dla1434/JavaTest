package java8.stream.flatmap;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import common.consts.CommonConst;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FlatMap {
	String[][] data = null;
	
	Student obj1;
	Student obj2;
	
	@Before
	public void init(){
		data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
		
		obj1 = new Student();
		obj1.setName("mkyong");
		obj1.addBook("Java 8 in Action");
		obj1.addBook("Spring Boot in Action");
		obj1.addBook("Effective Java (2nd Edition)");

		obj2 = new Student();
		obj2.setName("zilap");
		obj2.addBook("Learning Python, 5th Edition");
		obj2.addBook("Effective Java (2nd Edition)");
	}
	
	@Test
	public void test1_Classic() {
		log.info(CommonConst.title, "testClassic");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test2_filterEmpty(){
		log.info(CommonConst.title, "test2_filterEmpty");
		// Stream<String[]>
		Stream<String[]> temp = Arrays.stream(data);

		// filter a stream of string[], and return a string[]?
		//배열 안에 배열 형태이기 때문에 filter를 사용하더라도 값 배열의 값이 아닌 배열로 조건 판단이 되서 empty 결과가 된다. 
		Stream<String[]> stream = temp.filter(x -> "a".equals(x.toString()));
		
		//OUTPUT : empty
		stream.forEach(System.out::println);
		log.info(CommonConst.line);
	}
	
	@Test
	public void test3_FlatMapFilter(){
		log.info(CommonConst.title, "test2");
		//Stream<String[]>
		Stream<String[]> temp = Arrays.stream(data);

		// Stream<String>, GOOD!
		// FlatMap을 사용하게 되면 배열에 있는 값들을 다 꺼내서 하나의 배열로만 구성하여 반환해주기 때문에
		// 배열[]을 비교하는 게 아닌 배열값을 비교하는 것이 가능해진다.
		
		//Type_A
		Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));
		Stream<String> stream = stringStream.filter(x -> "a".equals(x.toString()));
		
		//Type_B : Type_A 방법을 한번에 처리할 수도 있다.
		/* 
		Stream<String> stream = Arrays.stream(data)
				.flatMap(x -> Arrays.stream(x))
				.filter(x -> "a".equals(x.toString()));
		*/

		stream.forEach(System.out::println);
		log.info(CommonConst.line);
	}
	
	@Test
	public void test4_SetFlatMap(){
		log.info(CommonConst.title, "test4_SetFlatMap");
		List<Student> list = new ArrayList<>();
		list.add(obj1);
		list.add(obj2);
		
		List<String> collect = list.stream()
			.map(x -> x.getBook())				//Stream<Set<String>>
			.flatMap(x -> x.stream())			//Stream<String>
			.distinct()
			.collect(Collectors.toList());

		collect.forEach(x -> System.out.println(x));
		
		log.info(CommonConst.line);
	}
	
	@Test
	public void test5_PrimitiveFlatmapToInt(){
		log.info(CommonConst.title, "test5_PrimitiveFlatmapToInt");
		int[] intArray = {1, 2, 3, 4, 5, 6};
		// 1. Stream<int[]>
		Stream<int[]> streamArray = Stream.of(intArray);

		// 2. Stream<int[]> -> flatMap -> IntStream
		IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));

		intStream.forEach(x -> System.out.println(x));
		log.info(CommonConst.line);
	}
}
