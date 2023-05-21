package AlgoUArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TreasureRoomV2 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int target = sc.nextInt();
		int[] nums = new int[n];
		Map<Integer,Integer> numIndex = new HashMap<>();
		for(int i=0;i<n;i++) {
			nums[i] = sc.nextInt();
			numIndex.putIfAbsent(nums[i], i);
		}
		int i=0;
		out:
		for(i=0;i<n-2;i++) {
			int firstKey = nums[i];
			int firstValue = i;
			numIndex.remove(nums[i]);
			for(int j=i+1;j<n-1;j++) {
				int secondKey = nums[j];
				int seconValue = j;
				numIndex.remove(nums[j]);
				if(numIndex.containsKey(target-(firstKey+secondKey))) {
					numIndex.put(secondKey, seconValue);
					System.out.println((firstValue+1)+" "+(seconValue+1)+" "+(numIndex.get(target-(firstKey+secondKey))+1));
					break out;
				}
			}
			numIndex.put(firstKey, firstValue);
		}
		if(i==(n-2)) {
			System.out.println(-1);
		}
		sc.close();
	}
	

}
