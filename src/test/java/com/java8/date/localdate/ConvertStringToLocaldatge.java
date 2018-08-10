package com.java8.date.localdate;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.java.test.consts.CommonConst;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConvertStringToLocaldatge {
	@Before
	public void init(){
		
	}
	
	@Test
	public void test1_Classic() {
		log.info(CommonConst.title, "test1_Classic");
		log.info(CommonConst.line);
	}
	
	@Test
	//default formatter : ISO_LOCAL_DATE
	public void test2_convertStringToLocalDateDefaultFormatter(){
		log.info(CommonConst.title, "test2_convertStringToLocalDateDefaultFormatter");
		String date = "2016-08-16";
		LocalDate localDate = LocalDate.parse(date);
		System.out.println(localDate);		//2016-08-16
		log.info(CommonConst.line);
	}
	
	@Test
	//String : 16/08/2016
	public void test3_convertStringToLocalDateSetFormatter(){
		log.info(CommonConst.title, "test3_convertStringToLocalDateSetFormatter");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = "16/08/2016";
		LocalDate localDate = LocalDate.parse(date, formatter);
		System.out.println(localDate);		//2016-08-16
		log.info(CommonConst.line);
	}
	
	@Test
	//String : 16-Aug-2016
	public void test4_convertStringToLocalDateSetFormatter(){
		log.info(CommonConst.title, "test4_convertStringToLocalDateSetFormatter");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
		String date = "16-Aug-2016";
		LocalDate localDate = LocalDate.parse(date, formatter);
		System.out.println(localDate); // default, print ISO_LOCAL_DATE
		System.out.println(formatter.format(localDate));
		log.info(CommonConst.line);
	}
	
	@Test
	//String : Tue, Aug 16 2016
	public void test5_convertStringToLocalDateSetFormatter(){
		log.info(CommonConst.title, "test5_convertStringToLocalDateSetFormatter");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM d yyyy");
		String date = "Tue, Aug 16 2016";
		LocalDate localDate = LocalDate.parse(date, formatter);
		System.out.println(localDate);
		System.out.println(formatter.format(localDate));
		log.info(CommonConst.line);
	}
	
	@Test
	//String : Tuesday, Aug 16, 2016 12:10:56 PM
	public void test6_convertStringToLocalDateSetFormatter(){
		log.info(CommonConst.title, "test6_convertStringToLocalDateSetFormatter");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm:ss a");
		String date = "Tuesday, Aug 16, 2016 12:10:56 PM";
		LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
		System.out.println(localDateTime);
		System.out.println(formatter.format(localDateTime));
		log.info(CommonConst.line);
	}
	
	@Test
	//The ‘Z’ suffix means UTC, you can convert into a java.time.instant directly, then display it with a time zone.
	public void test7_(){
		log.info(CommonConst.title, "test7_");
		//UTC time : ‘Z’ suffix means UTC
		String dateInString = "2016-08-16T15:23:01Z";
		Instant instant = Instant.parse(dateInString);
		System.out.println("Instant : " + instant);		//Instant : 2016-08-16T15:23:01Z
		
		//UTC Time --> LocalDateTime
		// get localdateTime --> get locatedate
		LocalDateTime result = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));
		System.out.println("LocalDateTime : " + result);				//LocalDate : 2016-08-16T15:23:01
		System.out.println("LocalDate : " + result.toLocalDate());		//LocalDate : 2016-08-16

		// get date time + timezone
		ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Tokyo"));
		System.out.println(zonedDateTime);

		// get date time + timezone
		ZonedDateTime zonedDateTime2 = instant.atZone(ZoneId.of("Europe/Athens"));
		System.out.println(zonedDateTime2);
		log.info(CommonConst.line);
	}
	
	@Test
	//String -> ZonedDateTime -> LocalDate
	public void test8_(){
		log.info(CommonConst.title, "test8_");
		String date = "2016-08-16T10:15:30+08:00";
		ZonedDateTime result = ZonedDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
		
		System.out.println("ZonedDateTime : " + result);		//ZonedDateTime : 2016-08-16T10:15:30+08:00
		System.out.println("TimeZone : " + result.getZone());	//TimeZone : +08:00

		LocalDate localDate = result.toLocalDate();
		System.out.println("LocalDate : " + localDate);			//LocalDate : 2016-08-16
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
