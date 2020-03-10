package stream.findfirst;

import java.util.Arrays;
import java.util.Optional;

public class StreamFindFirst_ifPresent {
	public static void main(String[] args) {
		Optional<String> findFirst = Arrays.asList("a1").stream().findFirst();
		findFirst.ifPresent(str -> {
			System.out.println("str : " + str);
		});
		
		
		Optional<Object> findFirst2 = Arrays.asList().stream().findFirst();
		findFirst2.ifPresent(str -> {
			System.out.println("str : " + str);
		});
		
	}
}
