package com.java8.files;


import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.java.test.consts.CommonConst;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FilesTest {
	@Before
	public void init(){
		
	}
	
	@Test
	public void test1_Classic() {
		log.info(CommonConst.title, "test1_Classic");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test2_(){
		log.info(CommonConst.title, "test2_");
		//절대 경로
//		String fileName = "c://lines.txt";
		
		//프로젝트 최상단에 위치 시
//		String fileName = "lines.txt";
		
		//현재 패키지에 위치 시
		String fileName = "./lines.txt";
		
		//실패) 절대 경로는 획득됐지만..앞에 /가 붙어서 인식이 안 된다. 이 방법을 사용하고 싶다면..substring으로 /를 제거하자
		URL url = getClass().getResource("lines.txt");
		System.out.println(url.getPath());			//	/D:/ONJ/Git_STS/JavaTest/target/test-classes/com/java8/files/lines.txt
		System.out.println(url.getPath().substring(1));			//	/D:/ONJ/Git_STS/JavaTest/target/test-classes/com/java8/files/lines.txt
		
		//read file into stream, try-with-resources
//		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
		try (Stream<String> stream = Files.lines(Paths.get(url.getPath().substring(1)))) {
			stream.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info(CommonConst.line);
	}
	
	@Test
	public void test3_(){
		log.info(CommonConst.title, "test3_");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test4_(){
		log.info(CommonConst.title, "test4_");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test5_(){
		log.info(CommonConst.title, "test5_");
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
