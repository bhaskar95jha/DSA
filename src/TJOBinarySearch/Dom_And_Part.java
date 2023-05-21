	package TJOBinarySearch;
	
	import java.util.Arrays;
	import java.util.Scanner;
	
	public class Dom_And_Part {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			while(t-- > 0) {
				int n = sc.nextInt();
				int p = sc.nextInt();
				int arr[] = new int[n];
				int max = 0;
				int min = Integer.MAX_VALUE;
				for(int i=0;i<n;i++) {
					arr[i] = sc.nextInt();
					max = Math.max(max,arr[i]);
					min = Math.min(min, arr[i]);
				}
				Arrays.sort(arr);
				long l = 0;
				long r = max;
				while(l+1<r) {
					long mid = l + (r-l)/2;
					if(predicate(arr,mid,p) == 0) {
						l = mid;
					}else {
						r = mid;
					}
				}
				System.out.println(r);
			}
		}
	
		private static int predicate(int[] arr, long mid, int p) {
			int no_of_pairs = 0;
			for(int i=1;i<arr.length;i++) {
				if(arr[i]-arr[i-1] <= mid) {
					no_of_pairs++;
					i++;
				}
				
			}
			if(no_of_pairs < p)
				return 0;
			else
				return 1;
		}
	
	}
