package interviewbit.binarysearch;

import java.util.*;

public class HigherProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {-1,-2,3,-4,5};
		Arrays.sort(arr);
		int l = 0;
		int r = arr.length-1;
		int count = 0;
		int ans = 1;
		while(count<3 && l<=r) {
			if(count<2 && Math.abs(arr[l])>Math.abs(arr[r])) {
				int x = arr[l];
				l++;
				if(Math.abs(arr[l])>Math.abs(arr[r])) {
					ans = ans *(x) * arr[l];
					l++;
					count += 2;
				}
			}else {
				ans *= arr[r];
				r--;
				count++;
			}
		}
		System.out.println(ans);
		
	}

}
