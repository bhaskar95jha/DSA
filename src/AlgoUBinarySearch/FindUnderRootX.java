package AlgoUBinarySearch;

import java.util.Scanner;

public class FindUnderRootX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		double l = 0;
		double r = x;
		int steps = 150;
		while(steps-- > 0) {
			double m = l + (r-l)/2;
			if(predicate(m,x)==0) {
				l = m;
			}else {
				r = m;
			}
		}
		System.out.printf("%.10f",l);
	}

	private static int predicate(double m, long x) {
		// TODO Auto-generated method stub
		if(m*m>x)
			return 1;
		else
			return 0;
	}

}
