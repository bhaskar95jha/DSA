package AlgoUAdvanceArrayAndMatrix;

import java.util.Scanner;

public class TableLookup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int target = sc.nextInt();
		int arr[][] = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		int i = 0, j = m-1;
		while(i>=0 && i<n && j>=0 && j<m) {
			if(arr[i][j]==target) {
				System.out.println("YES");
				return;
			}else if(arr[i][j]<target) {
				i++;
			}else {
				j--;
			}
		}
		
		System.out.println("NO");
	}

}


