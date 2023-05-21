package AlgoUMatrix;

import java.util.Scanner;

public class SpecialMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long matrix[][] = new long[n][n];
		
		for(int rows=0;rows<n;rows++) {
			for(int cols=0;cols<n;cols++) {
				matrix[rows][cols] = sc.nextLong();
			}
		}
		long[] rowSum = new long[n];
		long[] colSum = new long[n];
		long max = 0;
		for(int rows=0;rows<n;rows++) {
			long sum = 0;
			long sum1 = 0;
			for(int col=0;col<n;col++) {
				sum += matrix[rows][col];
				sum1 += matrix[col][rows];
			}
			max = Math.max(max, Math.max(sum, sum1));
			rowSum[rows] = sum;
			colSum[rows] = sum1;
		}
		long ans = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				long rSum = rowSum[i];
				long cSum = colSum[j];
				if(rSum>cSum) {
					long inc = max - rSum;
					ans += inc;
					rowSum[i] += inc;
					colSum[j] += inc;
				}else {
					long inc = max - cSum; 
					ans += inc;
					colSum[j] += inc;
					rowSum[i] += inc;
				}
			}
		}
		System.out.println(ans);
	}

}
