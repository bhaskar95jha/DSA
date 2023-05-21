package algouGraph.DFSRevesion;

import java.util.Scanner;

public class GridDFSImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int grid[][] = new int[n][m];
		int vis[][] = new int[n][m];
		int X[] = {0,0,1,-1};
		int Y[] = {-1,1,0,0};
		dfs(grid,1,1,0,vis,X,Y,n,m);
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void dfs(int[][] grid, int row, int col, int dist,int [][]vis,int []X,int []Y,int n,int m) {
		// TODO Auto-generated method stub
		grid[row][col] = dist;
		vis[row][col] = 1;
		
		for(int i=0;i<4;i++) {
			int nRow = row + X[i];
			int nCol = col + Y[i];
			if(check(nRow,nCol,n,m) && vis[nRow][nCol]==0) {
				dfs(grid, nRow, nCol, dist+1, vis, X, Y,n,m);
			}
		}
	}

	private static boolean check(int nRow, int nCol, int n, int m) {
		if(nRow>=0 && nCol>=0 && nRow<n && nCol<m)
			return true;
		else
			return false;
	}

}
