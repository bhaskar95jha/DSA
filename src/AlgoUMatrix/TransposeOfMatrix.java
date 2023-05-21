package AlgoUMatrix;

import java.util.Scanner;

public class TransposeOfMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[3][4];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		transpose(matrix);

	}

	private static void transpose(int[][] matrix) {
		// TODO Auto-generated method stub
		int[][] transposeMatrix = new int[4][3];
		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				System.out.println(matrix[j][i]);
			}
		}
		
//		for(int i=0;i<4;i++) {
//			for(int j=0;j<3;j++) {
//				System.out.println(transposeMatrix[i][j]);
//			}
//		}
		
	}

}
