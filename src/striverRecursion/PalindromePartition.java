package striverRecursion;

import java.util.*;

public class PalindromePartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aabb";
		List<String> ds = new ArrayList<String>();
		List<List<String>> ans = new ArrayList<>();
		palindromePartition(0,str,ds,ans);
		ans.stream().forEach(System.out::println);
		int min = Integer.MAX_VALUE;
		for(List<String> li:ans) {
			min = Math.min(min,li.size());
		}
		//return min-1;
	}

	private static void palindromePartition(int ind,String str, List<String> ds, List<List<String>> ans) {
		// TODO Auto-generated method stub
		if(ind==str.length()) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		for(int i=ind;i<str.length();i++) {
			if(isPalindrome(str,ind,i)) {
				ds.add(str.substring(ind,i+1));
				palindromePartition(i+1, str, ds, ans);
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
