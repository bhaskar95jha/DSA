package algouGraph.DFSBasic;

import java.util.*;

public class HeightOfNodeInATree {

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
		
		sc.close();
		
		//Map<Integer, Integer> heightMap = new HashMap<>();
		int heightMap[] = new int[n+1];
		int vis[] = new int[n+1];
		dfs(adjList,vis,start,heightMap,1);
		
//		for(Entry<Integer, Integer> entry:heightMap.entrySet()) {
//			System.out.println("Height of Node : "+entry.getKey()+" is : "+entry.getValue());
//		}
		int count = 0;
		for(int entry:heightMap) {
			System.out.println("Height of Node : "+ count++ +" is : "+entry);
		}
	}

	private static void dfs(List<List<Integer>> adjList, int[] vis, int curr, int[] heightMap,int height) {
		// TODO Auto-generated method stub
		heightMap[curr] = height;
		vis[curr] = 1;
		
		for(int child:adjList.get(curr)) {
			if(vis[child] == 0) {
				dfs(adjList,vis,child,heightMap,height+1);
			}
		}
		
	}

}
