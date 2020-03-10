package stream.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map_0002 {
	public static void main(String[] args) {
		List<String> programing = Arrays.asList("Javascript", "C", "C++", "Nodejs", "Java", "Oracle", "MariaDB", "PHP", "ASP");
		programing.stream()
			.filter(str -> str.length() == 3)
			.map(str -> {
				List<String> result = new ArrayList<>();
				for (int i = 0; i < str.length(); i++) {
					result.add(str.substring(i, i + 1));
				}
				return result;
			})
			.forEach(str -> System.out.println(str));
	}
}
