package algouGraph.BFSBasic;

import java.util.*;

public class UniqueNodeInShortestPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<List<Integer>> adjList = new ArrayList<>();
		
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		
		while(m-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		
		int src = sc.nextInt();
		int dest = sc.nextInt();
		int vis[] = new int[n+1];
		int distSrc[] = new int[n+1];
		distSrc = bfsDist(adjList,src,vis);
		vis = new int[n+1];
		int distDest[] = new int[n+1];
		distDest = bfsDist(adjList,dest,vis);
		int total[] = new int[n+1];
		int min = Integer.MAX_VALUE;
		
		for(int i=1;i<n+1;i++) {
			total[i] = distSrc[i] + distDest[i];
			min = Math.min(min, total[i]);
		}
		
		int count = 0;
		List<Integer> ans = new ArrayList<>();
		for(int i=0;i<n+1;i++) {
			if(total[i] == min) {
				count++;
				ans.add(i);
			}
		}
		
		System.out.println(count);
		System.out.println(ans);
		
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
