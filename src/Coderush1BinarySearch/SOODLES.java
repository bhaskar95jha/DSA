package Coderush1BinarySearch;

import java.util.Scanner;

public class SOODLES {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0) {
			String a = sc.nextLine();
			String b = sc.nextLine();
			sc.next("");
			System.out.println(a);
			
			System.out.println(b);
			int i=0;
			int count = 0;
			while(i<a.length()) {
				for(int j=0;j<b.length();j++) {
					if(a.charAt(i)==b.charAt(j)) {
						i++;
					}
				}
				count++;
			}
			//System.out.println(count);
		}
	}

}
