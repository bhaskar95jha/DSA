package AlgoUAdvanceArrayAndMatrix;

import java.util.Scanner;

public class RangeUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
	
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = 0;
		}
		while(k-- > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			arr[l] += 1;
			if(r<n-1)
				arr[r+1] -= 1;
		}
		for(int i=1;i<n;i++) {
			arr[i] += arr[i-1];
		}
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
