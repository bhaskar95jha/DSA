package AlgoUBinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MatrixBinarySearch {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int j = 0;
			while(st.hasMoreTokens()) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				j += 1;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreElements()) {
			int y = 0,z=0;
			out:
			while(y<n && z<m) {
				if(target>arr[y][m-1]) {
					y += 1;
				}else{
					while(z<m) {
						if(arr[y][z]<target) {
							z += 1;
						}else {
							System.out.println("YES");
							break out;
						}
					}
				}
			}
			System.out.println("NO");
		}
	
	}

}
