package java8.stream.create;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayToStream {
	@Test
	//일반적인 stream을 획득하는 방법 : Arrays.asList + Stream 사용
	public void testArraysToStream() {
		Stream<Integer> stream = Arrays.asList(1,2,3).stream();
		
		//참고) forEach를 수행해서 하나는 System.out, log.info를 출력했는데..하나만 수행된다..forEach를 수행하면 stream이 null이 되는건가?
		stream.forEach(item -> log.info("print : {}", item));
//		stream.forEach(System.out::println);
	}
	
	@Test
	//병렬로 stream을 획득하는 방법 : Arrays.asList + Stream 사용
	public void testArraysToStreamParellel() {
		String contents = "Javascript C C++ Nodejs Java Oracle MariaDB PHP ASP";
		Stream<String> stream = Stream.of(contents.split("[\\P{L}]+"));
	}
	
	@Test
	//Array에 대한 Stream 획득 방법 : Arrays.stream
	public void testArrayAllToStream() {
		String[] wordArray = {"Using", "Stream", "API", "From", "Java8"};
		Stream<String> stream = Arrays.stream(wordArray);
	}
	
	@Test
	//Array에 대한 Stream 획득 방법 : Arrays.stream
	public void testArrayPartialToStream() {
		String[] wordArray = {"Using", "Stream", "API", "From", "Java8"};

		//사용법 : Arrays.stream(array, from, to);
		Stream<String> stream = Arrays.stream(wordArray, 0, 4);
	}
}
