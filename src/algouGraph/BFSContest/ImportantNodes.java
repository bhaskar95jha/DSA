package algouGraph.BFSContest;

import java.io.*;
import java.util.*;

public class ImportantNodes {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =
			    new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<List<Integer>> adjList = new ArrayList<>();
		
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		int src = 1;
		int dest = n;
		int vis[] = new int[n+1];
		int distSrc[] = new int[n+1];
		distSrc = bfsDist(adjList,src,vis);
		vis = new int[n+1];
		int distDest[] = new int[n+1];
		distDest = bfsDist(adjList,dest,vis);
		int total[] = new int[n+1];
		int min = Integer.MAX_VALUE;
		
		if(distSrc[n]==0) {
			System.out.println(-1);
			return;
		}
		for(int i=1;i<n+1;i++) {
			total[i] = distSrc[i] + distDest[i];
			min = Math.min(min, total[i]);
		}
		
	
		List<Integer> ans = new ArrayList<>();
		for(int i=1;i<n+1;i++) {
			if(total[i] == min) {
				ans.add(i);
			}
		}
		for(int ele:ans) {
			System.out.print(ele+" ");
		}
		
	}

	private static int[] bfsDist(List<List<Integer>> adjList, int src, int[] vis) {
		Deque<Integer> q = new ArrayDeque<>();
		int dist[] = new int[vis.length];
		q.add(src);
		vis[src] = 1;
		dist[src] = 0;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int child:adjList.get(curr)) {
				if(vis[child]==0) {
					vis[child] = 1;
					q.add(child);
					dist[child] = dist[curr] + 1;
				}
			}
		}
		
		return dist;
	}

}
