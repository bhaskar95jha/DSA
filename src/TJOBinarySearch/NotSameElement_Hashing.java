package TJOBinarySearch;

import java.util.*;

public class NotSameElement_Hashing {
  public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashMap<Integer,Integer> map = new HashMap<>();
		HashSet<Integer> hs = new HashSet<>();
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			hs.add(arr[i]);
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		int m = sc.nextInt();
		int arrm[] = new int[m];
		HashMap<Integer,Integer> map2 = new HashMap<>();
		for(int i=0;i<m;i++) {
			arrm[i] = sc.nextInt();
			if(map.containsKey(arrm[i])) {
				map.remove(arrm[i]);
			}else {
				if(!hs.contains(arrm[i]))
					map2.put(arrm[i], map2.getOrDefault(arrm[i], 0)+1);
			}
		}
		
		int sum = 0;
		for(int value:map.values()) {
			sum += value;
		}
		for(int value:map2.values()) {
			sum += value;
		}
		System.out.println(sum);
		
	}
}
