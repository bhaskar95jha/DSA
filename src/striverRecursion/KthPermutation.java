package striverRecursion;

import java.util.*;

public class KthPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int k = 3;
		int fact = 1;
		List<Integer> numbers = new ArrayList<>();
		for(int i=1;i<n;i++) {
			fact = fact * i;
			numbers.add(i);
		}
		numbers.add(n);
		k = k-1;
		String ans = "";
		while(true) {
			ans = ans+numbers.get(k/fact);
			numbers.remove(k/fact);
			if(numbers.size()==0) {
				break;
			}
			k = k%fact;
			fact = fact/numbers.size();
		}
		System.out.println(ans);
	}

}
