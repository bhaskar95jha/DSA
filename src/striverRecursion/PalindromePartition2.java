package striverRecursion;

import java.util.*;

public class PalindromePartition2 {
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abbcde";
		List<String> ds = new ArrayList<String>();
		List<List<String>> ans = new ArrayList<>();
		palindromePartition(0,str,ds);
		System.out.println(min-1);
	}

	private static void palindromePartition(int ind,String str, List<String> ds) {
		// TODO Auto-generated method stub
		if(ind==str.length()) {
			min = Math.min(min, ds.size()); 
			return;
		}
		for(int i=ind;i<str.length();i++) {
			if(isPalindrome(str,ind,i)) {
				ds.add(str.substring(ind,i+1));
				palindromePartition(i+1, str, ds);
				ds.remove(ds.size()-1);
			}
		}
	}

	private static boolean isPalindrome(String str, int start, int end) {
		// TODO Auto-generated method stub
		while(start<=end) {
			if(str.charAt(start++)!=str.charAt(end--)) {
				return false;
			}
		}
		return true;
	}

}
