package others;

import java.util.Scanner;

public class ShiftFromHalf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int halfIndex = (n/2);
		int m = 40;
		int j = halfIndex-1;
		for(int i=0;i<n;i++) {
			if(i==0 || i==n-1)
				continue;
			if(i<halfIndex) {
				int newInd = i+i;
				arr[i] = arr[i] + arr[newInd]*40;
			}else {
				int newInd = i - j;
				arr[i] = arr[i] + 
				j--;
			}
		}
	}

}
