package algouGraph.MST;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
	
	int weight;
	int src;
	int dest;
	
	public Edge(int weight, int src, int dest) {
		this.weight = weight;
		this.src = src;
		this.dest = dest;
	}

	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.weight);
	}
	
}

public class KruskalsAlgorithm {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Edge> edges = new ArrayList<>();
		
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			Edge edge = new Edge(w,u,v); 
			edges.add(edge);
		}
		Collections.sort(edges);
		kruskals(edges,n);
	}

	private static void kruskals(List<Edge> edges, int n) {
		DisjointSet dsu = new DisjointSet(n);
		int mst = 0;
		for(Edge edge:edges) {
			if(dsu.findUPar(edge.src)!=dsu.findUPar(edge.dest)) {
				mst += edge.weight;
				dsu.unionByRank(edge.src, edge.dest);
			}
		}
		System.out.println(mst);
	}

}
