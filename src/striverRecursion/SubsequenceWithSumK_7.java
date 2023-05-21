package striverRecursion;

import java.util.*;

public class SubsequenceWithSumK_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5};
		int k = 5;
		List<Integer> li = new ArrayList<>();
		System.out.println("Print all subsequence whose sum is k");
		subsequenceWithSumK(0,0,arr,k,li);
		System.out.println("Print only one subsequence whose sum is k");
		onesubsequenceWithSumK(0,0,arr,k,li);
		System.out.println("Count the subsequence whose sum is k");
		int count = countSubsequenceWithSumK(0,0,arr,k);
		System.out.println("Count is : "+count);
	}

	private static int countSubsequenceWithSumK(int i, int sum, int[] arr, int target) {
		// TODO Auto-generated method stub
		if(i==arr.length) {
			if(sum == target) {
				return 1;
			}else {
				return 0;
			}
		}
		
		sum += arr[i];
		int l = countSubsequenceWithSumK(i+1, sum, arr, target);
		sum -= arr[i];
		int r = countSubsequenceWithSumK(i+1, sum, arr, target);
		return l+r;
		
	}

	private static boolean onesubsequenceWithSumK(int i, int sum, int[] arr, int target, List<Integer> li) {
		// TODO Auto-generated method stub
		if(i==arr.length) {
			if(sum == target) {
				System.out.println(li);
				return true;
			}else {
				return false;
			}
		}
		
		//take
		li.add(arr[i]);
		sum += arr[i];
		if(onesubsequenceWithSumK(i+1, sum, arr, target, li) == true) {
			return true;
		}
		li.remove(li.size()-1);
		sum -= arr[i];
		//not take
		if(onesubsequenceWithSumK(i+1, sum, arr, target, li) == true) {
			return true;
		}
		
		return false;
		
	}

	private static void subsequenceWithSumK(int i, int sum, int[] arr, int target, List<Integer> li) {
		// TODO Auto-generated method stub
		if(i==arr.length) {
			if(sum == target) {
				System.out.println(li);
			}
			return;
		}
		
		//take
		li.add(arr[i]);
		sum += arr[i];
		subsequenceWithSumK(i+1, sum, arr, target, li);
		li.remove(li.size()-1);
		sum -= arr[i];
		//not take
		subsequenceWithSumK(i+1, sum, arr, target, li);
	}

}
