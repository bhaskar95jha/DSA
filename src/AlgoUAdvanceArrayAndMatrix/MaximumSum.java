package AlgoUAdvanceArrayAndMatrix;

import java.util.Scanner;

public class MaximumSum {

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
		int maxSum = 0;
		int currSum = 0;
		for(int i=0;i<k;i++) {
			currSum += arr[i];
		}
		if(n<=k) {
			System.out.println("Maximum sum of k consecutive element is"+currSum);
		}else {
			maxSum = currSum;
			for(int i=k;i<n;i++) {
				currSum = currSum - arr[i-k] + arr[i];
				maxSum = Math.max(maxSum, currSum);
			}
			System.out.println("Maximum sum of "+k+ "consecutive element is"+maxSum);
		}
	}

}
