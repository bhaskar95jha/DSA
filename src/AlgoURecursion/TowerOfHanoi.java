package AlgoURecursion;

import java.io.*;
import java.util.*;

public class TowerOfHanoi {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int s = 1;
		int d = 2;
		int h = 3;
		List<String> li = new ArrayList<>();
		solve(n,s,d,h,li);
		System.out.println(li.size());
		li.stream().forEach(System.out::println);
	}

	private static void solve(int n, int s, int d, int h, List<String> li) {
		if(n==1) {
			li.add(n+" "+s+" "+d);
			return;
		}
		solve(n-1, s, h, d,li);
		li.add(n+" "+s+" "+d);
		solve(n-1, h, d, s,li);
	}
}
