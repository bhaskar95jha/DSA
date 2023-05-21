package algouGraph.BFSBasic;

import java.util.*;

public class MinimumDistanceFromHospitals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<List<Integer>> adjList = new ArrayList<>();
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		while(m-->0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		List<Integer> hospitalList = new ArrayList<>();
		hospitalList.add(4);
		hospitalList.add(3);
		
		int ans[] = new int[n+1];
		ans = bfs(adjList,n+1,hospitalList);
		System.out.println("Approach #1 Minimum dist from hospital to each city is");
		for(int i=1;i<ans.length;i++) {
			System.out.print(ans[i]+" ");
		}
		System.out.println();
		ans = new int[n+1];
		ans = bfsHospitals(adjList,n+1,hospitalList);
		System.out.println("Approach #2 Minimum dist from hospital to each city is");
		for(int i=1;i<ans.length;i++) {
			System.out.print(ans[i]+" ");
		}
		System.out.println();
		ans = new int[n+1];
		ans = bfsImaginaryNode(adjList,n+1,hospitalList);
		System.out.println("Approach #3 Minimum dist from hospital to each city is");
		for(int i=1;i<ans.length;i++) {
			System.out.print(ans[i]+" ");
		}
		System.out.println();
	}

	private static int[] bfsImaginaryNode(List<List<Integer>> adjList, int n, List<Integer> hospitalList) {
		
		int dist[] = new int[n];
		int vis[] = new int[n];
		Deque<Integer> q = new ArrayDeque<>();
		
		for(int hospital:hospitalList) {
			int src = hospital;
			q.add(src);
			vis[src] = 1;
			dist[src] = 0;	
		}
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int child:adjList.get(curr)) {
				if(vis[child]==0) {
					q.add(child);
					vis[child] = 1;
					dist[child] = dist[curr] + 1;
				}
			}
		}
		return dist;
	}

	private static int[] bfsHospitals(List<List<Integer>> adjList, int n, List<Integer> hospitalList) {
		int ans[] = new int[n];
		for(int i=0;i<ans.length;i++) {
			ans[i] = Integer.MAX_VALUE;
		}
		for(int hospital:hospitalList) {
			int dist[] = new int[n];
			int vis[] = new int[n];
			int src = hospital;
			Deque<Integer> q = new ArrayDeque<>();
			q.add(src);
			vis[src] = 1;
			dist[src] = 0;
			while(!q.isEmpty()) {
				int curr = q.poll();
				for(int child:adjList.get(curr)) {
					if(vis[child]==0) {
						q.add(child);
						vis[child] = 1;
						dist[child] = dist[curr] + 1;
					}
				}
			}
			
			for(int i=0;i<n;i++) {
				ans[i] = Math.min(ans[i],dist[i]);
			}
		}
		return ans;
		
	}

	private static int[] bfs(List<List<Integer>> adjList, int n,List<Integer> hospitalList) {
		// TODO Auto-generated method stub
		int ans[] = new int[n];
		for(int i = 1;i<n;i++) {
			int dist[] = new int[n];
			int vis[] = new int[n];
			int src = i;
			Deque<Integer> q = new ArrayDeque<>();
			q.add(src);
			vis[src] = 1;
			dist[src] = 0;
			while(!q.isEmpty()) {
				int curr = q.poll();
				for(int child:adjList.get(curr)) {
					if(vis[child]==0) {
						q.add(child);
						vis[child] = 1;
						dist[child] = dist[curr] + 1;
					}
				}
			}
			int min = Integer.MAX_VALUE;
			for(int hospital:hospitalList) {
				int h1 = dist[hospital];
				min = Math.min(h1, min);
			}
			ans[i] = min;
		}
		return ans;
	}

}
