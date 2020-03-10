package stream.findfirst;

import java.util.Arrays;

public class StreamFindFirst {
	public static void main(String[] args) {
		Arrays.asList("a1", "a2", "a3").stream()
			.findFirst()
			.ifPresent(System.out::println);
	}
}
