package striverRecursion;

public class SudokuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][]board = new char[9][9];
		solve(board);
	}

	private static boolean solve(char[][] board) {
		// TODO Auto-generated method stub
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]=='.') {
					for(char c='1';c<='9';c++) {
						if(isValid(board,c,i,j)) {
							board[i][j] = c;
							
							if(solve(board)==true) {
								return true;
							}else {
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isValid(char[][] board, char c, int row, int col) {
		// TODO Auto-generated method stub
		for(int i=0;i<9;i++) {
			if(board[row][i]==c)
				return false;
			if(board[i][col]==c)
				return false;
			if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c)
				return false;
		}
		return true;
	}

}
