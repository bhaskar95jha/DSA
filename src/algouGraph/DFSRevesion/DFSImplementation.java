package algouGraph.DFSRevesion;

import java.io.*;
import java.util.*;

public class DFSImplementation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =
			    new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			List<List<Integer>> adjList = new ArrayList<>();
			for(int i=0;i<n+1;i++) {
				adjList.add(new ArrayList<>());
			}
			
			while(m-- > 0) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				adjList.get(u).add(v);
				adjList.get(v).add(u);
			}
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int vis[] = new int[n+1];
			List<Integer> dfsTraverse = new ArrayList<>();
			dfs(adjList,start,vis,dfsTraverse);
			for (int ele : dfsTraverse) {
				System.out.print(ele+" ");
			}
			System.out.println();
	}


	private static void dfs(List<List<Integer>> adjList, int curr, int[] vis, List<Integer> dfsTraverse) {
		// TODO Auto-generated method stub
		dfsTraverse.add(curr);
		vis[curr] = 1;
		
		for(int child:adjList.get(curr)) {
			if(vis[child]==0) {
				vis[child] = 1;
				dfs(adjList,child,vis,dfsTraverse);
			}
		}
		
	}

}
