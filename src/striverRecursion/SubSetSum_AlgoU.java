package striverRecursion;

import java.util.*;

public class SubSetSum_AlgoU {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		long totalSum = 0;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			totalSum += arr[i];
		}
		
		List<Long> li = new ArrayList<>();
		subsetSum(0,0,arr,li);
		long ans = Long.MAX_VALUE;
		for(Long ele:li) {
			long second = totalSum - ele;
			ans = Math.min(Math.abs(ele-second), ans);
		}
		System.out.println(ans);
	}

	private static void subsetSum(int i, long sum, int[] arr, List<Long> li) {
		// TODO Auto-generated method stub
		if(i==arr.length) {
			li.add(sum);
			return;
		}
		
		sum += arr[i];
		subsetSum(i+1, sum, arr, li);
		sum -= arr[i];
		subsetSum(i+1, sum, arr, li);
	}

}
