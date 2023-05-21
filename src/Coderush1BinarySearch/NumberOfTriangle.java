package Coderush1BinarySearch;

import java.util.*;

public class NumberOfTriangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int count = 0;
		for (int i = n - 1; i >= 1; i--) {
			int l = 0, r = i - 1;
			while (l < r) {
				if (arr[l] + arr[r] > arr[i]) {
					count += r - l;
					r--;
				}
				else{
					l++;
				}
			}
		}
		System.out.println(count);
	}

}





