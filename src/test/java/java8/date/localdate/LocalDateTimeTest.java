package java8.date.localdate;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javaOld.consts.CommonConst;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalDateTimeTest {
	@Before
	public void init(){
		
	}
	
	@Test
	public void test1_Classic() {
		log.info(CommonConst.title, "test1_Classic");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test2_LocalDateTime_DateTimeFormatter(){
		log.info(CommonConst.title, "test2_LocalDateTime_DateTimeFormatter");
		// Get current date time
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Before : " + now);				//Before : 2016-11-09T11:44:44.797

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTime =now .format(formatter);
		System.out.println("After : " + formatDateTime);	//After  : 2016-11-09 11:44:44
		log.info(CommonConst.line);
	}
	
	@Test
	public void test3_StringToLocalDateTime(){
		log.info(CommonConst.title, "test3_");
		String now = "2016-11-09 10:30";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime formatDateTime = LocalDateTime.parse(now, formatter);
		System.out.println("Before : " + now);								//Before : 2016-11-09 10:30

		System.out.println("After : " + formatDateTime);					//After(LocalDateTime)  : 2016-11-09T10:30
		System.out.println("After : " + formatDateTime.format(formatter));	//After(String) 		: 2016-11-09 10:30
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
