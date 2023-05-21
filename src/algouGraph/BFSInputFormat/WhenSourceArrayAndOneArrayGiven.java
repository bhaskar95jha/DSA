package algouGraph.BFSInputFormat;

import java.io.*;
import java.util.*;

public class WhenSourceArrayAndOneArrayGiven {

	public static void main(String[] args) throws IOException {
//		5 5
//		0 2
//		0 1 0 0 0
//		0 1
//		1 2
//		0 3
//		3 4
//		4 2
		BufferedReader br =
			    new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<List<Integer>> adjList = new ArrayList<>();
		
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		
		st = new StringTokenizer(br.readLine());
		int src = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		
		Set<Integer> cursedCity = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		int count = 0;
		while(st.hasMoreTokens()) {
			if(Integer.parseInt(st.nextToken())==1) {
				cursedCity.add(count);
			}
			count++;
		}
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if(!cursedCity.contains(u) && !cursedCity.contains(v)) {
				adjList.get(u).add(v);
				adjList.get(v).add(u);
			}
		}
		
		int vis[] = new int[n+1];
		int dist[] = new int[n+1];
		bfs(adjList,vis,dist,src);
	}

	private static void bfs(List<List<Integer>> adjList, int[] vis, int[] dist, int src) {
		// TODO Auto-generated method stub
		
	}

}
