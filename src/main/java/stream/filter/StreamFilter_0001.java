package stream.filter;

import java.util.Arrays;
import java.util.List;

public class StreamFilter_0001 {
	public static void main(String[] args) {
		//Array 생성
		List<String> list = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		
		list.stream().filter(s -> s.startsWith("c")) //List Filter 
			.map(String::toUpperCase)				 //Convert all content to upper case
			.sorted()								 //List Sort - C1, C2
			.forEach(System.out::println);			 //Print All List using System.out		
	}
}
