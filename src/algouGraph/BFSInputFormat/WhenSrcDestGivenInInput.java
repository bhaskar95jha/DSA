package algouGraph.BFSInputFormat;

import java.io.*;
import java.util.*;

public class WhenSrcDestGivenInInput {

	public static void main(String[] args) throws IOException {
//		5 5
//		0 1
//		1 2
//		0 3
//		3 4
//		4 2
//		0 4
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
		int src = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		
	}

	
}
