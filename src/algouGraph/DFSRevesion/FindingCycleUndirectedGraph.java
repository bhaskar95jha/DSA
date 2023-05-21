package algouGraph.DFSRevesion;

import java.util.*;

public class FindingCycleUndirectedGraph {

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
		int parent = 0;
		int vis[] = new int[n+1];
		boolean ans = dfs(adjList,src,vis,parent);
		System.out.println(ans);
	}

	private static boolean dfs(List<List<Integer>> adjList, int curr, int[] vis, int parent) {
		// TODO Auto-generated method stub
		vis[curr] = 1;
		
		for(int child:adjList.get(curr)) {
			if(vis[child]==0) {
				if(dfs(adjList,child,vis,curr)==true)
					return true;
			}else if(child != parent){
				return true;
			}
		}
		return false;
	}

}
