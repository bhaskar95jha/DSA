package algouGraph.BFSBasic;

import java.util.*;

public class NumberOfProvience_ConnectedComponent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		while(m-->0) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjList.get(src).add(dest);
			adjList.get(dest).add(src);
		}
		sc.close();
		int ans = bfsConnectedComponent(adjList,n);
		System.out.println(ans);
	}

	private static int bfsConnectedComponent(ArrayList<ArrayList<Integer>> adjList, int n) {
		// TODO Auto-generated method stub
		int vis[] = new int[n+1];
		Deque<Integer> q = new ArrayDeque<>();
		int count = 0;
		for(int i = 1;i<=n;i++) {
			if(vis[i]==0) {
				vis[i] = 1;
				q.add(i);
				count++;
				while(!q.isEmpty()) {
					int curr = q.poll();
					for(int child:adjList.get(curr)) {
						if(vis[child]==0) {
							vis[child] = 1;
							q.add(child);
						}
					}
				}
			}
		}
		
		
		return count;
	}

}
