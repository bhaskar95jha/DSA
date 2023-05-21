package striverRecursion;

import java.util.Scanner;

public class FibonacciNumber_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = fibonacci(n);
		System.out.println(ans);
		sc.close();
	}

	private static int fibonacci(int n) {
		// TODO Auto-generated method stub
		if(n<=2) {
			return 1;
		}
		
		return fibonacci(n-1) + fibonacci(n-2); 
	}

}
