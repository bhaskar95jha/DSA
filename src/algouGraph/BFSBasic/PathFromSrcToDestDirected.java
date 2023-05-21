package algouGraph.BFSBasic;

import java.util.*;
class Pair{
	int src;
	int dest;
	public Pair(int src, int dest) {
		this.src = src;
		this.dest = dest;
	}	
}

public class PathFromSrcToDestDirected {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<List<Integer>> adjList = new ArrayList<>();
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		Map<Pair,String> roadName = new HashMap<>();
		while(m-->0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			String rName = sc.next();
			adjList.get(u).add(v);
			Pair p = new Pair(u, v);
			roadName.put(p, rName);
		}
		int src = sc.nextInt();
		int dest = sc.nextInt();
		int visited[] = new int[n+1];
		int parent[] = new int[n+1];
		parent = bfsPathDirected(adjList,src,visited);
		List<Integer> path = new ArrayList<>();
		int temp = dest;
		while(temp != -1) {
			if(temp == 0) {
				System.out.println("Impossible");
				return;
			}
			path.add(temp);
			temp = parent[temp];
		}
		Collections.reverse(path);
		System.out.println(path.size()-1);
		for(int i=1;i<path.size();i++) {
			int u = path.get(i-1);
			int v = path.get(i);
			String rName = "";
			Pair p = new Pair(u,v);
			for(Pair pair:roadName.keySet()) {
				if(pair.src == u && pair.dest==v) {
					rName = roadName.get(pair);
				}
			}
			System.out.println(rName);
		}
		
	}

	private static int[] bfsPathDirected(List<List<Integer>> adjList, int src, int[] vis) {
		int []parent = new int[vis.length];
		Deque<Integer> q = new ArrayDeque<>();
		q.add(src);
		parent[src] = -1;
		vis[src] = 1;
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int child:adjList.get(curr)) {
				if(vis[child]==0) {
					vis[child] = 1;
					q.add(child);
					parent[child] = curr;
				}
			}
		}
		return parent;
	}

	
	
}
