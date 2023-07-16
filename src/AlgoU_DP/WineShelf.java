package AlgoU_DP;

import java.io.*;
import java.util.*;

public class WineShelf {
	public static final int MOD = 1000000000+7;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int wineBottle[] = new int[n];
		st = new StringTokenizer(br.readLine());
		 
		int dp[][] = new int[n+1][n+1];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				dp[i][j] = -1;
			}
		}
		
		for(int i=0;i<n;i++) {
			wineBottle[i] = Integer.parseInt(st.nextToken());
		}
		
		int l = 0, r = n-1;
		int ans = solve(l,r,wineBottle,n,dp);
		System.out.println(ans);
		
		
	}
	private static int solve(int l, int r, int[] wineBottle,int n, int[][] dp) {
		if(dp[l][r]!=-1) {
			return dp[l][r];
		}
		
		int y = n-(r-l);
		
		if(l==r)
			return dp[l][r] =  n * wineBottle[l];
		
		int first =  wineBottle[l]*y + solve(l+1,r,wineBottle,n,dp)%MOD;
		int second = wineBottle[r]*y + solve(l,r-1,wineBottle,n,dp)%MOD;
		
		return dp[l][r] = Math.max(first,second);
	}

}
