package AlgoUHashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UnionArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int arr1[] = new int[n];
		int arr2[] = new int[m];
		
		Map<Integer, Integer> hm = new HashMap<>();
		
		for(int i=0;i<n;i++) {
			arr1[i] = sc.nextInt();
			hm.putIfAbsent(arr1[i], 1);
		}
		for(int i=0;i<m;i++) {
			arr2[i] = sc.nextInt();
			hm.putIfAbsent(arr2[i], 2);
		}
		
		sc.close();
		
		List<Integer> al = new ArrayList<>();
		for(int ele:hm.keySet()) {
			al.add(ele);
		}
		
		Collections.sort(al);
		
		for(int ele:al) {
			System.out.print(ele+" ");
		}
		
		
	}

}
