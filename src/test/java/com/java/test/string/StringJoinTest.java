package com.java.test.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringJoinTest {
	@Test
	public void testStringJoin_Array() {
		ArrayList foods = new ArrayList();
		foods.add("피자");
		foods.add("치킨");
		foods.add("맥도날드");
		foods.add("불고기");
		foods.add("샐러드");
		
		log.info("Array String Join : {}", String.join(", ", foods));
	} 
	
	@Test
	public void testStringJoin_List() {
		String[] color = new String[] { " 빨강", "노랑", "초록", "파랑" };
		log.info("List String Join : {}", String.join("+ ", color));
	}
	
	@Test
	public void testMakeSql_Type1() {
		String[] param = new String[] {"1", "100", "154","155","21"};
		String paramforIn = String.join(",", param);
		StringBuilder sql = new StringBuilder();
		sql.append("Select * from raw_contacts where _id in (")
			.append(paramforIn).append(")");

		log.info("Make Sql Query 응용 : {}", sql.toString());
	}
}
