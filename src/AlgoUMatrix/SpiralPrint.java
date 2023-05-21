package AlgoUMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralPrint {

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
		
		List<Integer> ans = spiralPrint(matrix,n,m);
		for (int  ele: ans) {
			System.out.print(ele+" ");
		}
		
	}

	private static List<Integer> spiralPrint(int[][] matrix, int n, int m) {
		
		List<Integer> ans = new ArrayList<>();
		int top = 0;
		int bottom = n-1;
		int left = 0;
		int right = m-1;
		int dir = 0;
		while(left <= right && top <= bottom) {
			if(dir==0) {
				for(int i=left;i<=right;i++) {
					ans.add(matrix[top][i]);
				}
				top++;
				dir = 1;
			}else if(dir==1){
				for(int i=top;i<=bottom;i++) {
					ans.add(matrix[i][right]);
				}
				right--;
				dir = 2;
			}else if(dir==2){
				for(int i=right;i>=left;i--) {
					ans.add(matrix[bottom][i]);
				}
				bottom--;
				dir = 3;
			}else if(dir==3){
				for(int i=bottom;i>=top;i--) {
					ans.add(matrix[i][left]);
				}
				left++;
				dir = 0;
			}
		}
		return ans;
	}

}
