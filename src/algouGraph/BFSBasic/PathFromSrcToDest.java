package algouGraph.BFSBasic;

import java.util.*;

public class PathFromSrcToDest {

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
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjList.get(src).add(dest);
			adjList.get(dest).add(src);
		}
		int src = sc.nextInt();
		int dest = sc.nextInt();
		int vis[] = new int[n+1];
		int parent[] = new int[n+1];
		parent = bfsPath(adjList,src,vis);
		List<Integer> li = new ArrayList<>();
		int curr = dest;
		while(curr != -1) {
			li.add(curr);
			curr = parent[curr];
		}
		
		Collections.reverse(li);
		System.out.println("Path from "+src+" to "+dest);
		li.stream().forEach( ele -> System.out.print(ele+"-> "));
		sc.close();
	}

	private static int[] bfsPath(List<List<Integer>> adjList, int src, int[] vis) {
		int parent[] = new int[vis.length];
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
