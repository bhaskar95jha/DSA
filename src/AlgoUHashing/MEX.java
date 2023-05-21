package AlgoUHashing;

import java.util.HashMap;
import java.util.Scanner;

public class MEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		HashMap<Integer,Integer> hm = new HashMap<>();
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			hm.put(arr[i], i);
		}
		
		sc.close();
		
		for(int i=1;i<Integer.MAX_VALUE;i++) {
			if(!hm.containsKey(i)) {
				System.out.println(i);
				return;
			}
		}
		
	}
	
}
