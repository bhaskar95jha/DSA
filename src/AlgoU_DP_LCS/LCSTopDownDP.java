package AlgoU_DP_LCS;

import java.io.*;
import java.util.StringTokenizer;

public class LCSTopDownDP { 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		st = new StringTokenizer(br.readLine());
		String t = st.nextToken();
		int dp[][] = new int[s.length()+1][t.length()+1];
		int ans = lcs(s.length(),t.length(),s,t,dp);
		System.out.println(ans);
		//just print the dp table
		for(int i=0;i<s.length()+1;i++) {
			for(int j=0;j<t.length()+1;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static int lcs(int i, int j, String s, String t, int[][] dp) {
		
		if(i==0 || j==0)
			return dp[i][j] = 0;
		if(s.charAt(i-1) == t.charAt(j-1)) {
			return dp[i][j] = 1 + lcs(i-1,j-1,s,t,dp);
		}else {
			return dp[i][j] = Math.max(lcs(i,j-1,s,t,dp), lcs(i-1,j,s,t,dp));
		}
		
	}

}
