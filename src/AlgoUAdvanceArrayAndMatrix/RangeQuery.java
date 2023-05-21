package AlgoUAdvanceArrayAndMatrix;

import java.util.Scanner;

public class RangeQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long arr[] = new long[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		for(int i=1;i<n;i++) {
			arr[i] = arr[i-1] + arr[i];
		}
		while(k-- > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			if(l>1)
				System.out.println(arr[r-1]-arr[l-2]);
			else {
				System.out.println(arr[r-1]);
			}
		}
		sc.close();
	}

}
