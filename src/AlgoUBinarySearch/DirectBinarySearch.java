package AlgoUBinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DirectBinarySearch {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		int i = 0;
		st = new StringTokenizer(br.readLine()," ");
		while(st.hasMoreTokens()) {
			arr[i++] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		while(st.hasMoreElements()) {
			int target = Integer.parseInt(st.nextToken());
			int l = -1;
			int r = n;
			
			while(l+1<r) {
				int m = l + (r-l)/2;
				if(predicate(arr[m],target)==0) {
					l = m;
				}else {
					r = m;
				}
			}
			System.out.println(r);
		}
	}

	private static int predicate(int nums, int target) {
		if(nums<target)
			return 0;
		else
			return 1;
	}

}
