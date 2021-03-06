package stream.collect.convert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringToStreamList {
	public static void main(String[] args) {
		List<String> programing = Arrays.asList("Javascript", "C", "C++", "Nodejs", "Java", "Oracle", "MariaDB", "PHP", "ASP");
		String collectResult = programing.stream()
			.collect(Collectors.joining(" "));
		System.out.println("String : "  + collectResult);
		
		String[] splitList = collectResult.split(" ");
		Stream<String> streamList = Stream.of(splitList);
		streamList.forEach(str -> System.out.print("[" + str + "]"));
	}
}
