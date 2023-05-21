package algouGraph.DFSBasic;

import java.util.*;

public class CompanyHierarchy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		List<List<Integer>> adjList = new ArrayList<>();
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i=2;i<n+1;i++) {
			int j = sc.nextInt();
			adjList.get(j).add(i);
		}
		
		int manage[] = new int[n+1];
		int vis[] = new int[n+1];
		
		int ans = dfs(adjList,1,vis,manage);
		
		for(int i=1;i<n+1;i++) {
			System.out.print(manage[i]+" ");
		}
	}

	private static int dfs(List<List<Integer>> adjList, int curr, int[] vis, int[] manage) {
		
		vis[curr] = 1;
		
		int teamSize = 1;
		
		for(int child:adjList.get(curr)) {
			if(vis[child]==0) {
				teamSize += dfs(adjList,child,vis,manage);
			}
		}
		
		manage[curr] = teamSize-1;
		
		
		return teamSize;
	}

}
