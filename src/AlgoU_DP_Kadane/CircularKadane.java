package AlgoU_DP_Kadane;

import java.io.*;
import java.util.StringTokenizer;

public class CircularKadane {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		int ans = 0;
		int originalKadane = maxSubArraySum(arr);
		int reverseKadane = minSubArraySum(arr);
		//System.out.println(originalKadane+" "+reverseKadane+" "+sum);
		if(sum == reverseKadane)
			ans = maxSubArraySum(arr);
		else
			ans = Math.max(originalKadane, sum -reverseKadane);
		System.out.println(ans);
	}

	private static int minSubArraySum(int[] arr) {
		// TODO Auto-generated method stub
		int dp[] = new int[arr.length];
		dp[0] = arr[0];
		int prev = dp[0];
		int ans = prev;
		for(int i=1;i<arr.length;i++) {
			prev = Math.min(prev+arr[i],arr[i]);
			ans = Math.min(ans, prev);
		}
		return ans;
	}

	private static int maxSubArraySum(int[] arr) {
		// TODO Auto-generated method stub
		int dp[] = new int[arr.length];
		dp[0] = arr[0];
		int prev = dp[0];
		int ans = prev;
		for(int i=1;i<arr.length;i++) {
			prev = Math.max(prev+arr[i],arr[i]);
			ans = Math.max(ans, prev);
		}
		return ans;
	}

}
