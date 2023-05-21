package algouGraph.set1;

import java.util.Scanner;

public class AdjacencyMatrixToAdjacencyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt(); 
			}
		}
		for(int i=0;i<n;i++) {
			System.out.print((i+1)+":");
			for(int j=0;j<n;j++) {
				if(arr[j][i]==1) {
					System.out.print(" "+(j+1));
				}
			}
			System.out.println();
		}
	}

}
