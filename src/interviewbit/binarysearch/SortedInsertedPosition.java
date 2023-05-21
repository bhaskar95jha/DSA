package interviewbit.binarysearch;

import java.util.*;

public class SortedInsertedPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(3);
		al.add(5);
		al.add(6);
		int b = 5;
		int l = -1;
		int r = al.size();
		while(l+1<r) {
			int mid = l + (r-l)/2;
			int nums = al.get(mid); 
			if(predicate(nums,b)==0) {
				l = mid;
			}else {
				r = mid;
			}
		}
		System.out.println(r);
	}

	private static int predicate(int nums, int b) {
		if(nums<b)
			return 0;
		else
			return 1;
	}

}
