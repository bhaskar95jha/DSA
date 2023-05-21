package algouGraph.BFSAdvance;

import java.util.*;

public class SaintArrangement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int temple[] = new int[n];
		List<Integer> al = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			temple[i] = sc.nextInt();
			al.add(temple[i]);
		}
		sc.close();
		
		Collections.sort(al);
		
		while(m-->0) {
			
		}
		
	}

}
