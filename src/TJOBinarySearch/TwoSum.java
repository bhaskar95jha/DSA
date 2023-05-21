package TJOBinarySearch;

import java.util.*;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int i = 0;
		int j = n-1;
		while(i<j) {
			if(arr[i]+arr[j]<k) {
				i++;
			}else if(arr[i]+arr[j]>k) {
				j--;
			}else {
				System.out.println(arr[i]+" "+arr[j]);
				break;
			}
		}
		
	}

}
