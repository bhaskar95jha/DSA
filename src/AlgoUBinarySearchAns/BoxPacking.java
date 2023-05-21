package AlgoUBinarySearchAns;

import java.util.Scanner;

public class BoxPacking {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			long n = sc.nextInt();
			long l = 1;
			long r = Math.max(w, h)*n;
			while(l+1 < r) {
				long m = l + (r-l)/2;
				if(predicate(m,w,h,n)==0) {
					l = m;
				}else {
					r = m;
				}
			}
			System.out.println(r);
			
		}
		
		sc.close();
	}

	private static int predicate(long mid, int w, int h, long n) {
		// TODO Auto-generated method stub
		long count1 = mid/w;
		long count2 = mid/h;
		//total count >= n then return 1 otherwise 0  
		if(count1 != 0 && Math.ceil(((double)n/count1)) <= count2) {
			return 1;
		}else {
			return 0;
		}
	}
	
}





