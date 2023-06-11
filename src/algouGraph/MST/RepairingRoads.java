package algouGraph.MST;

import java.io.*;
import java.util.*;


public class RepairingRoads {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<List<Pair>> adjList = new ArrayList<>();
		
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			Pair destWeight = new Pair(v,w);
			adjList.get(u).add(destWeight);
			Pair srcWeight = new Pair(u,w);
			adjList.get(v).add(srcWeight);
		}
		
		prims(adjList,n);
	}

	private static void prims(List<List<Pair>> adjList, int n) {
		// TODO Auto-generated method stub
		PriorityQueue<WeightNodeParent> pq = new PriorityQueue<>();
		int vis[] = new int[n+1];
		List<Pair> mst = new ArrayList<>();
		pq.add(new WeightNodeParent(0, 1, 0));
		long sum = 0;
		
		while(!pq.isEmpty()) {
			WeightNodeParent wnp = pq.poll();
			if(vis[wnp.node]==0) {
				vis[wnp.node] = 1;
				if(wnp.parent != 0) {
					mst.add(new Pair(wnp.parent,wnp.node));
				}
				sum += wnp.weight;
				
				for(Pair child:adjList.get(wnp.node)) {
					if(vis[child.first]==0) {
						pq.add(new WeightNodeParent(child.second, child.first, wnp.node));
					}
				}
				
			}
		}
		if(mst.size()==n-1) {
			System.out.println(sum);
		}
		else {
			System.out.println("IMPOSSIBLE");
		}
		
	}

}
