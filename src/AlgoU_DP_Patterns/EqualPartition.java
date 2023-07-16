package AlgoU_DP_Patterns;

import java.io.*;
import java.util.StringTokenizer;

public class EqualPartition {
	public static final int MOD = 1000000000+7;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int sum = 0;
			int height[] = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<n;i++) {
				sum += height[i];
			}
			if(sum%2==1) {
				System.out.println("NO");
			}else {
				sum = sum/2;
				
				int dp[][] = new int[sum+1][n+1];
				
				for(int i=0;i<=sum;i++) {
					dp[i][0] = 0;
				}
				
				for(int j=0;j<=n;j++) {
					dp[0][j] = 1;
				}
				
				
				for(int i=1;i<=sum;i++) {
					for(int j=1;j<=n;j++) {
						dp[i][j] = dp[i][j-1];
						if(i>=height[j-1]) {
							dp[i][j] = (dp[i][j] + dp[i-height[j-1]][j-1]);
						}
					}
				}
				if(dp[sum][n]==0)
					System.out.println("NO");
				else
					System.out.println("YES");
			}
		}
	}

}
