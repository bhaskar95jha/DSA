package AlgoUBinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int target = sc.nextInt();
		int l = -1;
		int r = n;
		while(l+1<r) {
			int mid = l+(r-l)/2;
			if(predicate(arr,mid,target)==0) {
				l = mid;
			}else {
				r = mid;
			}
		}
		System.out.println(r);
		
	}

	private static int predicate(int[] arr, int mid, int target) {
		// TODO Auto-generated method stub
		if(arr[mid]<target)
			return 0;
		else
			return 1;
	}

}
