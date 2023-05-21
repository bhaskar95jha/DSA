package AlgoUStack;

import java.util.*;

public class PrintMaximumElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> st = new Stack<>();
		Stack<Integer> max = new Stack<>();
		max.push(-1);
		while(n != 0) {
			int q = sc.nextInt();
			if(q == 1) {
				int num = sc.nextInt();
				st.push(num);
				int ele = num>max.peek()?num:max.peek();
				max.push(ele);
			}else if(q==2) {
				st.pop();
				max.pop();
			}else if(q==3) {
				System.out.println(max.peek());
			}
		}
	}

}
