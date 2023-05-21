package striverRecursion;

public class ParameterAndFunctionalRecursion_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		System.out.println("Print sum of 1 to n in parameterized way");
		parameterRecursion(n,0);
		System.out.println("Print sum of 1 to n in functional way");
		int ans = functional(n);
		System.out.println(ans);
	}

	private static int functional(int n) {
		// TODO Auto-generated method stub
		if(n==0) {
			return 0;
		}
		return n + functional(n-1);
	}

	private static void parameterRecursion(int n, int sum) {
		// TODO Auto-generated method stub
		if(n==0) {
			System.out.println(sum);
			return;
		}
		parameterRecursion(n-1,n+sum);
	}

}
