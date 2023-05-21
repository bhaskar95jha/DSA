package AlgoUAdvanceArrayAndMatrix;

import java.util.Scanner;

public class WallPainting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int matrix[][] = new int[1001][1001];
		for(int i=0;i<n;i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			x1++;
			y1++;
			matrix[x1][y1]++;
			matrix[x2+1][y1]--;
			matrix[x1][y2+1]--;
			matrix[x2+1][y2+1]++;
		}
		int count=0;
		for(int i=1;i<=1000;i++) {
			for(int j=1;j<=1000;j++) {
				matrix[i][j] += (matrix[i-1][j] + matrix[i][j-1] - matrix[i-1][j-1]);
				if(matrix[i][j]==k) {
					count++;
				}
			}
		}
		System.out.println(count);
		
	}

}
