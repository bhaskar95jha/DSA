package algouGraph.DFSAdvance;

import java.io.*;
import java.util.*;

public class FarthestNode {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = n -1;
		
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
		int ans[] = new int[n+1];
		for(int i=1;i<n+1;i++) {
			if(ans[i]>0) {
				continue;
			}
			int dmax_a[] = new int[1];
			dmax_a[0] = -1;
			
			dfs(i,i,0,dmax_a,adjList);
			
			ans[i] = dmax_a[0];
		}
		for(int i=1;i<n+1;i++) {
			System.out.print(ans[i]+" ");
		}
	}
	
	private static void dfs(int src, int parent, int dist, int[] dmax_a,List<List<Integer>> adjList) {
		// TODO Auto-generated method stub
	
		if (dist > dmax_a[0]) {
	        dmax_a[0] = dist;
	        
	    }
	    for (int child : adjList.get(src)) {
	        if (child != parent) {
	            dfs(child, src, dist+1, dmax_a,adjList);
	        }
	    }
	}

}
