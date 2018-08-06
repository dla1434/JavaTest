package com.java.test.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateTime_TimeZonTest {
	@Test
	public void test() {
		try 
		{
			TimeZone tz;
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss (z Z)");

			tz = TimeZone.getTimeZone("Asia/Seoul");
			df.setTimeZone(tz);
			System.out.format("%s%n%s%n%n", tz.getDisplayName(), df.format(date));

			tz = TimeZone.getTimeZone("Greenwich");
			df.setTimeZone(tz);
			System.out.format("%s%n%s%n%n", tz.getDisplayName(), df.format(date));

			tz = TimeZone.getTimeZone("America/Los_Angeles");
			df.setTimeZone(tz);
			System.out.format("%s%n%s%n%n", tz.getDisplayName(), df.format(date));

			tz = TimeZone.getTimeZone("America/New_York");
			df.setTimeZone(tz);
			System.out.format("%s%n%s%n%n", tz.getDisplayName(), df.format(date));

			tz = TimeZone.getTimeZone("Pacific/Honolulu");
			df.setTimeZone(tz);
			System.out.format("%s%n%s%n%n", tz.getDisplayName(), df.format(date));

			tz = TimeZone.getTimeZone("Asia/Shanghai");
			df.setTimeZone(tz);
			System.out.format("%s%n%s%n%n", tz.getDisplayName(), df.format(date));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
