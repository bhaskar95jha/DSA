package AlgoUBinarySearchAns;

import java.util.Scanner;

public class MaxIOnGivenN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long l = 0;
		long r = (long) Math.pow(2*n,0.5)+1;
		while(l+1<r) {
			long m = l + (r-l)/2;
			if(predicate(m,n)==0) {
				l = m;
			}else {
				r = m;
			}
		}
		System.out.println(l);
		
	}

	private static int predicate(long m, long n) {
		// TODO Auto-generated method stub
		long sum = m * (m+1)/2;
		if(sum<=n)
			return 0;
		else
			return 1;
	}

}
