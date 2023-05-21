package Coderush3;

import java.util.*;

public class EqualZeroOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int ans = countZeroOne(arr);
		System.out.println(ans);
	}
	
	 public static int countZeroOne(int[] a) {
	        HashMap<Integer, Integer> zeroOneCount = new HashMap<>();
	        zeroOneCount.put(0, 1); // initialize the count of 0 and 1 to be 0
	        int countSum = 0;
	        int ans = 0;
	        for (int i = 0; i < a.length; i++) {
	            if (a[i] == 0) {
	                countSum -= 1;
	            } else {
	                countSum += 1;
	            }
	            if (zeroOneCount.containsKey(countSum)) {
	                ans += zeroOneCount.get(countSum);
	                zeroOneCount.put(countSum, zeroOneCount.get(countSum) + 1);
	            } else {
	                zeroOneCount.put(countSum, 1);
	            }
	        }
	        return ans;
	    }

}




