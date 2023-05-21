package algouGraph.DFSRevesion;

import java.io.*;
import java.util.*;

public class CompanyHierarchy {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =
			    new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			List<List<Integer>> adjList = new ArrayList<>();
			for(int i=0;i<n+1;i++) {
				adjList.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=2;i<n+1;i++) {
				int boss = Integer.parseInt(st.nextToken());
				adjList.get(boss).add(i);
			}
			
	
			int vis[] = new int[n+1];
			int[] subTreeMap = new int[n+1];
			
			companyHierarchy(adjList,1,vis,subTreeMap);
			
			for(int i=1;i<n+1;i++) {
				System.out.print(subTreeMap[i]+" ");
			}
			
	}

	private static int companyHierarchy(List<List<Integer>> adjList, int curr, int[] vis,
			int[] subTreeMap) {
		vis[curr] = 1;
		
		int size = 1;
		for(int child:adjList.get(curr)) {
			if(vis[child]==0) {
				size += companyHierarchy(adjList, child, vis, subTreeMap);
			}
		}
		subTreeMap[curr] = size-1;
		return size;
		
	}
}
