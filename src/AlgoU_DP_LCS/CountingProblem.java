 package AlgoU_DP_LCS;

import java.io.*;
import java.util.StringTokenizer;

public class CountingProblem {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		st = new StringTokenizer(br.readLine());
		String t = st.nextToken();
		
		int ans = count(s.length(),t.length(),s,t);
		System.out.println(ans);
	}

	private static int count(int i, int j, String s, String t) {
		
		if(j<=0)
			return 1;
		if(i<=0)
			return 0;
		
		if(s.charAt(i-1) == t.charAt(j-1)) {
			return count(i-1,j,s,t)+count(i-1,j-1,s,t);
		}else {
			return count(i-1,j,s,t);
		}
	}

}
