package java8.stream.foreach;


import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import javaOld.consts.CommonConst;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ForeachMap {
	Map<String, Integer> items = new HashMap<>();
	
	@Before
	public void init(){
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);
	}
	
	@Test
	public void testClassic() {
		for (Map.Entry<String, Integer> entry : items.entrySet()) {
			log.info("testClassic Key : " + entry.getKey() + " Value : " + entry.getValue());
		}
		log.info(CommonConst.line);
	}
	
	@Test
	public void testForeach1() {
		items.forEach((k,v) -> log.info("testForeach1 Key : {}, Value : {}", k, v));
		log.info(CommonConst.line);
	} 
	
	@Test
	public void testForeach2() {
		items.forEach((k,v) -> {
			log.info("testForeach2 Key : {}, Value : {}", k, v);
			
			if("E".equals(k)){
				log.info("Key is E");
			}
		});
	} 
}
