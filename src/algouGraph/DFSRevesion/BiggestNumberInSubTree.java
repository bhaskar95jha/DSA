package algouGraph.DFSRevesion;

import java.io.*;
import java.util.*;

public class BiggestNumberInSubTree {

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
			Map<Integer,Integer> biggestNumber = new HashMap<>();
			
			sizeOfSubtree(adjList,start,vis,biggestNumber);
			
			System.out.println(biggestNumber);
	}

	private static int sizeOfSubtree(List<List<Integer>> adjList, int curr, int[] vis,
			Map<Integer, Integer> biggestNumber) {
		// TODO Auto-generated method stub
		vis[curr] = 1;
		int max = curr;
		
		for(int child:adjList.get(curr)) {
			if(vis[child]==0) {
				max = Math.max(sizeOfSubtree(adjList, child, vis, biggestNumber), max);
			}
		}
		System.out.println(curr+" "+max);
		biggestNumber.put(curr,max);
		
		return max;
	}


	


	


	

}
