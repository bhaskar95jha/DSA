package algouGraph.BFSAdvance;

import java.io.*;
import java.util.*;

public class SaintArrangement {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int temple[] = new int[n];
		Deque<Integer> q = new ArrayDeque<>();
		Set<Integer> vis = new HashSet<>();
		
		for(int i=0;i<n;i++) {
			temple[i] = Integer.parseInt(st.nextToken());
			q.add(temple[i]);
			vis.add(temple[i]);
		}
		
		
		Set<Integer> ansList = new HashSet<>();
		
		bfs(q,vis,ansList,m);
		for(int ele:ansList) {
			System.out.print(ele+" ");
		}
	}

	private static void bfs(Deque<Integer> q, Set<Integer> vis, Set<Integer> ansList,int saint) {
		// TODO Auto-generated method stub
		int dist = 1;
		int ans = 0;
		while(!q.isEmpty() && saint>0) {
			int size =  q.size();	
			while(size!=0 && saint>0) {
				int curr = q.poll();
				int prev = curr-1;
				int next = curr+1;
				if(!vis.contains(prev)) {
					q.add(prev);
					vis.add(prev);
					ansList.add(prev);
					saint -= 1;
					ans += dist;
				}
				if(!vis.contains(next)) {
					q.add(next);
					vis.add(next);
					ansList.add(next);
					saint -= 1;
					ans += dist;
				}
				size--;
			}
			dist++;
		}
		System.out.println(ans);
	}

}
