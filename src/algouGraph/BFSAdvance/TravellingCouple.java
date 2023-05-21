package algouGraph.BFSAdvance;

import java.util.*;

public class TravellingCouple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int c1 = sc.nextInt();
		int c2 = sc.nextInt();
		int c3 = sc.nextInt();
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
		
		int distFromMan[] = new int[n+1];
		distFromMan = bfs(n,1,adjList);
		
		int distFromWoman[] = new int[n+1];
		distFromWoman = bfs(n,2,adjList);
		
		int distFromHome[] = new int[n+1];
		distFromHome = bfs(n,n,adjList);
		
		int ans = Integer.MAX_VALUE;
		for(int i=1;i<n+1;i++) {
			int fair = distFromMan[i] * c1 + distFromWoman[i] * c2 + distFromHome[i] * c3;
			ans = Math.min(ans, fair);
		}
		
		System.out.println(ans);
		
		
	}

	private static int[] bfs(int n, int src, List<List<Integer>> adjList) {
		// TODO Auto-generated method stub
		int dist[] = new int[n+1];
		int vis[] = new int[n+1];
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
