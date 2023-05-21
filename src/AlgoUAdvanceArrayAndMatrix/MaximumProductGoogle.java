package AlgoUAdvanceArrayAndMatrix;

import java.util.Scanner;

public class MaximumProductGoogle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		int maxProd = 1;
		int currProd = 1;
		int flag = 0;
		int count = 0;
		for(int i=0;i<n;i++) {
			if(arr[i] == 0) {
				flag = 1;
				currProd = 0;
				continue;
			}else {
				if(flag == 0) {
					count++;
					if(count<k) {
						currProd *= arr[i];
					}else if(count == k){
						currProd *= arr[i];
						maxProd = currProd;
					}
					else {
						currProd = (currProd * arr[i]) / arr[i-k]; 
						maxProd = Math.max(currProd, maxProd);
					}
					
				}else {
					count = 1;
					currProd = arr[i];
				}
				flag = 0;
			}
			
		}
		System.out.println("Maximum product is : "+maxProd);
		
	}

}
