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
		Deque<Long> q = new ArrayDeque<>();
		Set<Long> vis = new HashSet<>();
		
		for(int i=0;i<n;i++) {
			temple[i] = Integer.parseInt(st.nextToken());
			q.add((long) temple[i]);
			vis.add((long) temple[i]);
		}
		
		
		Set<Long> ansList = new HashSet<>();
		
		bfs(q,vis,ansList,m);
		for(long ele:ansList) {
			System.out.print(ele+" ");
		}
	}

	private static void bfs(Deque<Long> q, Set<Long> vis, Set<Long> ansList,int saint) {
		// TODO Auto-generated method stub
		long dist = 1;
		long ans = 0;
		while(!q.isEmpty() && saint>0) {
			long size =  q.size();	
			while(size>0 && saint>0) {
				long curr = q.poll();
				if(curr>Integer.MAX_VALUE-1 && curr<Integer.MIN_VALUE+1) {
					continue;
				}
				long prev = curr-1;
				long next = curr+1;
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
