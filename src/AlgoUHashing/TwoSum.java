package AlgoUHashing;

import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		checkTwoSum(arr,x);
	}

	private static void checkTwoSum(int[] arr, int x) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> map = new HashMap<>();
		int index = 0;
		for(int ele:arr) {
			if(map.containsKey(x-ele)) {
				System.out.println((map.get(x-ele)+1)+" "+(index+1));
				return;
			}
			map.put(ele, index);
			index++;
		}
		System.out.println(-1);
	}

}
