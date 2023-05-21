package Coderush1BinarySearch;

import java.util.Scanner;

public class Candies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[n];
		int sum = 0;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		if(m>n) {
			System.out.println(-1);
			sc.close();
			return;
		}
		int l = arr[0];
		int r = sum;
		while(l+1<r) {
			int mid = l + (r-l)/2;
			if(predicate(arr,mid,m)==0) {
				l = mid;
			}else {
				r = mid;
			}
		}
		System.out.println(r);
		sc.close();

	}

	private static int predicate(int[] arr, int maxCandy, int maxChild) {
		// TODO Auto-generated method stub
		int currChild = 1;
		int currCandy = 0;
		for(int candy:arr) {
		    if(candy>maxCandy)
		        return 0;
			currCandy += candy;
			if(currCandy>maxCandy) {
				currChild++;
				if(currChild>maxChild) {
					return 0;
				}
				currCandy = candy;
			}
		}
		return 1;
	}
}
