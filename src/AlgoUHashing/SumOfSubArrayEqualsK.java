package AlgoUHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SumOfSubArrayEqualsK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		for(int i=1;i<n;i++) {
			arr[i] += arr[i-1];
		}
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int ele:arr) {
			if(map.containsKey(ele-k)) {
				System.out.println("Yes It exists");
				return;
			}
			System.out.println(ele);
			map.put(ele, ele);
		}
		System.out.println("Not Exist");
	}

}
