package Coderush3;

import java.util.*;

public class EasyCounting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char []arr = str.toCharArray();
		Arrays.sort(arr);
		long count = 1;
		long ans = 0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==arr[i-1]) {
				count++;
			}else {
				ans += (count*count);
				count = 1;
			}
		}
		ans += (count*count);
		System.out.println(ans);
	}

}
