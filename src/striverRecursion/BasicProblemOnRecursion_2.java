package striverRecursion;

public class BasicProblemOnRecursion_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		System.out.println("Name N times");
		printNameByUsingRecursion(1,5);
		System.out.println("print 1 to N");
		print1ToNUsingRecursion(1,n);
		System.out.println("print N to 1");
		printNTo1UsingRecursion(n,n);
		System.out.println("print 1 to N by backtracking");
		print1ToNUsingBacktracking(n,n);
		System.out.println("print N to 1 by backtracking");
		printNTo1UsingBacktracking(1,n);
	}

	private static void printNTo1UsingBacktracking(int i, int n) {
		// TODO Auto-generated method stub
		if(i>n)
			return;
		printNTo1UsingBacktracking(i+1,n);
		System.out.println(i);
	}

	private static void print1ToNUsingBacktracking(int i, int n) {
		// TODO Auto-generated method stub
		if(i<1)
			return;
		print1ToNUsingBacktracking(i-1,n);
		System.out.println(i);
	}

	private static void printNTo1UsingRecursion(int i, int n) {
		// TODO Auto-generated method stub
		if(i<1) {
			return;
		}
		System.out.println(i);
		printNTo1UsingRecursion(i-1,n);
	}

	private static void print1ToNUsingRecursion(int i, int n) {
		// TODO Auto-generated method stub
		if(i>n)
			return;
		System.out.println(i);
		print1ToNUsingRecursion(i+1, n);
	}

	private static void printNameByUsingRecursion(int i, int j) {
		// TODO Auto-generated method stub
		if(i>j)
			return;
		System.out.println("Bhaskar");
		printNameByUsingRecursion(i+1, j);
	}

}
