package striverRecursion;

import java.util.*;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		char [][]board = new char[n][n];
		for(int i =0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j] = '.';
			}
		}
		int leftRow[] = new int[n];
		int lowerDiagonal[] = new int[2*n-1];
		int upperDiagonal[] = new int[2*n-1];
		List<List<String>> ans = new ArrayList<>();
		nQueens(0,n,board,leftRow,lowerDiagonal,upperDiagonal,ans);
		ans.stream().forEach(System.out::println);

	}

	private static void nQueens(int col, int n, char[][] board, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal,List<List<String>>ans) {
		// TODO Auto-generated method stub
		if(col == n) {
			List<String> ds = new ArrayList<>();
			for(int i =0;i<n;i++) {
				StringBuffer sb = new StringBuffer();
				for(int j=0;j<n;j++) {
					sb.append(board[i][j]);
				}
				ds.add(sb.toString());
			}
			ans.add(ds);
		}
		
		
		for(int row=0;row<n;row++) {
			if(leftRow[row]==0 && lowerDiagonal[row+col]==0 && 
					upperDiagonal[n-1+col-row]==0) {
				leftRow[row] = 1;
				lowerDiagonal[row+col] = 1;
				upperDiagonal[n-1+col-row] = 1;
				board[row][col] = 'Q';
				nQueens(col+1, n, board, leftRow, lowerDiagonal, upperDiagonal, ans);
				leftRow[row] = 0;
				lowerDiagonal[row+col] = 0;
				upperDiagonal[n-1+col-row] = 0;
				board[row][col] = '.';
			}
		}
	}

}
