package algouGraph.DFSBasic;

import java.util.*;

public class KConsecutiveBlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		List<List<Integer>> adjList = new ArrayList<>();
		
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		int degree[] = new int[n+1];
		
		while(m-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			degree[u]++;
			degree[v]++;
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		int start = 1;
		int k = 1;
		int vis[] = new int[n+1];
		int fireNode[] = {0,1,0,1,1,1,1,1,0,0,0,0,0,1};
		List<Integer> dfsList = new ArrayList<>();
		
		
		boolean ans = dfs(adjList,start,vis,k,fireNode,dfsList,degree);
	
		System.out.println(dfsList);
		for(int ele:dfsList) {
			if(degree[ele]==1) {
				System.out.println("YES Reached : "+ele);
				return;
			}
		}
		System.out.println("No");
		
		sc.close();
	}

	private static boolean dfs(List<List<Integer>> adjList, int curr, int[] vis, int k,int[] fireNode,List<Integer> dfsList,int[] deg) {
		dfsList.add(curr);
		if(k<=0) {
			return false;
		}
		
		if(deg[curr]==1) {
			return true;
		}
		
		vis[curr] = 1;
		
		for(int child:adjList.get(curr)) {
			if(vis[child]==0) {
				if(fireNode[child]==1) {
					if(dfs(adjList,child,vis,k-1,fireNode,dfsList,deg)==true) {
						return true;
					}
				}else {
					if(dfs(adjList,child,vis,1,fireNode,dfsList,deg)== true) {
						return true;
					}
				}
			}
		}
		
		return false;
		
	}

}
