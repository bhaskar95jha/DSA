package AlgoU_DP_LCS;

import java.io.*;
import java.util.StringTokenizer;

public class LPSRecursion { 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		
		String t = new StringBuilder(s).reverse().toString();
		
		System.out.println(t);
		int ans = lcs(s.length()-1,t.length()-1,s,t);
		System.out.println(ans);
	}

	private static int lcs(int i, int j, String s, String t) {
		
		if(i<0 || j<0)
			return 0;
		if(s.charAt(i) == t.charAt(j)) {
			return 1 + lcs(i-1,j-1,s,t);
		}else {
			return Math.max(lcs(i,j-1,s,t), lcs(i-1,j,s,t));
		}
		
	}

}
