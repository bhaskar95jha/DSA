package algouGraph.DFSContest;

import java.io.*;
import java.util.*;

public class RunTheCity {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> adjList = new ArrayList<>();
		
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		int m = n-1;
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adjList.get(u).add(v);
			//adjList.get(v).add(u);
		}
		int src = 1;
		int vis[] = new int[n+1];
		
		int ans = dfs(adjList,src,vis);
		System.out.println(ans);
		if(ans>=x)
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}
	private static int dfs(List<List<Integer>> adjList, int curr, int[] vis) {
		// TODO Auto-generated method stub
		vis[curr] = 1;
		int sum = curr;
		for(int child:adjList.get(curr)) {
			if(vis[child]==0) {
				sum += dfs(adjList, child, vis);
			}
		}
		
		if(adjList.get(curr).size()==0) {
			return sum;
		}else {
			return sum - curr;
		}
		
	}

}
