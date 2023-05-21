package AlgoUArray;

import java.util.Arrays;
import java.util.Scanner;

public class ClosestRefuge {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nums[] = new int[n];
		for(int i=0;i<n;i++) {
			nums[i] = sc.nextInt();
		}
		
		//count array to solve this one
		//solution - 1 tc- o(n logn)
		//by using linear search but a/c to question it'll not solve in o(n logn).
		//we have to use binary search and first sort this array.
		
		Arrays.sort(nums);
		
		int s = 1;
		int e = nums[n-1]+1;
		int i = s;
		
		for(i=s;i<=e;i++) {
			int l = 0;
			int r = n-1;
			while(l<=r) {
				int mid = l + (r-l)/2;
				if(i == nums[mid]) {
					break;
				}else if(nums[mid]<i) {
					
					l = mid + 1;
				}else {
					r = mid -1;
				}
			}
			if(l>r) {
				System.out.println(i);
				break;
			}
		}
		sc.close();
	}

}
