package algouGraph.DFSAdvance;

import java.io.*;
import java.util.*;

public class FlatteningOfTree {

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
		//int vis[] = new int[n+1];
		int dmax_a[] = new int[1];
		dmax_a[0] = -1;
		int []a = new int[1];
		a[0] = -1;
		int src = 1;
		int parent = 1;
		int dist = 1;
		dfs(src,parent,dist,dmax_a,a,adjList);
		System.out.println("ep1 is : "+a[0]);
		int dmax_b[] = new int[1];
		dmax_b[0] = -1;
		int []b = new int[1];
		b[0] = -1;
		
		dfs(a[0],a[0],1,dmax_b,b,adjList);
		System.out.println("ep2 is : "+b[0]);
		System.out.println(dmax_b[0]);
		
	}

	private static void dfs(int src, int parent, int dist, int[] dmax_a, int[] a,List<List<Integer>> adjList) {
		// TODO Auto-generated method stub
	
		if (dist > dmax_a[0]) {
	        dmax_a[0] = dist;
	        a[0] = src;
	    }
	    for (int child : adjList.get(src)) {
	        if (child != parent) {
	            dfs(child, src, dist+1, dmax_a, a,adjList);
	        }
	    }
	}

}
