package java8.StringJoiner;


import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javaOld.consts.CommonConst;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringJoinerTest {
	@Before
	public void init(){
		
	}
	
	@Test
	public void test1_Classic() {
		log.info(CommonConst.title, "test1_Classic");
		log.info(CommonConst.line);
	}
	
	@Test
	//Join String by a delimiter
	public void test2_StringJoiner(){
		log.info(CommonConst.title, "test2_StringJoiner");
		StringJoiner sj = new StringJoiner(",");
		sj.add("aaa");
		sj.add("bbb");
		sj.add("ccc");
		String result = sj.toString(); // aaa,bbb,ccc
		System.out.println(result);
		log.info(CommonConst.line);
	}
	
	@Test
	public void test3_StringJoinerPrefixSuffix(){
		log.info(CommonConst.title, "test3_StringJoinerPrefixSuffix");
		StringJoiner sj = new StringJoiner("/", "prefix-", "-suffix");
		sj.add("2016");
		sj.add("02");
		sj.add("26");
		String result = sj.toString(); // prefix-2016/02/26-suffix
		System.out.println(result);
		log.info(CommonConst.line);
	}
	
	@Test
	public void test4_(){
		log.info(CommonConst.title, "test4_");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test5_StringJoin(){
		log.info(CommonConst.title, "test5_StringJoin");
		//2015-10-31
		String result = String.join("-", "2015", "10", "31" );
		System.out.println(result);
		
		List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
	 	//java, python, nodejs, ruby
		String result1 = String.join(", ", list);
		System.out.println(result1);
		log.info(CommonConst.line);
	}
	
	
	@Test
	public void test6_CollectorsJoining(){
		log.info(CommonConst.title, "test6_");
		List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
		//java | python | nodejs | ruby
		String result = list.stream()
			.map(x -> x)
			.collect(Collectors.joining(" | "));
		System.out.println(result);
		
		//java | python | nodejs | ruby
		//map이 없어도 map에서 조작이 없다면 바로 collect 호출해서 처리해도 된다.
		String result1 = list.stream()
			.collect(Collectors.joining(" | "));
		System.out.println(result1);
		
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
