package java8.stream.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Filter_Collect {
	List<String> lines = null;

	@Before
	public void init() {
		lines = Arrays.asList("spring", "node", "mkyong");
	}

	@Test
	public void testClassic() {
		List<String> result = new ArrayList<>();
		// we dont like mkyong
		for (String line : lines) {
			if (!"mkyong".equals(line)) { 
				result.add(line);
			}
		}
		
		// output : spring, node
		for (String temp : result) {
			System.out.println(temp); 
		}
	}
	
	@Test
	public void testFilter1(){
		List<String> result = lines.stream() 				// convert list to stream
			.filter(line -> !"mkyong".equals(line)) 		// filter : get if value is not "mkyong"
			.collect(Collectors.toList()); 					// collect the output and convert streams to a List

		result.forEach(System.out::println); 				// output : spring, node
	}
	
	@Test
	public void testFilter2(){
		
	}
	
	@Test
	public void testFilter3(){
		
	}

}
