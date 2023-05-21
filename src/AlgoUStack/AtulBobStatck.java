package AlgoUStack;

import java.util.*;

public class AtulBobStatck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int atul[] = new int[n];
		int bob[] = new int[n];
		for(int i=0;i<n;i++) {
			atul[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			bob[i] = sc.nextInt();
		}
		Stack<Integer> st = new Stack<>();
		int i = 0;
		int j = 0;
		while(i != n) {
			if(atul[i] != bob[j]) {
				if(st.peek()==bob[j]) {
					st.pop();
					j++;
				}else {
					st.push(atul[i]);
					i++;
				}	
			}else {
				i++;
				j++;
			}
		}
		while(!st.empty()) {
			if(st.pop() != bob[j++]) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}

}
