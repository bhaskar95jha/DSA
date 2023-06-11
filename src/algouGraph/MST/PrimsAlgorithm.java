package algouGraph.MST;

import java.io.*;
import java.util.*;

class Pair{
	int first;
	int second;

	public Pair() {
		
	}
	
	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
	
}

class WeightNodeParent implements Comparable<WeightNodeParent>{
	int weight;
	int node;
	int parent;
	
	public WeightNodeParent(int weight, int node, int parent) {
		this.weight = weight;
		this.node = node;
		this.parent = parent;
	}

	@Override
	public int compareTo(WeightNodeParent wnp) {
		return Integer.compare(this.weight, wnp.weight);
	}
}

public class PrimsAlgorithm {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<List<Pair>> adjList = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
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
		int vis[] = new int[n];
		List<Pair> mst = new ArrayList<>();
		pq.add(new WeightNodeParent(0, 0, -1));
		int sum = 0;
		
		while(!pq.isEmpty()) {
			WeightNodeParent wnp = pq.poll();
			if(vis[wnp.node]==0) {
				vis[wnp.node] = 1;
				if(wnp.parent != -1) {
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
		
		System.out.println(sum);
		for(Pair edge:mst) {
			System.out.println(edge.first+" -> "+edge.second);
		}
	}

}
