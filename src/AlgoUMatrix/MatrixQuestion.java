package AlgoUMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * spiralPrint
 * printInWaveOrder
 * largestRowSum
 * rowWiseSum
 * linearSearch
 * 
 * */

public class MatrixQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] matrix = new int[3][3];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		int target = sc.nextInt();
		boolean find = linearSearch(matrix,target);
		System.out.println("Target "+ target + " found "+find);
		List<Integer> sum = rowWiseSum(matrix);
		sum.stream().forEach(System.out::println);
		int largeRow = largestRowSum(matrix);
		System.out.println("Largest row is "+(largeRow+1));
		printInWaveOrder(matrix);
		spiralPrint(matrix);
		sc.close();
	}

	private static void spiralPrint(int[][] matrix) {
		// TODO Auto-generated method stub
		List<Integer> spiral = new ArrayList<>();
		int top = 0;
		int bot = matrix.length-1;
		int left = 0;
		int right = -1;
		if(bot>=0)
			right = matrix[0].length-1;
		int dir = 0;
		while(left<=right && top<=bot) {
			switch (dir) {
				case 0: {
					for(int i=left;i<=right;i++) {
						spiral.add(matrix[top][i]);
					}
					dir = 1;
					top++;
				}case 1:{
					for(int i=top;i<=bot;i++) {
						spiral.add(matrix[i][right]);
					}
					dir = 2;
					right--;
				}case 2:{
					for(int i=right;i>=left;i--) {
						spiral.add(matrix[bot][i]);
					}
					dir = 3;
					bot--;
				}case 3:{
					for(int i=bot;i>=top;i--) {
						spiral.add(matrix[i][left]);
					}
					dir = 0;
					left++;
				}
			}
		}
		spiral.stream().forEach(System.out::print);
	}

	private static void printInWaveOrder(int[][] matrix) {
		// TODO Auto-generated method stub
		for(int col=0;col<matrix[0].length;col++) {
			if(col%2==1) {
				for(int row=matrix.length-1;row>=0;row--) {
					System.out.print(matrix[row][col]+" ");
				}
			}else {
				for(int row=0;row<matrix.length;row++) {
					System.out.print(matrix[row][col]+" ");
				}
			}
			System.out.println();
		}
		
		
	}

	private static int largestRowSum(int[][] matrix) {
		int maxSum = 0;
		int index = -1;
		for(int i=0;i<matrix.length;i++) {
			int rowSum = 0;
			for(int j=0;j<matrix[i].length;j++) {
				rowSum += matrix[i][j];
			}
			if(rowSum>maxSum) {
				maxSum = rowSum;
				index = i;
			}
			
		}
		return index;
	}

	private static List<Integer> rowWiseSum(int[][] matrix) {
		List<Integer> sum = new ArrayList<>();
		for(int i=0;i<matrix.length;i++) {
			int rowSum = 0;
			for(int j=0;j<matrix[i].length;j++) {
				rowSum += matrix[i][j];
			}
			sum.add(rowSum);
			rowSum = 0;
		}
		return sum;
	}

	private static boolean linearSearch(int[][] matrix, int target) {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				if(matrix[i][j]==target) {
					return true;
				}
			}
		}
		return false;
	}
	

}
