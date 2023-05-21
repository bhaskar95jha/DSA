package AlgoUMatrix;

import java.util.Scanner;

public class MatrixRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int matrix[][] = new int[n][n];
		
		for(int rows=0;rows<n;rows++) {
			for(int cols=0;cols<n;cols++) {
				matrix[rows][cols] = sc.nextInt();
			}
		}
		
		int rotateMatrix[][] = new int[n][n];
		for(int rows=0;rows<n;rows++) {
			for(int col=0;col<n;col++) {
				rotateMatrix[rows][col] = matrix[col][n-1-rows];
			}
		}
		
		for(int rows=0;rows<n;rows++) {
			for(int col=0;col<n;col++) {
				System.out.print(rotateMatrix[rows][col]+" ");
			}
			System.out.println();
		}
	}

}
