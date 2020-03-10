package stream.collect;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import stream.collect.domain.Person;

public class Colloct_ToMap {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
			new Person("Max", 18), 
			new Person("Peter", 23), 
			new Person("Pamela", 23),
			new Person("David", 12)
		);
		
		//join 컬렉터는 구획 문자, 추가적으로 접두사와 접미사를 받아들인다.
		String phrase = persons.stream()
			.filter(p -> p.age >= 18)
			.map(p -> p.name)
			.collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
		
		System.out.println(phrase);
		// In Germany Max and Peter and Pamela are of legal age.
	}
}
