package stream.collect;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import stream.collect.domain.Person;

public class Colloct_Summary {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
			new Person("Max", 18), 
			new Person("Peter", 23), 
			new Person("Pamela", 23),
			new Person("David", 12)
		);
		
		IntSummaryStatistics ageSummary = persons.stream()
			.collect(Collectors.summarizingInt(p -> p.age));
		
		System.out.println("ageSummary : " + ageSummary);
		//ageSummary : IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}
	}
}
