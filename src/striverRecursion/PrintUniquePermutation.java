package striverRecursion;

import java.util.*;

public class PrintUniquePermutation {

	public static void main(String[] args) {
		int arr[] = {1,2,3};
		Arrays.sort(arr);
		List<List<Integer>> ans = new ArrayList<>();
		printPermutation(0,arr,ans);
		
		for(List<Integer> li : ans) {
			for(int ele:li) {
				System.out.print(ele+", ");
			}
			System.out.println();
		}
	}

	private static void printPermutation(int ind, int[] arr, List<List<Integer>> ans) {
		// TODO Auto-generated method stub
		if(ind == arr.length) {
			
			List<Integer> ds = new ArrayList<>();
			for(int i=0;i<arr.length;i++) {
				ds.add(arr[i]);
			}
			ans.add(new ArrayList<>(ds));
			return;
		}
		
		for(int i=ind;i<arr.length;i++) {
			if(i>ind && arr[i]==arr[i-1])
				continue;
			swap(i,ind,arr);
			printPermutation(ind+1, arr, ans);
			swap(i,ind,arr);
		}
	}

	private static void swap(int i, int j, int[] arr) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	
}
