package AlgoUStack;

import java.util.*;

public class RainWaterTraping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int[] ans = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<n;i++) {
			int ele = arr[i];
			if(st.empty()) {	
				ans[i] = -1;
				st.push(ele);
			}else {
				if(ele >= st.peek()) {
					while(!st.empty() && ele >= st.peek()) {
						st.pop();
					}
					if(st.empty()) {
						ans[i] = -1;
					}else {
						ans[i] = st.peek();
					}
				}else {
					ans[i] = st.peek();
				}
				st.push(ele);
			}
		}
		
		for (Integer ele : ans) {
			System.out.print(ele+" ");
		}
	}

}
