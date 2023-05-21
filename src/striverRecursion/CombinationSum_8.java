package striverRecursion;

import java.util.*;

public class CombinationSum_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {2,3,6,7};
		int target = 7;
		List<Integer> li = new ArrayList<>();
		System.out.println("All combination Sum with sum is k");
		combinationSum(0,0,target,arr,li);
		System.out.println("only one combination Sum with sum is k");
		onlyOneCombinationSum(0,0,target,arr,li);
		System.out.println("count all combination Sum with sum is k");
		int count = countCombinationSum(0,0,target,arr);
		System.out.println("Count is : "+count);
	}

	private static int countCombinationSum(int i, int sum, int target, int[] arr) {
		// TODO Auto-generated method stub
		if(sum>target)
			return 0;
		
		if(i==arr.length) {
			if(sum == target) {
				return 1;
			}else {
				return 0;
			}
		}
		
		sum += arr[i];
		int l = countCombinationSum(i, sum, target, arr);
		sum -= arr[i];
		int r = countCombinationSum(i+1, sum, target, arr);
		
		return l+r;
	}

	private static boolean onlyOneCombinationSum(int i, int sum, int target, int[] arr, List<Integer> li) {
		// TODO Auto-generated method stub
		
		if(sum>target)
			return false;
		if(i==arr.length) {
			if(sum==target) {
				System.out.println(li);
				return true;
			}else {
				return false;
			}
		}
		
		li.add(arr[i]);
		sum += arr[i];
		if(onlyOneCombinationSum(i,sum,target,arr,li)==true)
			return true;
		li.remove(li.size()-1);
		sum -= arr[i];
		if(onlyOneCombinationSum(i+1, sum, target, arr, li)==true)
			return true;
		
		return false;
	}

	private static void combinationSum(int i, int sum, int target, int[] arr, List<Integer> li) {
		// TODO Auto-generated method stub
		if(sum>target) {
			return;
		}
		
		if(i==arr.length) {
			if(sum == target) {
				System.out.println(li);
			}
			return;
		}
		//take
		li.add(arr[i]);
		sum += arr[i];
		combinationSum(i, sum, target, arr, li);
		li.remove(li.size()-1);
		sum -= arr[i];
		//non-take
		combinationSum(i+1, sum, target, arr, li);
	}

}
