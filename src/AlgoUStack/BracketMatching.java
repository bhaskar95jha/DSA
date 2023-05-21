package AlgoUStack;

import java.util.*;

public class BracketMatching {
	
	static class Pair{
		char ch;
		int index;
		
		public Pair(char ch, int index) {
			this.ch = ch;
			this.index = index;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Stack<Pair> st = new Stack<>();
		int ans[] = new int[str.length()];
		
		int i = 0;
		for(char ch:str.toCharArray()) {
			if(ch=='(') {
				st.push(new Pair(ch,i));
			}else {
				if(!st.isEmpty() && st.peek().ch == '(') {
					ans[i] = st.peek().index;
					ans[st.peek().index] = i;
					st.pop();
				}else
					st.push(new Pair(ch,i));
			}
			i++;
		}
		while(!st.empty()) {
			ans[st.peek().index] = -1;
			st.pop();
		}
		
		for(int ele:ans) {
			System.out.print(ele+" ");
		}
	}

}
