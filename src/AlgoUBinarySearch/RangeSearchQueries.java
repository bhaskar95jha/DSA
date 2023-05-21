package AlgoUBinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class RangeSearchQueries {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int arr[] = new int[n];
		
	
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		for(int i=0;i<q;i++) {
			
			int l = sc.nextInt();
			int r = sc.nextInt();
			
			int s = -1;
			int e = n;
			while(s+1<e) {
				int m = s + (e-s)/2;
				if(predicateForLowerBound(arr[m],l)==0) {
					s = m;
				}else {
					e = m;
				}
			}
			int lIndex = s;
			
			s = -1;
			e = n;
			while(s+1<e) {
				int m = s + (e-s)/2;
				if(predicateForUpperBound(arr[m],r)==0) {
					s = m;
				}else {
					e = m;
				}
			}
			
			int rIndex = s;
			
			System.out.print((rIndex-lIndex)+" ");
			
		}
	}

	private static int predicateForUpperBound(int num, int r) {
		// TODO Auto-generated method stub
		if(num>r)
			return 1;
		else
			return 0;
	}

	private static int predicateForLowerBound(int num, int l) {
		// TODO Auto-generated method stub
		if(num<l)
			return 0;
		else
			return 1;
	}

}
