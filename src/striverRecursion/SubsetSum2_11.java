package striverRecursion;

import java.util.*;

public class SubsetSum2_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3};
		Arrays.sort(arr);
		List<Integer> li = new ArrayList<>();
		subset(arr,li,0);
	}

	private static void subset(int[] arr, List<Integer> li, int ind) {
		// TODO Auto-generated method stub
		if(ind == arr.length) {
			System.out.println(li);
			return;
		}
		for(int i=ind;i<arr.length;i++) {
			
			if(i!=ind && arr[i]==arr[i-1])
				continue;
			li.add(arr[i]);
			subset(arr, li, ind+1);
			li.remove(li.size()-1);
		}
	}

}
