package striverRecursion;

import java.util.*;

public class GenerateAllSubSequence_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,1,2};
		int n = arr.length;
		List<Integer> ans = new ArrayList<>();
		subsequence(0,ans,arr,n);
	}

	private static void subsequence(int i, List<Integer> ans, int[] arr, int n) {
		// TODO Auto-generated method stub
		if(i>=n) {
			System.out.println(ans);
			return;
		}
		subsequence(i+1, ans, arr, n);
		ans.add(arr[i]);
		subsequence(i+1, ans, arr, n);
		ans.remove(ans.size()-1);
		// subsequence(i+1, ans, arr, n);
	}

}
