package stream.map;

import java.util.Arrays;
import java.util.List;

public class Map_0001 {
	public static void main(String[] args) {
		List<String> programing = Arrays.asList("Javascript", "C", "C++", "Nodejs", "Java", "Oracle", "MariaDB", "PHP", "ASP");
		
		//Type1 - 축약사용
		System.out.println("Type1) 축약 사용");
		programing.stream()
			.map(String::toUpperCase)
			.forEach(str -> System.out.print("[" + str + "]"));
		
		System.out.println();
		System.out.println("--------------------------------------------------------------");
		
		//Type1 - 축약미사용
		System.out.println("Type2) 축약 미사용");
		programing.stream()
			.map(str -> str.toUpperCase())
			.forEach(str -> System.out.print("[" + str + "]"));
	}
}
