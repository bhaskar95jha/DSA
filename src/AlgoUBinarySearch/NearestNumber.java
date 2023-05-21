package AlgoUBinarySearch;

import java.util.Scanner;

public class NearestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the length of Array");
		int n = sc.nextInt();
		int []arr = new int[n];
		for(int i=0;i<n;i++) {
			System.out.println("enter the "+(i+1)+" element of Array");
			arr[i] = sc.nextInt();
		}
		System.out.println("enter the target");
		int x = sc.nextInt();
		int l = -1;
		int r = n;
		while(l+1<r) {
			int m = l + (r-l)/2;
			if(predicate(arr[m],x)==0) {
				l = m;
			}else {
				r = m;
			}
		}
		int ans = (arr[r]-x)<(x-arr[l])?arr[r]:arr[l];
		System.out.println("closest no. is "+ans);
	}

	private static int predicate(int num, int x) {
		// TODO Auto-generated method stub
		if(num<x)
			return 0;
		else
			return 1;
	}

}
