package AlgoUArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TreasureRoomV1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//solution 1 - TC- O(n^2)
		
		//solution 2 - TC -O(n), sc- O(n)
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int target = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;i++) {
			nums[i] = sc.nextInt();
		}
		Map<Integer, Integer> numIndex = new HashMap<>();
		for(int i=0;i<n;i++) {
			numIndex.putIfAbsent(nums[i], i);
		}
		int i=0;
		for(i=0;i<n;i++) {
			numIndex.remove(nums[i]);
			if(numIndex.containsKey(target-nums[i])) {
				System.out.println((i+1)+" "+(numIndex.get(target-nums[i])+1));
				return;
			}
		}
		System.out.println(-1);
		
		sc.close();
	}

}
