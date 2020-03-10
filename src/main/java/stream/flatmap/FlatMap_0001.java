package stream.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMap_0001 {
	public static void main(String[] args) {
		List<String> programing = Arrays.asList("Javascript", "C", "C++", "Nodejs", "Java", "Oracle", "MariaDB", "PHP", "ASP");
		programing.stream()
			.filter(str -> str.length() == 3)
			.flatMap(str -> {
				List<String> result = new ArrayList<>();
				for (int i = 0; i < str.length(); i++) {
					result.add(str.substring(i, i + 1));
				}
//				return result; //에러 발생) flatMap의 반환은 stream이다.
				return result.stream();
			})
			.forEach(str -> System.out.print(str));
	}
}
