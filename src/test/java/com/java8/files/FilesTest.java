package com.java8.files;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
public class FilesTest {
	@Before
	public void init(){
		
	}
	
	@Test
	//new BufferedReader(new FileReader("파일")
	public void test1_ClassicBufferedReader() {
		log.info(CommonConst.title, "test1_Classic");
		try (BufferedReader br = new BufferedReader(new FileReader(getClass().getResource("lines.txt").getPath().substring(1)))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info(CommonConst.line);
	}
	
	@Test
	public void test1_ClassicScanner() {
		log.info(CommonConst.title, "test1_Classic");
		try (Scanner scanner = new Scanner(new File(getClass().getResource("lines.txt").getPath().substring(1)))) {
			while (scanner.hasNext()){
				System.out.println(scanner.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info(CommonConst.line);
	}
	
	@Test
	public void test2_FileRead_Stream(){
		log.info(CommonConst.title, "test2_FileRead_Stream");
		//절대 경로
//		String fileName = "c://lines.txt";
		
		//프로젝트 최상단에 위치 시
//		String fileName = "lines.txt";
		
		//현재 패키지에 위치 시 - 실패
//		String fileName = "./lines.txt";
		
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
	public void test3_FileRead_Stream_Extra(){
		log.info(CommonConst.title, "test3_");
		List<String> list = new ArrayList<>();

		//1. filter line 3
		//2. convert all content to upper case
		//3. convert it into a List
		try (Stream<String> stream = Files.lines(Paths.get(getClass().getResource("lines.txt").getPath().substring(1)))) {
			list = stream
					.filter(line -> !line.startsWith("line3"))
					.map(String::toUpperCase)
					.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		list.forEach(System.out::println);
		log.info(CommonConst.line);
	}
	
	@Test
	public void test4_BufferReader_Stream(){
		log.info(CommonConst.title, "test4_");
		List<String> list = new ArrayList<>();
		try (BufferedReader br = Files.newBufferedReader(Paths.get(getClass().getResource("lines.txt").getPath().substring(1)))) {
			//br returns as stream and convert it into a List
			list = br.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		list.forEach(System.out::println);
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
