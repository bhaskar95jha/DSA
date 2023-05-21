package striverRecursion;

import java.util.*;

public class CombinationSum2_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,1,2,7,6,1,5};
		Arrays.sort(arr);
		int target = 4;
		List<Integer> li = new ArrayList<>();
		combinationSum(0,arr,target,li);
	}

	private static void combinationSum(int ind, int[] arr, int target, List<Integer> li) {
		// TODO Auto-generated method stub
		if(target == 0) {
			System.out.println(li);
			return;
		}
		
		for(int i=ind;i<arr.length;i++) {
			if(i>ind && arr[i]==arr[i-1]) {
				continue;
			}
			
			if(target<arr[i]) {
				break;
			}
			
			li.add(arr[i]);
			//target -= arr[i];
			combinationSum(ind+1, arr, target-arr[i], li);
			//target += arr[i];
			li.remove(li.size()-1);
		}
	}

}
