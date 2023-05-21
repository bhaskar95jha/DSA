package algouGraph.DFSRevesion;

import java.io.*;
import java.util.*;

public class HeightNodeOfTree {

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
			int height = 1;
			int vis[] = new int[n+1];
			Map<Integer,Integer> heightMap = new HashMap<>();
			
			dfsHeight(adjList,start,vis,heightMap,height);
			
			System.out.println(heightMap);
	}


	private static void dfsHeight(List<List<Integer>> adjList, int curr, int[] vis, Map<Integer, Integer> heightMap,
			int height) {
		// TODO Auto-generated method stub
		vis[curr] = 1;
		heightMap.put(curr,height);
		
		for(int child:adjList.get(curr)) {
			if(vis[child] == 0) {
				vis[child] = 1;
				dfsHeight(adjList, child, vis, heightMap, height+1);
			}
		}
		
	}


	

}
