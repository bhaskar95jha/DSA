package AlgoUMatrix;

import java.util.Scanner;

public class CreateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[2][3];
		int[][] matrix1 = {{1,2,3},{4,5,6}};
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}

	}

}
