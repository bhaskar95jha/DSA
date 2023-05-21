package AlgoUMatrix;

import java.util.Scanner;

public class PrefixSumMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int matrix[][] = new int[n][m];
		
		for(int rows=0;rows<n;rows++) {
			for(int cols=0;cols<m;cols++) {
				matrix[rows][cols] = sc.nextInt();
			}
		}
		prefixSum(matrix,n,m);
		for(int rows=0;rows<n;rows++) {
			for(int cols=0;cols<m;cols++) {
				System.out.print(matrix[rows][cols]+" ");
			}
			System.out.println();
		}

	}

	private static void prefixSum(int[][] matrix, int n, int m) {
		for(int rows=0;rows<n;rows++) {
			for(int cols=0;cols<m;cols++) {
				if(rows == 0 && cols == 0) {
					matrix[rows][cols] = matrix[rows][cols];
				}
				else if(rows == 0) {
					matrix[rows][cols] += matrix[rows][cols-1];
				}else if(cols == 0){
					matrix[rows][cols] += matrix[rows-1][cols];
				}else {
					matrix[rows][cols] =  matrix[rows][cols] + matrix[rows-1][cols] + matrix[rows][cols-1] - matrix[rows-1][cols-1];  
				}
			}
			
		}
	}

}
