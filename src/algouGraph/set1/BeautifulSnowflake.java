package algouGraph.set1;

import java.util.*;

public class BeautifulSnowflake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int deg[] = new int[n+1];
		
		List<List<Integer> > al
		= new ArrayList<>();
		
		for (int i = 0; i < n+2; i++)
			al.add(new ArrayList<Integer>());
		
		int count[] = new int[n+1];
		while(m-->0) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			deg[s]++;
			deg[d]++;
			al.get(s).add(d);
			al.get(d).add(s);
		}
		for(int i=1;i<=n;i++) {
			if(deg[i]>1) {
				int flag = 0;
				for(int ele:al.get(i)) {
					if(deg[ele]!=1) {
						flag = 1;
						break;
					}
				}
				if(flag == 0) {
					count[deg[i]]++;
				}
			}
			if(deg[i]==0)
				count[deg[i]]++;
		}
		int ans = 0;
		for(int i=0;i<count.length;i++) {
			if(count[i]==1) {
				ans++;
			}
		}
		System.out.println(ans);
	}

}
