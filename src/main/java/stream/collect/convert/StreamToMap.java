package stream.collect.convert;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import stream.collect.domain.Person;

public class StreamToMap {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
			new Person("Max", 18), 
			new Person("Peter", 23), 
			new Person("Pamela", 23),
			new Person("David", 12)
		);
		
		Map<Integer, List<Person>> personsByAge = persons.stream()
			.collect(Collectors.groupingBy(p -> p.age));
		personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
	}
}
