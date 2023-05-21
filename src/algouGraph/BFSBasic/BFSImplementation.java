package algouGraph.BFSBasic;

import java.util.*;

public class BFSImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		List<List<Integer>> adjList = new ArrayList<>();
		
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		
		while(m-->0) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjList.get(src).add(dest);
			adjList.get(dest).add(src);
		}
		int src = sc.nextInt();
		int vis[] = new int[n+1];
		int dist[] = new int[n+1];
		dist = bfsMinDist(adjList,src,vis);
		System.out.println("Minimum dist from src "+src+" to each node");
		for(int i=1;i<dist.length;i++) {
			System.out.print(dist[i]+" ");
		}
		
	}

	private static int[] bfsMinDist(List<List<Integer>> adjList, int src, int[] vis) {
		int dist[] = new int[vis.length];
		Deque<Integer> q = new ArrayDeque<>();
		q.add(src);
		vis[src] = 1;
		dist[src] = 0;
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
