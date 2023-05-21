package AlgoUArray;

import java.util.Scanner;

public class ChasingTheDragon {
	private static long clockWiseSum(long[] arr,long src, long dest) {
		if(src==dest)
			return 0;
		if(src>dest) {
			long temp = src;
			src = dest;
			dest = temp;
		}
		long sum = 0;
		sum =  (arr[(int) dest] - arr[(int) src]);
		return sum;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long []nums = new long[n];
		for(int i=0;i<n;i++) {
			nums[i] = sc.nextInt();
		}
		
		for(int i=1;i<n;i++) {
			nums[i] += nums[i-1];
		}
		
		int k = sc.nextInt();
		long src = 0;
		long dest = 0;
		for(int i=0;i<k;i++) {
			int ti = sc.nextInt();
			long di = sc.nextLong();	
			di = di % n;
			if(ti == 1) {
				dest =  (src + di);
				dest = dest % n;
			}else {
				if(src>=di) {
					dest =  (src-di);
				}else {
					dest =  (src+n-di);
				}
			}
			long clockwise = clockWiseSum(nums,src,dest);
			
			long antiClockWise = (nums[n-1] - clockwise);
			long ans = Math.min(clockwise, antiClockWise);
			System.out.println(ans);
			src = dest;
		}
		sc.close();
		
	}

}







//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class  {
//	private static int clockWiseSum(int[] arr,int src, int dest) {
//		if(src==dest)
//			return 0;
//		if(src>dest) {
//			int temp = src;
//			src = dest;
//			dest = temp;
//		}
//		int sum = 0;
//		for(int i=src;i<dest;i++)
//			sum += arr[i+1];
//		return sum;
//	}
//	
//
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(
//	            new InputStreamReader(System.in));
//
//		int n = Integer.parseInt(br.readLine());
//		int []nums = new int[n];
//		String line = br.readLine();
//		String[] numsArr = line.trim().split(" "); 
//		for(int i=0;i<n;i++) {
//			nums[i] = Integer.parseInt(numsArr[i]);
//		}
//		
//		int k = Integer.parseInt(br.readLine());
//		int src = 0;
//		int dest = 0;
//		int sum = 0;
//		for(int i=0;i<n;i++) {
//			sum += nums[i];
//		}
//		
//		for(int i=0;i<=k;i++) {
//			String distance = br.readLine();
//			String[] distanceArr = distance.trim().split(" ");
//			int ti = Integer.parseInt(distanceArr[0]);
//			int di = Integer.parseInt(distanceArr[1]);
//			di = di % n;
//			if(ti == 1) {
//				dest = src + di;
//				dest = dest % n;
//			}else {
//				if(src>=di) {
//					dest = src-di;
//				}else {
//					dest = src+n-di;
//				}
//			}
//			int clockwise = clockWiseSum(nums,src,dest);
//			int antiClockWise = sum - clockwise;
//			int ans = Math.min(clockwise, antiClockWise);
//			System.out.println(ans);
//			src = dest;
//		}
//		br.close();
//		
//	}
//
//}


