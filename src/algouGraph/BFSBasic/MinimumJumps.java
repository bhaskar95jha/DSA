package algouGraph.BFSBasic;

import java.util.*;

public class MinimumJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n+2; i++)
			adjList.add(new ArrayList<Integer>());
		
 		while(m-->0) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			adjList.get(s).add(d);
			adjList.get(d).add(s);
		}
 		int src = sc.nextInt();
 		int dest = sc.nextInt();
 		int vis[] = new int[n+1];
 		int ans[] = new int[n+1];
 		ans = bfs(adjList,src,vis);
 		System.out.println(ans[dest]);
 		
	}

	private static int[] bfs(List<List<Integer>> adjList, int src, int[] vis) {
		Queue<Integer> q = new ArrayDeque<>();
		int ans[] = new int[vis.length];
		vis[src] = 1;
		q.add(src);
		int count = 0;
		ans[src] = 0;
		while(!q.isEmpty()) {
			src = q.poll();	
			for(int ele:adjList.get(src)) {
				if(vis[ele]==0) {
					ans[ele] = ans[src]+1;
					vis[ele] = 1;
					q.add(ele);
				}
			}
		}
		return ans;
	}

}
