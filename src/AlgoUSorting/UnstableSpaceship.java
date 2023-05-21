package AlgoUSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UnstableSpaceship {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = 2*x;
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(arr);
		List<int[]> li = new ArrayList<>();
		li = Arrays.asList(arr);
	}

}
