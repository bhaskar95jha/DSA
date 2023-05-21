package striverRecursion;

import java.util.*;

public class LetterCasePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "3z4";
		List<String> ans = new ArrayList<>();
		char []arr = str.toCharArray();
		letterCasePermutation(0,arr,ans);
		ans.stream().forEach(System.out::println);
	}

	private static void letterCasePermutation(int i, char[] arr, List<String> ans) {
		// TODO Auto-generated method stub
		if(i==arr.length) {
			String str = new String(arr);
			ans.add(str);
			return;
		}
		
		if(Character.isDigit(arr[i])) {
			letterCasePermutation(i+1, arr, ans);
		}
		
		char ch = arr[i];
		if(Character.isLowerCase(ch)) {
			ch = Character.toUpperCase(ch);
			arr[i] = ch;
			letterCasePermutation(i+1,arr,ans);
			ch = Character.toLowerCase(ch);
			arr[i] = ch;
			letterCasePermutation(i+1, arr, ans);
		}
		if(Character.isUpperCase(ch)) {
			ch = Character.toLowerCase(ch);
			arr[i] = ch;
			letterCasePermutation(i+1,arr,ans);
			ch = Character.toUpperCase(ch);
			arr[i] = ch;
			letterCasePermutation(i+1, arr, ans);
		}
		
	}

}
