package AlgoUStack;

import java.util.*;

public class PostfixEvaluation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		Stack<Integer> st = new Stack<>();
		int num1 = -1;
		int num2 = -1;
		
		for(char ele:str.toCharArray()) {
			if(ele==' ') {
				continue;
			}
			if(Character.isDigit(ele)) {
				st.push(ele-'0');
			}else {
				if(!st.empty())
					num2 = st.pop();
				if(!st.empty())
					num1 = st.pop();
				if(ele == '+') {
					st.push(num1+num2);
				}else if(ele == '-') {
					st.push(num1-num2);
				}else if(ele == '*') {
					st.push(num1*num2);
				}else {
					if(num1!=0)
						st.push(num1/num2);
				}
			}
		}
		if(!st.empty()) {
			System.out.println(st.pop());
		}
	}

}
