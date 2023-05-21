package striverRecursion;

import java.util.*;

public class SubSetSum_10 {
	//print sum of all subset in it output should be printed in increasing order. 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[] = {3,1,2};
		//int n = 3;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		List<Integer> li = new ArrayList<>();
		subsetSum(0,0,arr,li);
		Collections.sort(li);
		System.out.println(li);
	}

	private static void subsetSum(int i, int sum, int[] arr, List<Integer> li) {
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
