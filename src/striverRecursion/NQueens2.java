package striverRecursion;

import java.util.*;

public class NQueens2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		char [][]board = new char[n][n];
		for(int i =0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j] = '.';
			}
		}
		int leftRow[] = new int[n];
		int lowerDiagonal[] = new int[2*n-1];
		int upperDiagonal[] = new int[2*n-1];
		
		int ans = nQueens(0,n,board,leftRow,lowerDiagonal,upperDiagonal);
		
		System.out.println(ans);

	}

	private static int nQueens(int col, int n, char[][] board, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
		// TODO Auto-generated method stub
		if(col == n) {
			return 1;
		}
		
		int count = 0;
		for(int row=0;row<n;row++) {
			if(leftRow[row]==0 && lowerDiagonal[row+col]==0 && 
					upperDiagonal[n-1+col-row]==0) {
				leftRow[row] = 1;
				lowerDiagonal[row+col] = 1;
				upperDiagonal[n-1+col-row] = 1;
				board[row][col] = 'Q';
				count += nQueens(col+1, n, board, leftRow, lowerDiagonal, upperDiagonal);
				leftRow[row] = 0;
				lowerDiagonal[row+col] = 0;
				upperDiagonal[n-1+col-row] = 0;
				board[row][col] = '.';
			}
		}
		return count;
	}

}
