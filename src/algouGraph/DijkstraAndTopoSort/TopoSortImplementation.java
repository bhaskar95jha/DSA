package algouGraph.DijkstraAndTopoSort;

import java.io.*;
import java.util.*;

public class TopoSortImplementation {

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
		}
		
		//check for cycle in directed setting
		int vis[] = new int[n+1];
		for(int i=1;i<n+1;i++){
            if(vis[i]==0){
                if(checkCycle(adjList,i,vis)==true){
                	System.out.println("Toposort Not Possible");
                	return;
                }
            }
        }
		
		vis = new int[n+1];
		List<Integer> dfsList = new ArrayList<>();
		for(int i=1;i<n+1;i++){
            if(vis[i]==0){
                dfs(adjList,i,vis,dfsList);
            }
        }
		
		Collections.reverse(dfsList);
		
		for(int ele:dfsList) {
			System.out.print(ele+" ");
		}
		
		
		
	}
	
	private static void dfs(List<List<Integer>> adjList, int src, int[] vis, List<Integer> dfsList) {
		// TODO Auto-generated method stub
		vis[src] = 1;
		
		for(int child:adjList.get(src)) {
			if(vis[child]==0) {
				dfs(adjList,child,vis,dfsList);
			}
		}
		dfsList.add(src);
	}

	private static boolean checkCycle(List<List<Integer>> adjList, int src, int[] vis) {
		// TODO Auto-generated method stub
		
		vis[src] = 1;
		
		for(int child:adjList.get(src)) {
			if(vis[child]==1 && vis[src]==1) {
				return true;
			}
			if(vis[child]==0) {
				if(checkCycle(adjList,child,vis)==true) {
					return true;
				}
			}
		}
		
		vis[src] = 2;
		
		return false;
	}

}
