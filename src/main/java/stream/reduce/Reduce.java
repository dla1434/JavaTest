package stream.reduce;

import java.util.Arrays;

public class Reduce {
	public static void main(String[] args) {
		Integer reduceResult = Arrays.asList(1,2,3).stream()
			.reduce((a,b)-> a-b)
			.get(); 
		
		System.out.println("result : " + reduceResult);
		
		
		reduceResult = Arrays.asList(1,2,3).stream()
			.reduce((a,b)-> {
				System.out.println(a-b);
				return a-b;
			})
			.get(); 
		
		System.out.println("result : " + reduceResult);
	}
}
