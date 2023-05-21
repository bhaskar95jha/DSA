package algouGraph.DFSBasic;

import java.util.*;

public class RedAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		//System.out.println(n+" "+c);
		
		List<List<Integer>> adjList = new ArrayList<>();
		
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		int degree[] = new int[n+1];
		
		int fireNode[] = new int[n+1];
		for(int i=1;i<n+1;i++) {
			fireNode[i] = sc.nextInt();
		}
		int vis[] = new int[n+1];
		while(n-- > 1) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			degree[u]++;
			degree[v]++;
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		
		
		
		List<Integer> dfsList = new ArrayList<>();
		
		
		boolean ans = dfs(adjList,1,vis,c,fireNode,dfsList,c);
	
		System.out.println(dfsList);
		int count = 0;
		for(int ele:dfsList) {
			if(degree[ele]==1) {
				count++;
			}
		}
		System.out.println(count);
		
		sc.close();
	}
	
	private static boolean dfs(List<List<Integer>> adjList, int curr, int[] vis, int k,int[] fireNode,List<Integer> dfsList,int temp) {
		dfsList.add(curr);
		if(k<=0) {
			return false;
		}
		
		vis[curr] = 1;
		
		for(int child:adjList.get(curr)) {
			if(vis[child]==0) {
				if(fireNode[child]==1) {
					if(dfs(adjList,child,vis,k-1,fireNode,dfsList,temp)==true) {
						return true;
					}
				}else {
					if(dfs(adjList,child,vis,temp,fireNode,dfsList,temp)== true) {
						return true;
					}
				}
			}
		}
		
		return false;
		
	}

}
