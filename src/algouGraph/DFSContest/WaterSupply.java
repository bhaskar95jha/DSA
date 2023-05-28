package algouGraph.DFSContest;

import java.io.*;
import java.util.*;

public class WaterSupply {

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
		}
		
		int vis[] = new int[n+1];
		int count = 0;
		for(int i=1;i<n+1;i++) {
			if(vis[i]!=2) {
				System.out.println(i);
				count++;
				dfs(adjList,i,vis);
			}
			
		}
		long ans = (count-1)*x;
		System.out.println(count-1);
		System.out.println(ans);
	}

	private static void dfs(List<List<Integer>> adjList, int curr, int[] vis) {
		// TODO Auto-generated method stub
		vis[curr] = 1;
		
		for(int child:adjList.get(curr)) {
			if(vis[child]==0) {
				dfs(adjList,child,vis);
			}
		}
		vis[curr] = 2;
	}

}
