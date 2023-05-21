package algouGraph.BFSBasic;

import java.util.*;

public class bfssnippet {

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
			int s = sc.nextInt();
			int d = sc.nextInt();
			adjList.get(s).add(d);
			adjList.get(d).add(s);
		}
		int src = sc.nextInt();
		int dest = sc.nextInt();
		int bfs[] = new int[n+1];
		int vis[] = new int[n+1];
		bfs = bfsGraph(adjList,src,vis);
		for (int ele : bfs) {
			System.out.print(ele+" ");
		}
		System.out.println();
	}

	private static int[] bfsGraph(List<List<Integer>> adjList, int src, int[] vis) {
		
		int bfs[] = new int[vis.length];
		Deque<Integer> q = new ArrayDeque<>();
		
		vis[src] = 1;
		q.add(src);
		int index = 1;
		while(!q.isEmpty()) {
			int curr = q.poll();
			bfs[index++] = curr;
			for(int child:adjList.get(curr)) {
				if(vis[child]==0) {
					vis[child] = 1;
					q.add(child);
				}
			}
		}
		
		
		return bfs;
	}

}

