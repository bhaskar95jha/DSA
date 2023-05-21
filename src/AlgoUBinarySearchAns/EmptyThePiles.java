package AlgoUBinarySearchAns;

import java.util.Scanner;

public class EmptyThePiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int h = sc.nextInt();
		int arr[] = new int[n];
		int max = 0;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
		}
		int l = 0;
		int r = max;
		while(l+1<r) {
			int m = l + (r-l)/2;
			if(predicate(arr,m,h)==0) {
				l = m;
			}else {
				r = m;
			}
		}
		System.out.println(r);
	}

	private static int predicate(int[] arr, int m, int h) {
		// TODO Auto-generated method stub
		
		int count = 0;
		for(int ele:arr) {
			count += Math.ceil((double)ele/m);
		}
		if(count<=h)
			return 1;
		else
			return 0;
	}

}
