package interviewbit.binarysearch;

import java.util.*;

public class BitonicArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> al = new ArrayList<>();
		al.add(3);
		al.add(9);
		al.add(10);
		al.add(20);
		al.add(17);
		al.add(5);
		al.add(1);
		int b =-3;
		int ans = solve(al,b);
		System.out.println(ans);
	}

	private static int solve(List<Integer> al, int b) {
		// TODO Auto-generated method stub
		int l = -1;
		int r = al.size();
		while(l+1<r) {
			int mid = l+(r-l)/2;
			if(predicate(al.get(mid),al.get(mid-1))==0) {
				l = mid;
			}else {
				r = mid;
			}
		}
		int bitonicIndex =  l;
		
		int incr = searchIncr(0,bitonicIndex,b,al);
		int decr = searchDecr(bitonicIndex+1,al.size()-1,b,al);
		int ans = -1;
		
		if(decr != -1) {
			ans = decr;
		}
		if(incr != -1) {
			ans = incr;
		}
		return ans;
	}
	
	private static int searchIncr(int i, int bitonicIndex, int b, List<Integer> al) {
		// TODO Auto-generated method stub
		int l = i-1;
		int r = bitonicIndex+1;
		while(l+1<r) {
			int mid = l+(r-l)/2;
			int num = al.get(mid);
			if(predicateIncr(num,b)==0){
				l = mid;
			}else {
				r = mid;
			}
		}
		return al.get(r)==b?r:-1;
	}

	private static int searchDecr(int bitonicIndex, int size, int b, List<Integer> al) {
		// TODO Auto-generated method stub
		int l = bitonicIndex-1;
		int r = size+1;
		while(l+1<r) {
			int mid = l+(r-l)/2;
			int num = al.get(mid);
			if(predicateDecr(num,b)==0){
				l = mid;
			}else {
				r = mid;
			}
		}
		return al.get(l)==b?l:-1;
	}
	

	private static int predicateDecr(int num, int b) {
		// TODO Auto-generated method stub
		if(num<b)
			return 1;
		else
			return 0;
	}

	private static int predicateIncr(int num, int target) {
		if(num<target)
			return 0;
		else
			return 1;
	}

	private static int predicate(Integer mid, Integer prev) {
		if(prev<=mid)
			return 0;
		else
			return 1;
	}

}
