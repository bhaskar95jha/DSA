package AlgoUBinarySearchMaximin_MiniMax;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int ans = solve(n,k,arr);
		System.out.println(ans);
	}
	
	
	public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int l = 1;
        int r = stalls[n-1];
        
        while(l+1<r){
            int mid = l + (r-l)/2;
            if(predicate(stalls,mid,k)==0){
                l = mid;
            }else{
                r = mid;
            }
        }
        return l;
        
    }
    
    static int predicate(int []stalls,int dist,int k){
        int currCow = 1;
        int currCowPos = stalls[0];
        for(int i=0;i<stalls.length;i++){
            if(stalls[i] >= (currCowPos+dist)){
                currCowPos = stalls[i];
                currCow++;
                if(currCow>=k){
                    return 0;
                }
            }
        }
        return 1;
    }

}
