package AlgoURecursion;

import java.util.*;

public class PrintPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		List<Character> chList = new ArrayList<>();
		boolean []freq = new boolean[str.length()];
		List<String> ans = new ArrayList<>();
		printPermutation(ans,str,chList,freq);
		Collections.sort(ans);
		for(String st:ans){
		    System.out.println(st);
		}
	}

	private static void printPermutation(List<String> ans,
	String str, List<Character> chList, boolean[] freq) {
		// TODO Auto-generated method stub
		if(chList.size() == str.length()) {
			Object[]objArray = chList.toArray();
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<objArray.length;i++) {
				sb.append(objArray[i]);
			}
			String s = sb.toString();
			ans.add(s);
			return;
		}
		
		for(int i=0;i<str.length();i++) {
			if(!freq[i]) {
				chList.add(str.charAt(i));
				freq[i] = true;
				printPermutation(ans,str, chList, freq);
				chList.remove(chList.size()-1);
				freq[i] = false;
			}
		}
	}

	

}
