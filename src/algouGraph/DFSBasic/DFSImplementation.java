package algouGraph.DFSBasic;

import java.util.*;

public class DFSImplementation {

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
		int vis[] = new int[n+1];
		List<Integer> dfsList = new ArrayList<>();
		int start = 3;
		
		dfs(start,vis,dfsList,adjList);
		
		for(int ele:dfsList) {
			System.out.print(ele+" ");
		}
		System.out.println();
		
	}

	private static void dfs(int node, int[] vis,List<Integer> dfsList,List<List<Integer>> adjList) {
		// TODO Auto-generated method stub
		vis[node] = 1;
		dfsList.add(node);
		for(int child:adjList.get(node)) {
			if(vis[child]==0) {
				dfs(child,vis,dfsList,adjList);
			}
		}
	}

}
