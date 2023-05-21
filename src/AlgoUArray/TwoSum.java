package AlgoUArray;

import java.util.Scanner;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//input - {1,5,7,8,12}, target - 15 
		//output - yes
		
		//solution -1 by using two pointer algo (TC- O(n), asc-O(1)
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int target = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;i++) {
			nums[i] = sc.nextInt();
		}
		
		int l = 0;
		int r = n-1;
		while(l<r) {
			if(nums[l]+nums[r]>target) {
				r--;
			}else if(nums[l]+nums[r]<target) {
				l++;
			}else {
				System.out.print(true);
				break;
			}
		}
		if(l>=r) {
			System.out.println(false);
		}
		sc.close();
		
	}

}
