package algouGraph.DFSAdvance;

import java.io.*;
import java.util.*;

public class FindingCycleInUndirectedUnweighted {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
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
		
		int src = 1;
		int parent = -1;
		int vis[] = new int[n+1];
		boolean ans = dfs(adjList,src,parent,vis);
		System.out.println(ans);
		
	}

	private static boolean dfs(List<List<Integer>> adjList, int src, int parent, int[] vis) {
		
		vis[src] = 1;
		
		for(int child:adjList.get(src)) {
			if(vis[child]==1 && parent != child) {
				return true;
			}
			
			if(vis[child]==0) {
				if(dfs(adjList, child, src, vis)==true)
					return true;
			}
			
		}
		
		return false;
	}

}
