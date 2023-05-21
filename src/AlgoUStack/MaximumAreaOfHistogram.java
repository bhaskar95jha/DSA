package AlgoUStack;

import java.util.*;

public class MaximumAreaOfHistogram {
	
	static class Pair{
		int ele;
		int index;
		public Pair(int ele, int index) {
			this.ele = ele;
			this.index = index;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Stack<Pair> leftStack = new Stack<>();
		Stack<Pair> rightStack = new Stack<>();
		int [] leftArray = new int[n];
		int [] rightArray = new int[n];
		int l = 0;
		int r = n-1;
		for(int i=0;i<n;i++) {
			int ele = arr[i];
			if(leftStack.empty()) {
				leftStack.push(new Pair(ele, i));
				leftArray[i] = l;
			}else {
				if(leftStack.peek().ele>=ele) {
					while(!leftStack.empty() && leftStack.peek().ele>=ele) {
						leftStack.pop();
					}
					if(leftStack.empty()) {
						leftArray[i] = l;
					}else {
						leftArray[i] = leftStack.peek().index+1;
					}
					
				}else {
					leftArray[i] = leftStack.peek().index+1;
				}
				leftStack.push(new Pair(ele, i));
			}
		}
		
		for(int i=r;i>=0;i--) {
			int ele = arr[i];
			if(rightStack.empty()) {
				rightStack.push(new Pair(ele, i));
				rightArray[i] = r;
			}else {
				if(rightStack.peek().ele>=ele) {
					while(!rightStack.empty() && rightStack.peek().ele>=ele) {
						rightStack.pop();
					}
					if(rightStack.empty()) {
						rightArray[i] = r;
					}else {
						rightArray[i] = rightStack.peek().index-1;
					}
					
				}else {
					rightArray[i] = rightStack.peek().index-1;
				}
				rightStack.push(new Pair(ele, i));
			}
		}
		
		int ans = -1;
		for(int i=0;i<n;i++) {
			int area = (rightArray[i] - leftArray[i] + 1) * arr[i];
			ans = Math.max(ans, area);
			System.out.println(area);
		}
		System.out.println(ans);
	}

}
