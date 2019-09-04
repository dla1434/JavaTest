package java8.stream.reduce;

import java.util.ArrayList;
import java.util.List;

public class ReduceTest {
	public static void main(String[] args) {
		List<Boolean> results = new ArrayList<>();
		results.add(true);
		results.add(true);
		results.add(true);
		results.add(false);

		results.stream().reduce((a, b) -> a && b).get();
		System.out.println();
	}
}
