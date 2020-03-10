package stream.collect;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import stream.collect.domain.Person;

public class Colloct_AverageInt {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
			new Person("Max", 18), 
			new Person("Peter", 23), 
			new Person("Pamela", 23),
			new Person("David", 12)
		);
		
		Double averageAge = persons.stream()
			.collect(Collectors.averagingInt(p -> p.age));
		
		System.out.println("averageAge : " + averageAge);
	}
}
