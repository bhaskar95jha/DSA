package AlgoU_DP_Patterns;

import java.io.*;
import java.util.StringTokenizer;

public class GoodNumberedChocolates {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int happiness[] = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				happiness[i] = Integer.parseInt(st.nextToken());
			}
			int maxHappiness = maxTotalHappiness(happiness);
	        System.out.println(maxHappiness);
		}
	}
	
	public static int maxTotalHappiness(int[] happiness) {
        int n = happiness.length;
        int[] dp = new int[n + 1];

        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], happiness[j - 1] + dp[i - j]);
            }
        }

        return dp[n];
    }
}
