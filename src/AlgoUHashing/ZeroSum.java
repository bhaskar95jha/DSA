package AlgoUHashing;

import java.util.HashMap;
import java.util.Scanner;

public class ZeroSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=1;i<n;i++) {
			arr[i] += arr[i-1];
		}
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int ele:arr) {
			if(ele == 0 || hm.containsKey(ele-0)) {
				System.out.println("Yes");
				return;
			}
			hm.put(ele,ele);
		}
		System.out.println("NO");
	}

}
