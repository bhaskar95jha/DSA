package AlgoUBinarySearchMaximin_MiniMax;

import java.util.Scanner;

public class BookAllocationProblem {
	//split array largest sum
	//painter's partition problems
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int max = -1;
		int sum = 0;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
			sum += arr[i];
		}
		int k = sc.nextInt();
		int ans = splitArray(arr,k,max,sum);
		System.out.println(ans);
	}

	private static int splitArray(int[] arr, int k, int max, int sum) {
		// TODO Auto-generated method stub
		int l = 0;
		int r = sum;
		while(l+1<r) {
			int mid = l + (r-l)/2;
			if(predicate(arr,mid,k)==0) {
				l = mid;
			}else {
				r = mid;
			}
		}
		
		return r;
	}

	private static int predicate(int[] arr, int mid, int k) {
		int currStudent = 1;
		int currPage = 0;
		for(int ele:arr) {
			if(ele>mid)
				return 0;
			currPage += ele;
			if(currPage>mid) {
				currPage = ele;
				currStudent++;
				if(currStudent>k) {
					return 0;
				}
			}
		}
		return 1;
	}

}
