package Coderush2ArrayAdvance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralTraversalTwisted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int q = sc.nextInt();
		int n = sc.nextInt();
		int matrix[][] = new int[p][q];
		
		for(int rows=0;rows<p;rows++) {
			for(int cols=0;cols<q;cols++) {
				matrix[rows][cols] = 0;
			}
		}
		
		while(n-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int val = sc.nextInt();
			matrix[x][y] = val;
		}
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		
		
		spiralPrint(matrix,p,q,a,b);
		
		
		sc.close();
		
	}

	private static void spiralPrint(int[][] matrix, int n, int m,int a,int b) {
		
		int top = 0;
		int bottom = n-1;
		int left = 0;
		int right = m-1;
		int dir = 1;
		while(left <= right && top <= bottom) {
			if(dir==1) {
			
			}
		}
		
	}

}
