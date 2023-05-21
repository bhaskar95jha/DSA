package striverRecursion;

import java.util.*;

public class PrintPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3};
		boolean freq[] = new boolean[arr.length];
		List<Integer> li = new ArrayList<>();
		printPermutation(arr,freq,li);
	}

	private static void printPermutation(int[] arr, boolean[] freq, List<Integer> li) {
		// TODO Auto-generated method stub
		if(li.size() == arr.length) {
			System.out.println(li);
			return;
		}
		
		for(int i=0;i<arr.length;i++) {
			if(!freq[i]) {
				li.add(arr[i]);
				freq[i] = true;
				printPermutation(arr, freq, li);
				li.remove(li.size()-1);
				freq[i] = false;
			}
		}
	}

}
