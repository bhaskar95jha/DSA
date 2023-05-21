package algouGraph.DFSBasic;

import java.util.*;

public class SizeOfSubTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		List<List<Integer>> adjList = new ArrayList<>();
		
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		
		while(m-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		int start = sc.nextInt();
		
		int vis[] = new int[n+1];
		int subtreeSize[] = new int[n+1];
		
		int ans = dfs(adjList,start,vis,subtreeSize);
	
		System.out.println(ans);
		int count = 0;
		for(int size:subtreeSize) {
			System.out.println("size of subtree of Node : "+ count++ +" is : "+size);
		}
		sc.close();
		
	}

	private static int dfs(List<List<Integer>> adjList, int curr, int[] vis, int[] subtreeSize) {
		// TODO Auto-generated method stub
		vis[curr] = 1;
		
		int size = 1;
		for(int child:adjList.get(curr)) {
			if(vis[child]==0) {
				size += dfs(adjList,child,vis,subtreeSize);
			}
		}
		
		subtreeSize[curr] = size-1;
		
		return size;
	}

}
