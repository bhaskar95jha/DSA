package striverRecursion;

import java.util.Scanner;

public class BasicUnderstanding_1 {
	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		f();
		f(0,n);
	}

	private static void f(int i,int n) {
		// TODO Auto-generated method stub
		if(i==n)
			return;
		System.out.println(i);
		i++;
		f(i,n);
	}

	private static void f() {
		// TODO Auto-generated method stub
		if(count == 4)
			return;
		System.out.println(count);
		count++;
		f();
	}

}
