package AlgoU_DP;

import java.io.*;
import java.util.*;

public class TillingCorridor {
	public static final int MOD = 1000000000+7;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int ansArray[] = new int[n+1];
		Arrays.fill(ansArray, -1);
		int ans = noOfWays(n,ansArray);
		System.out.println(ans);
	}

	private static int noOfWays(int n, int []ansArray) {
		if(n==1 || n==2)
			return ansArray[n] = n;
		
		if(ansArray[n] != -1) {
			return ansArray[n];
		}
		
		return ansArray[n] = (noOfWays(n-1,ansArray) + noOfWays(n-2,ansArray))%MOD;
	}

}
