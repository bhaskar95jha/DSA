package algouGraph.DFSRevesion;

import java.util.*;

public class RedAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		//System.out.println(n+" "+c);
		
		List<List<Integer>> adjList = new ArrayList<>();
		
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		
		int fireNode[] = new int[n+1];
		for(int i=1;i<n+1;i++) {
			fireNode[i] = sc.nextInt();
		}
		int vis[] = new int[n+1];
		while(n-- > 1) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		
		int ans = dfs(adjList,vis,1,c,fireNode[1],fireNode);
		System.out.println(ans);
	}

	private static int dfs(List<List<Integer>> adjList, int[] vis, int curr, int capacity, int fireCount,int []fireNode) {
		
		vis[curr] = 1;
		if(fireCount>capacity) {
			return 0;
		}
		
		int count = 0;
		for(int child:adjList.get(curr)) {
			if(vis[child] == 0) {
				if(fireNode[child] == 1) {
					count += dfs(adjList, vis, child, capacity, fireCount+1, fireNode);
				}else {
					count += dfs(adjList, vis, child, capacity, 0, fireNode);
				}
			}
		}
		
		if(adjList.get(curr).size()== 1 && curr != 1) {
			return 1;
		}
		
		return count;
		
		
	}

}
