package AlgoU_DP_Kadane;

import java.io.*;
import java.util.StringTokenizer;

public class OriginalKadane {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[n];
		
		//base case
		dp[0] = arr[0];
		
		//current subarray sum considering ith element
		int prev = dp[0];
		
		int ans = prev;
		for(int i=1;i<n;i++) {
			//int curr = Math.max(prev+arr[i],arr[i]);
			//prev = curr;
			prev = Math.max(prev+arr[i],arr[i]);
			//maximum subarray sum till ith element
			ans = Math.max(ans, prev);
		}
		
		System.out.println(ans);
	}

}
