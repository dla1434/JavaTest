package stream.collect;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;

import stream.collect.domain.Person;

public class ColloctorOf {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
			new Person("Max", 18), 
			new Person("Peter", 23), 
			new Person("Pamela", 23),
			new Person("David", 12)
		);
		
		//Java의 문자열은 변하지 않기 때문에 우리는 컬렉터가 우리가 원하는 문자열을 만들게 하기 위해 StringJoiner 와 같은 헬퍼 클래스가 필요하다.
			//supplier는 먼저 StringJoiner를 적합한 구획 문자와 함께 생성하고,
			//accumulator는 StringJoiner에 각 사람의 대문자로 된 이름을 추가한다. 
			//combiner는 두 개의 StringJoiner를 하나로 합병하는 법을 알고 있고, 
			//마지막으로 finisher는 StringJoiner로부터 원하는 문자열을 생성한다.
		Collector<Person, StringJoiner, String> personNameCollector =
		    Collector.of(
		        () -> new StringJoiner(" | "),          // supplier
		        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
		        (j1, j2) -> j1.merge(j2),               // combiner
		        StringJoiner::toString);                // finisher

		String names = persons
		    .stream()
		    .collect(personNameCollector);

		System.out.println(names);  // MAX | PETER | PAMELA | DAVID
	}
}
