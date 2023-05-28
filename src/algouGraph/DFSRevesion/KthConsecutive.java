package algouGraph.DFSRevesion;

import java.util.*;

public class KthConsecutive {

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
		int start = 1;
		int k = 3;
		int vis[] = new int[n+1];
		int fireNode[] = {0,1,1,1,1,0,1,1,0,0,1,0,0,0};
		
		
		int ans = dfs(adjList,start,vis,k,fireNode,fireNode[1]);
	
		System.out.println(ans >= 1 ? "YES" : "NO");

		sc.close();
	}

	private static int dfs(List<List<Integer>> adjList, int curr, int[] vis, int k, int[] fireNode, int fireCount) {
		// TODO Auto-generated method stub
		if(fireCount >= k) {
			return 0;
		}
		vis[curr] = 1;
		
		int count = 0;
		for(int child:adjList.get(curr)) {
			if(vis[child]==0) {
				if(fireNode[child]==1) {
					count += dfs(adjList, child, vis, k, fireNode, fireCount+1);
				}else {
					count += dfs(adjList, child, vis, k, fireNode, 0);
				}
			}
		}
		
		
		//check for leaf node
		if(adjList.get(curr).size()==1 && curr != -1) {
			return 1;
		}
	
		return count;
	}


}
