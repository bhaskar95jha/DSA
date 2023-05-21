package Coderush3;

import java.util.Scanner;

public class PrimeCycles {
	static int ans = 0;
	static boolean []primeTable = new boolean[50];
	static boolean []checked = new boolean[50];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = primeCycleCount(n);
		System.out.println(ans);
	}

	private static int primeCycleCount(int n) {
		// TODO Auto-generated method stub
		checkPrime(2 * n);
		for (int i = 0; i <n; i += 1) {
			checked[i]=false;
		}
		checked[1] = true;
		count(n-1, n, 1, 1);
		return ans;
		
	}

	private static void count(int m, int n, int p, int k) {
		// TODO Auto-generated method stub
		if (m==0) {
			if (primeTable[p + 1]) {
				ans++;
			}
			return;
		}
	
		for (int i = 1 + k; i <= n; i++) {
			if (!checked[i] && primeTable[i+p]) {
				checked[i] = true;
				count(m-1, n, i, 1-k);
				checked[i] = false;
			}
		}
	}

	private static void checkPrime(int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i <primeTable.length; i += 1) {
			primeTable[i]=true;
		}
		for (int p = 2; p*p <= n; p++) {	
			if (primeTable[p] == true) {
				for (int i = p*p; i<=n; i+=p)
					primeTable[i] = false;
			}
		}	
	}
}



