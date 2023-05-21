package Coderush3;

import java.util.*;

public class SmallestNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums1[] = {3,5,2,6};
		int nums2[] = {3,1,7};
		int ans = minNumber(nums1,nums2);
		System.out.println(ans);
	}

	private static int minNumber(int[] nums1, int[] nums2) {
		// TODO Auto-generated method stub
		
		HashSet<Integer> hs = new HashSet<>();
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		for(int i=0;i<nums1.length;i++) {
			hs.add(nums1[i]);
			min1 = Math.min(nums1[i], min1);
		}
		for(int i=0;i<nums2.length;i++) {
			if(hs.contains(nums2[i])) {
				return nums2[i];
			}
			hs.add(nums2[i]);
			min2 = Math.min(nums2[i], min2);
		}
		
		int ans = min1<min2?10*min1+min2:10*min2+min1;
		
		return ans;
		
		
	}

}
