package AlgoUArray;

import java.util.Scanner;

public class SquareSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//input :- {-3,-1,0,2,5} - this is sorted.
		//output :- {0,1,4,9,25}
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		int []nums = new int[n];
		for(int i=0;i<n;i++) {
			nums[i] = sc.nextInt();
		}
		
		//solution -1 tc:- O(log n), asc: O(1)
		
//		for(int i=0;i<n;i++) {
//			nums[i] = nums[i] * nums[i];
//		}
//		
//		Arrays.sort(nums);
//		
//		for(int i=0;i<n;i++) {
//			System.out.print(nums[i]+" ");
//		}
		//solution - 2 tc:- O(n), sc:- O(n)
		//we have some hint like input array is sorted so we can use two pointer algo
		int l = 0;
		int r = n-1;
		int ans[] = new int[n];
		int index = r;
		while(l<=r) {
			if(Math.abs(nums[l])>Math.abs(nums[r])) {
				ans[index--] = nums[l] * nums[l];
				l++;
			}else {
				ans[index--] = nums[r] * nums[r];
				r--;
			}
		}
		for(int i=0;i<n;i++) {
			System.out.print(ans[i]+" ");
		}
		
		sc.close();
		
	}

}
