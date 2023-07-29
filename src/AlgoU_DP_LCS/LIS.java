package AlgoU_DP_LCS;

import java.io.*;
import java.util.StringTokenizer;

public class LIS { 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[n];
		int dp[] = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++) {
			dp[i] = 1;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[i], 1+dp[j]);
				}
			}
		}
		
		
			System.out.print(dp[n-1]+" ");
		
		
		
	}
}
