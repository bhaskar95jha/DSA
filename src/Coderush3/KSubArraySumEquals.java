package Coderush3;


public class KSubArraySumEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {2,5,5,7};
		int k = 3;
		int ans = makeSubKSumEqual(arr,k);
		System.out.println(ans);
	}

	private static int makeSubKSumEqual(int[] arr, int k) {
		// TODO Auto-generated method stub
		int n = arr.length;
		int ans[] = new int[n];
		for(int i=0;i<n;i++) {
			int sum = 0;
			
			for(int j=i;j<i+k;j++) {
				int index = j%n;
				sum += arr[index];
			}
			ans[i] = sum;
		}
		int sum  = 0;
		for(int ele:ans) {
			sum += ele;
		}
		int num1 = sum/n;
		int num2 = num1+1;
		int ret1 = 0;
		for(int ele:ans) {
			ret1 += ele>num1?ele-num1:num1-ele;
		}
		int ret2 = 0;
		for(int ele:ans) {
			ret2 += ele>num2?ele-num2:num2-ele;
		}
		
		return ret1<ret2?ret1:ret2;
		
	}

}
