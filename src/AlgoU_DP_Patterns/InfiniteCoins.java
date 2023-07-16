package AlgoU_DP_Patterns;

import java.io.*;
import java.util.StringTokenizer;

public class InfiniteCoins {

	public static void main(String[] args) throws IOException {
		// Take/Not Take Patterns
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int sum = Integer.parseInt(st.nextToken());
		
		int coins[] = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[][] = new int[n+1][sum+1];
		for(int i=0;i<n;i++) {
			for(int j=0;j<sum;j++) {
				dp[i][j] = -1;
			}
		}
		 
		int ans = getCount(coins,n,sum,0,dp);
		System.out.println(ans);
		
	}

	private static int getCount(int[] coins, int n, int sum, int count,int [][]dp) {
		
		if (dp[n][sum] != -1) {
	        return dp[n][sum];
	    }
		
		if(sum==0) {
			return dp[n][sum] = 1;
		}
		
		if(n==0) {
			return dp[n][sum] = 0;
		}
		//not take
		count = getCount(coins, n-1, sum, count,dp);
		
		//take
		if(sum >= coins[n-1])
			count += getCount(coins, n, sum-coins[n-1], count, dp);
		
		dp[n][sum] = count;
		return count;
	}

}
