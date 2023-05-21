package TJOBinarySearch;

import java.util.Scanner;

public class PrintString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int d = sc.nextInt();
		int sum = sc.nextInt();
		solve(0,s.toCharArray(),d,sum);
	}

	private static void solve(int ind,char[] s, int d, int sum) {
		// TODO Auto-generated method stub
		
		if(sum<0) {
			return;
		}
		
		if(ind == s.length) {
			if(sum == 0) {
				System.out.println(String.valueOf(s));
			}
			return;
		}
		
		if(s[ind] != '?') {
			solve(ind+1,s,d,sum-(s[ind]-'0'));
		}else {
			for(int i=0;i<=d;i++) {
				s[ind] = (char) (i+48);
				solve(ind+1,s,d,sum-i);
				s[ind] = '?';
			}
		}
		
	}

}
