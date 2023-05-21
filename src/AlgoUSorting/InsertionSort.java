package AlgoUSorting;

import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		for(int i=1;i<n;i++) {
			int temp = arr[i];
			int j = i-1;
			while(j>=0 && temp<arr[j]) {
				 arr[j+1] = arr[j];
				 j--;
			}
			arr[j+1] = temp;
		}
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
	}

}
