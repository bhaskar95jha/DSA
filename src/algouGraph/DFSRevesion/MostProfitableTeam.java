package algouGraph.DFSRevesion;

import java.io.*;
import java.util.*;

public class MostProfitableTeam {

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
			
			int profitArr[] = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<n+1;i++) {
				profitArr[i] = Integer.parseInt(st.nextToken()); 
			}
			
	
			int vis[] = new int[n+1];
			int[] mostProfitable = new int[n+1];
			
			companyHierarchy(adjList,1,vis,mostProfitable,profitArr);
			
			
			
			int max = Integer.MIN_VALUE;
			
			for(int i=1;i<n+1;i++) {
				max = Math.max(max, mostProfitable[i]);
			}
			
			System.out.println(max);
			
			
	}

	private static int companyHierarchy(List<List<Integer>> adjList, int curr, int[] vis, int[] mostProfitable,
			int[] profitArr) {
		vis[curr] = 1;
		int max = profitArr[curr];
		
		for(int child:adjList.get(curr)) {
			max += companyHierarchy(adjList, child, vis, mostProfitable, profitArr);
		}
		
		mostProfitable[curr] = max;
		
		return max;
		
	}

	
}
