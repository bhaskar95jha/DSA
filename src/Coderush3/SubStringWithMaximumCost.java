package Coderush3;

import java.util.*;

public class SubStringWithMaximumCost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		String chars = "abc";
		int vals[] = {-1,-1,-1};
		Map<Character, Integer> hm = new HashMap<>();
		for(int i=0;i<vals.length;i++) {
			hm.put(chars.charAt(i), vals[i]);
		}
		int []arr = new int[s.length()];
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(hm.containsKey(ch)) {
				arr[i] = hm.get(ch);
			}else {
				arr[i] = (ch-'a') + 1;
			}
		}
		int ans = kadane(arr);
		System.out.println(ans);
		
	}
	
	public static int kadane(int[] arr) {
	    int max_so_far = 0;
	    int max_ending_here = 0;
	    for (int i = 0; i < arr.length; i++) {
	        max_ending_here = max_ending_here + arr[i];
	        if (max_ending_here < 0) {
	            max_ending_here = 0;
	        } else if (max_ending_here > max_so_far) {
	            max_so_far = max_ending_here;
	        }
	    }
	    return max_so_far;
	}


}
