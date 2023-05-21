package AlgoUSorting;

import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		for(int i=0;i<n-1;i++) {
			int min = Integer.MAX_VALUE;
			int swapIndex = -1;
			for(int j=i;j<n;j++) {
				min = Math.min(min, arr[j]);
				if(min == arr[j]) {
					swapIndex = j;
				}
			}
			if(i != swapIndex) {
				arr[i] = arr[i]+arr[swapIndex];
				arr[swapIndex] = arr[i]-arr[swapIndex];
				arr[i] = arr[i]-arr[swapIndex];
			}
			
		}
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
	}

}
