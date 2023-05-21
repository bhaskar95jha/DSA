package TJOBinarySearch;

import java.io.*;

public class SingingCompetition {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int mic = Integer.parseInt(input[2]);
		for(int i=0;i<n;i++) {
			int arr[] = new int[m];
			String[] strArr = br.readLine().split(" ");
			int max = Integer.MIN_VALUE;
			for(int j=0;j<m;j++) {
				arr[j] = Integer.parseInt(strArr[j]);
				max = Math.max(max, arr[j]);
			}
			int l = 0;
			int r = max;
			while(l+1<r) {
				int mid = l +(r-l)/2;
				if(predicate(arr,mid,mic)==0) {
					l = mid;
				}else {
					r = mid;
				}
			}
			System.out.println(r+" ");
		}
	}

	private static int predicate(int[] arr, int mid, int mic) {
		int currMic = 0;
		for(int ele:arr) {
			currMic += Math.ceil((double)ele/mid);
		}
		if(currMic>mic) {
			return 0;
		}else {
			return 1;
		}
	}

}
