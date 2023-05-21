package algouGraph.DFSBasic;

import java.util.*;

public class BiggestNumberInA_Subtree {

	public static void main(String[] args) {
		
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
		int start = sc.nextInt();
		
		int vis[] = new int[n+1];
		int bigNumberSubtree[] = new int[n+1];
		
		int ans = dfs(adjList,start,vis,bigNumberSubtree);
	
		int count = 0;
		for(int big:bigNumberSubtree) {
			if(count == 0) {
				count = 1;
				continue;
			}
			System.out.println("biggest number of subtree of Node : "+ count++ +" is : "+big);
		}
		sc.close();
	}

	private static int dfs(List<List<Integer>> adjList, int curr, int[] vis, int[] bigNumberSubtree) {
		
		vis[curr] = 1;
		
		int max = curr;
		for(int child:adjList.get(curr)) {
			if(vis[child]==0) {
				max = Math.max(dfs(adjList,child,vis,bigNumberSubtree), max);
			}
		}
		
		bigNumberSubtree[curr] = max;
		
		return max;
	}

}
