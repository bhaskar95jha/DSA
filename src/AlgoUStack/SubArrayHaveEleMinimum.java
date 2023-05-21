package AlgoUStack;

import java.util.*;

public class SubArrayHaveEleMinimum {
	
	static class Pair{
		int ele;
		int index;
		public Pair(int ele, int index) {
			this.ele = ele;
			this.index = index;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arr[] = {2,1,3,4};
		int n = arr.length;
		int l = 0;
		int r = n-1;
		int ans[] = new int[n];
		Stack<Pair> leftStack = new Stack<>();
		Stack<Pair> rightStack = new Stack<>();
		int leftArray[] = new int[n];
		int rightArray[] = new int[n];
		for(int i=0;i<n;i++) {
			int ele = arr[i];
			if(leftStack.empty()) {
				leftStack.push(new Pair(ele,i));
				leftArray[i] = l;
			}else {
				if(ele<leftStack.peek().ele) {
					while(!leftStack.empty() && ele<leftStack.peek().ele) {
						leftStack.pop();
					}
					if(leftStack.empty()) {
						leftArray[i] = l;
						//leftStack.push(new Pair(ele,i));
					}else {
						leftArray[i] = leftStack.peek().index+1;
						//leftStack.push(new Pair(ele, i));
					}
				}else {
					leftArray[i] = leftStack.peek().index+1;
					//leftStack.push(new Pair(ele, i));
				}
				leftStack.push(new Pair(ele,i));
			}
		}
		
		
		System.out.println("********************************");
		
		for(int i=r;i>=0;i--) {
			int ele = arr[i];
			if(rightStack.empty()) {
				rightStack.push(new Pair(ele,i));
				rightArray[i] = r;
			}else {
				if(ele<rightStack.peek().ele) {
					while(!rightStack.empty() && ele<rightStack.peek().ele) {
						rightStack.pop();
					}
					if(rightStack.empty()) {
						rightStack.push(new Pair(ele,i));
						rightArray[i] = r;
					}else {
						rightArray[i] = rightStack.peek().index-1;
						rightStack.push(new Pair(ele, i));
					}
				}else {
					rightArray[i] = rightStack.peek().index-1;
					rightStack.push(new Pair(ele, i));
				}
			}
		}
		
		
		for(int i=0;i<n;i++) {
			ans[i] = (i+1-leftArray[i]) * (rightArray[i]-i+1);
		}
		
		System.out.println("For every element no. of subarray have that elements is minimum is");
		for(int i=0;i<n;i++) {
			System.out.print(ans[i]+" ");
		}
		
		
		
	}

}
