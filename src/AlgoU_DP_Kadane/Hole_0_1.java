package AlgoU_DP_Kadane;

import java.io.*;
import java.util.StringTokenizer;

public class Hole_0_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int originalKadane = maxSubArraySum(arr);
		int ltor_maxSumSubarray[] = prevLtoR(arr);
		int rtol_maxSumSubarray[] = prevRtoL(arr);
		int val = -1;
		int ans = Integer.MIN_VALUE;
		for(int hole=0;hole<n;hole++) {
			if(hole==0) {
				val = rtol_maxSumSubarray[hole+1];
			}else if(hole==n-1) {
				val = ltor_maxSumSubarray[hole-1];
			}else {
				if(ltor_maxSumSubarray[hole-1]>0 && rtol_maxSumSubarray[hole+1]>0)
					val = ltor_maxSumSubarray[hole-1]+rtol_maxSumSubarray[hole+1];
				else {
					val = ltor_maxSumSubarray[hole-1]>0?ltor_maxSumSubarray[hole-1]:rtol_maxSumSubarray[hole+1];
				}
			}
			ans = Math.max(ans, val);
		}
		System.out.println(Math.max(originalKadane, ans));
		
	}

	private static int[] prevRtoL(int[] arr) {
		int n = arr.length;
		int prevRtoL[] = new int[arr.length];
		prevRtoL[n-1] = arr[n-1];
		int prev = prevRtoL[n-1];
		for(int i=n-2;i>=0;i--) {
			prev = Math.max(prev+arr[i],arr[i]);
			prevRtoL[i] = prev;
		}
		return prevRtoL;
	}

	private static int[] prevLtoR(int[] arr) {
		// TODO Auto-generated method stub
		int prevLtoR[] = new int[arr.length];
		prevLtoR[0] = arr[0];
		int prev = prevLtoR[0];
		for(int i=1;i<arr.length;i++) {
			prev = Math.max(prev+arr[i],arr[i]);
			prevLtoR[i] = prev;
		}
		return prevLtoR;
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
