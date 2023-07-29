package AlgoU_DP_LCS;

import java.io.*;
import java.util.StringTokenizer;

public class LCSBottomUp { 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		st = new StringTokenizer(br.readLine());
		String t = st.nextToken();
		int dp[][] = new int[s.length()+1][t.length()+1];
		
		for(int i=0;i<s.length()+1;i++) {
			for(int j=0;j<t.length()+1;j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}
				else {
					if(s.charAt(i-1)==t.charAt(j-1)) {
						dp[i][j] = 1+dp[i-1][j-1];
					}else {
						dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
					}
				}
			}
		}
		
		System.out.println(dp[s.length()][t.length()]);
		
	}
}
