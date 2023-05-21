package striverRecursion;

public class ReverseArrayAndPalindrome_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5,6};
		int ans[] = reverseArray(arr,0,(arr.length-1));
		for(int i=0;i<ans.length;i++) {
			System.out.print(ans[i]+" ");
		}
		System.out.println();
		boolean isPalindrome = palindrome(arr,0,arr.length-1);
		System.out.println(isPalindrome);
	}

	private static boolean palindrome(int []arr,int i,int j) {
		// TODO Auto-generated method stub
		if(i>=j) {
			return true;
		}
		
		if(arr[i] != arr[j])
			return false;
		
		return palindrome(arr, i+1, j-1);
	}

	private static int[] reverseArray(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		if(i>=j) {
			return arr;
		}
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
		return reverseArray(arr, i+1, j-1);
	}

}
