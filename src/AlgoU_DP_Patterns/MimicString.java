package AlgoU_DP_Patterns;

import java.io.*;
import java.util.StringTokenizer;

public class MimicString {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int slen =  Integer.parseInt(st.nextToken());
			int tlen = Integer.parseInt(st.nextToken());
			String first = br.readLine().toLowerCase();
			String second = br.readLine().toLowerCase();
			//System.out.println(first+" "+second);
			int dp[][] = new int[slen+1][tlen+1];
			for(int i=0;i<=slen;i++) {
				dp[i][0] = i;
			}
			for(int j=0;j<=tlen;j++) {
				dp[0][j] = j;
			}
			
			for(int i=1;i<=slen;i++) {
				for(int j=1;j<=tlen;j++) {
					if(first.charAt(i-1)==second.charAt(j-1)) {
						dp[i][j] = dp[i-1][j-1];
					}else {
						dp[i][j] = 1 + Math.min(dp[i][j-1],Math.min( dp[i-1][j-1], dp[i-1][j])) ;
					}
				}
			}
			
			System.out.println(dp[slen][tlen]);
		}
	}
}
