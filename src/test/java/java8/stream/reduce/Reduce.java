package java8.stream.reduce;

import java.util.ArrayList;
import java.util.List;

/*
	contains, reduce, anyMatch 처리 비교
 */
public class Reduce {
	public static void main(String[] args) {
		List<Boolean> results = new ArrayList<>();
		results.add(true);
		results.add(true);
		results.add(true);
		results.add(false);

		if (results.contains(false)) {
			System.out.println(false);
		}

		results.stream().reduce((a, b) -> a && b).get();
		System.out.println();

		//System.out.println(!results.stream().anyMatch(a -> a == false));
		System.out.println(!results.stream().anyMatch(a -> !a));
	}
}
