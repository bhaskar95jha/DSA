package AlgoUBinarySearchMaximin_MiniMax;

import java.util.Arrays;
import java.util.Scanner;

public class Transport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int c = sc.nextInt();
		int arr[] = new int[n];
		int max = -1;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			max = Math.max(arr[i],max);
		}
		Arrays.sort(arr); //n log n
		
		int l = -1;
		int r = max;
		
		while(l+1<r) { // log n
			int mid = l + (r-l)/2;
			if(predicate(arr,mid,m,c)==0) {
				l = mid;
			}else {
				r = mid;
			}
		}
		
		System.out.println(r);
		
	}

	private static int predicate(int[] arr, int mid, int m, int c) {
		
		int n = arr.length; 
		int no_of_busses = 1;
		int capacity = 1;
		int waitingTime = arr[0];
		
		for(int i=0;i<n;i++) {
			if(arr[i] - waitingTime > mid || capacity>c) {
				no_of_busses++;
				if(no_of_busses > m) {
					return 0;
				}
				capacity = 1;
				waitingTime = arr[i];
			}
			capacity++;
		}
		
		
		if(no_of_busses > m) {
			return 0;
		}else {
			return 1;
		}
	}

}
