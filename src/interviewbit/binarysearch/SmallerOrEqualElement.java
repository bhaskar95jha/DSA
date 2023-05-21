package interviewbit.binarysearch;

import java.util.*;

public class SmallerOrEqualElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(5);
		al.add(5);
		//al.add(6);
		int b = 2;
		int ans = solve(al,b);
		System.out.println(ans);
	}

	private static int solve(List<Integer> al, int b) {
		int l = -1;
		int r = al.size();
		while(l+1<r) {
			int mid = l+(r-l)/2;
			int num = al.get(mid);
			if(predicate(num,b)==0) 
				l = mid;
			else 
				r = mid;
			
		}
		return l+1;
	}

	private static int predicate(int num, int b) {
		// TODO Auto-generated method stub
		if(num<=b)
			return 0;
		else
			return 1;
	}

}
