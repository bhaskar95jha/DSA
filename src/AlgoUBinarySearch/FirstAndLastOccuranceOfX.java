package AlgoUBinarySearch;

import java.util.Scanner;

public class FirstAndLastOccuranceOfX {

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int q = sc.nextInt();
		int []arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		while(q-- > 0) {
			int x = sc.nextInt();
			int l = -1;
			int r = n;
			while(l+1 < r) {
				int m = l + (r-l)/2;
				if(predicateFirst(arr[m],x)==0) {
					l = m;
				}else {
					r = m;
				}
			}
			int firstOccur = r; 
			
			l = -1;
			r = n;
			while(l+1 < r) {
				int m = l + (r-l)/2;
				if(predicateSecond(arr[m],x)==0) {
					l = m;
				}else {
					r = m;
				}
			}
			int lastOccur = l;
			if(firstOccur<=lastOccur)
				System.out.println(firstOccur+" "+lastOccur);
			else
				System.out.println(-1+" "+-1);
			
		}
	}

	private static int predicateSecond(int num, int x) {
		// TODO Auto-generated method stub
		if(num>x) {
			return 1;
		}
		return 0;
	}

	private static int predicateFirst(int num,int x) {
		
		
		if(num<x) {
			return 0;
		}
		return 1;
		
	}

}
