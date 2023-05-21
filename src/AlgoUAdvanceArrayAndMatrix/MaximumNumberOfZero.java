package AlgoUAdvanceArrayAndMatrix;

import java.util.Scanner;

public class MaximumNumberOfZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		int currCountZero = 0;
		int maxCountZero = 0;
		for(int i=0;i<k;i++) {
			if(arr[i]==0) {
				currCountZero++;
			}
		}
		maxCountZero = currCountZero;
		if(k>=n) {
			System.out.println("Maximum no. of zero's of "+k+" consecutive element is : "+maxCountZero);
		}else {
			for(int i=k;i<n;i++) {
				if(arr[i-k]==0) {
					currCountZero--;
				}
				if(arr[i] == 0) {
					currCountZero++;
				}
				maxCountZero = Math.max(maxCountZero, currCountZero);
			}
			System.out.println("Maximum no. of zero's of "+k+" consecutive element is : "+maxCountZero);
		}
	}

}
