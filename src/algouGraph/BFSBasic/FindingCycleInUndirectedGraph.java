package algouGraph.BFSBasic;

import java.util.*;

public class FindingCycleInUndirectedGraph {

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
		int vis[] = new int[n+1];
		bfs(adjList,src,vis);
	}

	private static void bfs(List<List<Integer>> adjList, int src, int[] vis) {
		// TODO Auto-generated method stub
		int parent[] = new int[vis.length];
		Deque<Integer> q = new ArrayDeque<>();
		q.add(src);
		vis[src] = 1;
		parent[src] = -1;
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int child:adjList.get(curr)) {
				if(vis[child]==1 && child!=parent[curr]) {
					System.err.println("Cycle found");
					return;
				}
				if(vis[child]==0) {
					q.add(child);
					parent[child] = curr;
					vis[child] = 1;
				}
			}
		}
		System.out.println("Not cycle");
		
	}

}
