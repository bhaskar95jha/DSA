package algouGraph.DFSAdvance;

import java.io.*;
import java.util.*;

public class DiameterOfTree {

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
		
		}
		

		int vis[] = new int[n+1];
		List<Integer> ansList = new ArrayList<>();
 		int ans = dfs(adjList,1,vis,ansList);
 		int max = 0;
 		for(int ele:ansList)
 			max = Math.max(ele, max);
 		
		System.out.println(max);
	}

	private static int dfs(List<List<Integer>> adjList, int curr, int[] vis,List<Integer> ansList) {
		// TODO Auto-generated method stub
		vis[curr] = 1;
		
		List<Integer> childSize = new ArrayList<>();
		int ans = 0;
		for(int child:adjList.get(curr)) {
			if(vis[child]==0) {
				childSize.add(dfs(adjList,child,vis,ansList));
				
			}			
		}
		Collections.sort(childSize);
		Collections.reverse(childSize);
		if(childSize.size()==0)
			return 1;
		
		if(childSize.size()==1) {
			ans = Math.max(ans, childSize.get(0)+1);
		}else {
			ans = Math.max(ans, childSize.get(0)+childSize.get(1)+1);
		}
		
		ansList.add(ans);
		
		return childSize.get(0)+1;
	}

}
