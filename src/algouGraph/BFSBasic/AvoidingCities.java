package algouGraph.BFSBasic;

import java.util.*;

public class AvoidingCities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int src = sc.nextInt();
		int dest = sc.nextInt();
		Set<Integer> hs = new HashSet<>();
		for(int i=0;i<n;i++) {
			int ele = sc.nextInt();
			if(ele == 1)
				hs.add(i+1);
		}
		List<List<Integer>> adjList = new ArrayList<>();
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		while(m-->0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			if(hs.contains(u+1) || hs.contains(v+1)) {
				continue;
			}
			adjList.get(u+1).add(v+1);
			adjList.get(v+1).add(u+1);
		}
		int vis[] = new int[n+1];
		int dist[] = new int[n+1]; 
		dist = bfsAvoid(adjList,src+1,vis);
		if(dist[dest+1]==0)
			System.out.println(-1);
		else
			System.out.println(dist[dest+1]);
		sc.close();
	}

	private static int[] bfsAvoid(List<List<Integer>> adjList, int src, int[] vis) {
		int dist[] = new int[vis.length];
		Deque<Integer> q = new ArrayDeque<>();
		
		q.add(src);
		dist[src] = 0;
		vis[src] = 1;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int child:adjList.get(curr)) {
				if(vis[child]==0) {
					vis[child] = 1;
					q.add(child);
					dist[child] = dist[curr]+1;
				}
			}
		}
		
		return dist;
	}

}
