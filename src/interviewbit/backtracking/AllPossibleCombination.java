package interviewbit.backtracking;

import java.util.*;

public class AllPossibleCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []ip = {"ab","cd","e"};
		List<String> op = new ArrayList<>();
		int ind = 0;
		String ds = new String();
		solve(ip,op,ds,ind);
		op.stream().forEach(System.out::println);
	}

	private static void solve(String[] ip, List<String> op, String ds, int ind) {
		if(ds.length() == ip.length) {
			op.add(ds);
			return;
		}
		
		for(char ch:ip[ind].toCharArray()) {
			ds = ds + ch;
			solve(ip,op,ds,ind+1);
			ds = ds.substring(0,ds.length()-1);
		}
	}

}
