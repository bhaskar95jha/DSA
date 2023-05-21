package Coderush3;

import java.util.*;

public class LinearProbing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int hash[] = new int[m];
		
		HashSet<Integer> hs = new HashSet<>();
		for(int i=0;i<n;i++) {
			if(hs.contains(arr[i])) {
				continue;
			}
			hs.add(arr[i]);
			int ind = arr[i]%m;
			if(hash[ind]==0)
				hash[ind] = arr[i];
			else {
				int j = -1;
				for(j = ind;j<m;j++) {
					if(hash[j]==0) {
						hash[j] = arr[i];
						break;
					}
				}
				if(j==m) {
					for(j=0;j<ind;j++) {
						if(hash[j]==0) {
							hash[j] = arr[i];
							break;
						}
					}
				}
				if(j==ind) {
					break;
				}
			}
		}
		for(int i=0;i<m;i++) {
			if(hash[i]==0) {
				System.out.print(-1+" ");
			}else {
				System.out.print(hash[i]+" ");
			}
		}
	}

}
