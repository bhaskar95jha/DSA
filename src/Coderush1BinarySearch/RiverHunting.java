package Coderush1BinarySearch;

import java.util.Scanner;

public class RiverHunting {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		while(q-- > 0) {
			int n = sc.nextInt();
			int l = 0;
			int r = n;
			while(l+1 < r) {
				int mid = l + (r-l)/2;
				if(Math.pow(2, mid)<n) {
					l = mid;
				}else {
					r = mid;
				}
			}
			System.out.println(r);
		}
		sc.close();
	}
}
