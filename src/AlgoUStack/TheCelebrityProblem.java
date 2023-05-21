package AlgoUStack;

import java.util.*;

public class TheCelebrityProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 3;
		int m[][] = {
				{0,1,0},
				{0,0,0},
				{0,1,0}
		};
		int ans = celebrity(m,n);
		System.out.println(ans);
	}

	private static int celebrity(int[][] m, int n) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<n;i++) {
			st.push(i);
		}
		
		while(st.size()>1) {
			int a = st.pop();
			int b = st.pop();
			if(knows(m,a,b)==true) {
				st.push(b);
			}else {
				st.push(a);
			}
		}
		
		int candidate = st.peek();
		for(int i=0;i<n;i++) {
			if(m[candidate][i] != 0)
				return -1;
		}
 		int flag = 0;
		for(int i=0;i<n;i++) {
			if(flag == 1) {
				if(m[i][candidate] == 0) {
					return -1;
				}
			}
			if(m[i][candidate] == 0) {
				flag = 1;
			}
		}
		return candidate;
	}

	private static boolean knows(int m[][],int a, int b) {
		// TODO Auto-generated method stub
		if(m[a][b]==1) {
			return true;
		}
		return false;
	}

}
