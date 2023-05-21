package TheJobOverflow;

//import java.util.Scanner;
//
//public class TravelerFund {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();
//		while(t-->0) {
//			int n = sc.nextInt();
//			long arr[] = new long[n];
//			for(int i=0;i<n;i++) {
//				arr[i] = sc.nextLong();
//			}
//			long l = 0;
//			long r = Long.MAX_VALUE;
//			while(l<=r) {
//				long m = l + (r-l)/2;
//				long sum = m;
//				int i = 0;
//				for(i = 0;i<n;i++) {
//					if(sum+arr[i]<=0) {
//						l = m+1;
//						break;
//					}
//					sum += arr[i];
//				}
//				if(i == n) {
//					r = m-1;
//				}
//			}
//			System.out.println(l);
//			
//		}
//		
//	}
//
//}


import java.util.Scanner;

public class TravelerFund  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			long arr[] = new long[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextLong();
			}
			long l = 0;
			long r = Long.MAX_VALUE;
			
			while(l<r-1){
			  long mid = l + (r-l)/2;
			  if(predicate(arr,mid)==0){
			    l = mid;
			  }else{
			    r = mid;
			  }
			}
			System.out.println(l);
		}
		
		
		
	}
	
	private static int predicate(long []arr,long amount){
		  
		  for(long ele:arr){
		    if(ele+amount<=1){
		      return 0;
		    }
		    amount += ele;
		  }
		  return 1;
		}

}

