package TheJobOverflow;

import java.util.Scanner;

public class StringReversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String st = sc.next();
		int n = sc.nextInt();
		char []arr = st.toCharArray();
		int ind = n-1;
		int j = 0;
		for(int i=0;i<n;i++) {
			ind = n-(i+1);
			j = 0;
			while(j<ind) {
				
				char temp = arr[j];
				arr[j] = arr[ind];
				arr[ind] = temp;
				j++;
				ind--;
			}
		}
		System.out.print(String.valueOf(arr));
		
	}

}
