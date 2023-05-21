package normal.testing;

import java.util.*;

public class TestStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//		int sumx = numbers.stream().reduce(0, Integer::sum);
		int sumx = numbers.stream().reduce(0, (a,b) -> a+b);
		System.out.println(sumx); // Output: 15

	}

}
