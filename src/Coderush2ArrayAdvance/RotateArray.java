package Coderush2ArrayAdvance;

import java.util.Scanner;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		if(n!=k)
			rotate(arr,k);
		
		
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
		System.out.println();
	}
	
	
	public static void reverse(int[] nums,int a,int b){
        while(a<b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
            a++;
            b--;
        }
    }
	
	
	public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
    }

}


