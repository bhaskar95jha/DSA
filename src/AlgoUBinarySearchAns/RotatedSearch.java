package AlgoUBinarySearchAns;

import java.util.Scanner;

public class RotatedSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int l = -1;
		int r = n;
		while(l+1<r) {
			int mid = l + (r-l)/2;
			if(predicate(arr,mid)==0) {
				l = mid;
			}else {
				r = mid;
			}
		}
		System.out.println(arr[r]);
		
	}

	private static int predicate(int[] arr, int mid) {
		// TODO Auto-generated method stub
		int n = arr.length-1;
		if(arr[mid]>arr[n])
			return 0;
		else
			return 1;
	}

}

//try to do with SBA.


/*
 * while(l<=r) {   
			int mid = l + (r-l)/2;
			int next = (mid+1) % n;
			int prev = (mid-1+n) % n;
			if(arr[mid]<arr[prev] && arr[mid]<arr[next]) {
		        System.out.println(arr[mid]);
		        return;
			}else if(arr[mid]>arr[prev] && arr[mid]>arr[next]){
			    System.out.println(arr[(mid+1)%n]);
			    return;
			}
			else if(arr[l]<arr[mid]) {
				l = mid+1;
			}else if(arr[mid]<arr[r]) {
				r = mid-1;
			}else {
				System.out.println(arr[r]);
				return;
			}
		}
 * 
 * */
