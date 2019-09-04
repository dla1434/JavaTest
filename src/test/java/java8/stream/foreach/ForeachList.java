package java8.stream.foreach;


import javaOld.consts.CommonConst;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class ForeachList {
	List<String> items = new ArrayList<>();

	@Before
	public void init(){
		items.add("A");
		items.add("B");
		items.add("C");
		items.add("D");
		items.add("E");
	}

	@Test
	public void testClassic() {
		for(String item : items){
			log.info("testClassic Item : {}", item);
		}
		log.info(CommonConst.line);
	}

	@Test
	public void testForeach1() {
		//lambda
		//Output : A,B,C,D,E
		items.forEach(item-> log.info("testForeach1 Item : {}", item));
		log.info(CommonConst.line);
	}

	@Test
	public void testForeach2() {
		items.forEach(item->{
			log.info("testForeach2 Item : {}", item);

			if("E".equals(item)){
				log.info("Key is E");
			}
		});
		log.info(CommonConst.line);
	}

	@Test
	public void testForeach3() {
		//method reference
		//Output : A,B,C,D,E
		items.forEach(System.out::println);
		log.info(CommonConst.line);
	}

	@Test
	public void testStreamFilterForeach() {
		log.info(CommonConst.title, "testStreamFilterForeach");
		//Stream and filter
		//Output : B
		items.stream()
			.filter(s->s.contains("B"))
			.forEach(System.out::println);
		log.info(CommonConst.line);
	}

	@Test
	public void testListForeach() {
		Arrays.asList(1, 2, 3).stream()
			.forEach(System.out::println);
	}
}
