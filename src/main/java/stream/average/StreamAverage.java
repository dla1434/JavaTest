package stream.average;

import java.util.Arrays;

public class StreamAverage {
	public static void main(String[] args) {
		Arrays.stream(new int[]{1,2,3})
			.map(n -> {
				System.out.print("n : " + n + "  --->  ");
				System.out.println(2 * n + 1);
				return 2 * n + 1;
			})
			.average()
			.ifPresent(System.out::println);
	}
}
