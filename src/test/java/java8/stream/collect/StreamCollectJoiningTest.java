package java8.stream.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamCollectJoiningTest {
	@Test
	public void testStringJoin() {
		ArrayList foods = new ArrayList();
		foods.add("피자");
		foods.add("치킨");
		foods.add("맥도날드");
		foods.add("불고기");
		foods.add("샐러드");
		
		log.info("Array String Join : {}", foods.stream().collect(Collectors.joining(", ")));
	}
	
	@Test
	public void testMakeSql_Type2_Hangul() {
		String[] names = new String[] {"홍길동", "임꺽정", "슈퍼맨", "배트맨", "아이언맨" };
		List<String> nameList = Arrays.asList(names);
		
		String sql = nameList.stream()
			.map(name -> "'" + name + "'" )
			.collect(Collectors.joining(","));

		log.info("Make Sql Query 한글 처리 시 응용 : {}", sql.toString());
	}
}
