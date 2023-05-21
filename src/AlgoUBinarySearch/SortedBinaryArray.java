package AlgoUBinarySearch;

import java.util.Scanner;

public class SortedBinaryArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int l = -1;
		int r = arr.length;
		
		while(l+1<r) {
			int m = l + (r-l)/2;
			if(arr[m]==0) {
				l = m;
			}else {
				r = m;
			}
		}
		System.out.println(r+" "+l);
		
	}

}
