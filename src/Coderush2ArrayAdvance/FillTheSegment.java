package Coderush2ArrayAdvance;

import java.util.Scanner;

public class FillTheSegment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int q = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = 0;
		}
		while(q-- > 0) {
			int index = sc.nextInt();
			arr[index-1] = 1;
		}
		
		int count = 0;
		for(int i=0;i<k;i++) {
			if(arr[i] == 1) {
				count++;
			}
		}
		int min = count;
		
		for(int i=k;i<n;i++) {
			if(arr[i]==1) {
				count++;
			}
			if(arr[i-k]==1) {
				count--;
			}
			min = Math.min(min, count);
		}
		System.out.println(min);
		
	}

}
