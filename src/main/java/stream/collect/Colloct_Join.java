package stream.collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import stream.collect.domain.Person;

public class Colloct_Join {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
			new Person("Max", 18), 
			new Person("Peter", 23), 
			new Person("Pamela", 23),
			new Person("David", 12)
		);
		
		//Map Key가 중복되는 경우를 대비하여 아래와 같이 같은 키 중복 시 ;로 값을 병합할 수 있다.
		Map<Integer, String> map = persons
		    .stream()
		    .collect(Collectors.toMap(
		        p -> p.age,
		        p -> p.name,
		        (name1, name2) -> name1 + ";" + name2));

		System.out.println(map);
		// {18=Max, 23=Peter;Pamela, 12=David}
		
		System.out.println(map.get(18));
		System.out.println(map.get(12));
		System.out.println(map.get(23));
	}
}
