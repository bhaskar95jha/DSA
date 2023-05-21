package Coderush2ArrayAdvance;

import java.util.Scanner;

public class StringOPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String st = sc.next();
		int n = st.length();
		int queies = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<queies;i++) {
			arr[i] = 0;
		}
		while(queies-- >0) {
			int q = sc.nextInt();
			int l = q-1;
			int r = n-q+1;
			arr[l] += 1;
			
		}
		for(int i=1;i<=(n/2);i++) {
			arr[i] += arr[i-1];
		}
		
		for(int ele:arr) {
			System.out.print(ele);
		}
		System.out.println();
		
		int l = 0;
		int r = n-1;
		char[] ch = st.toCharArray();
		
		while(l<=(r/2)) {
			if(arr[l]%2==1) {
				char temp = ch[l];
				ch[l] = ch[r-l];
				ch[r-l] = temp;
				
			}
			l++;
		}
		String ans = new String(ch);
		System.out.println(ans);
		sc.close();
	}
	
	
	
	
	

}
