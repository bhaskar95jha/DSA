package Coderush2ArrayAdvance;

import java.util.Scanner;

public class MatrixReshape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n][m];
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		if(n*m != r*c) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}else {
			int ans[][] = new int[r][c];
			int column = m;
			int array[] = new int[n*m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					array[column*i+j] = arr[i][j];
				}
			}
			int index = 0;
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					ans[i][j] = array[index++];
				}
			}
			
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					System.out.print(ans[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}

}
