package algouGraph.set1;

import java.util.*;

class Edge{
	int src;
	int dest;
	Edge(int src,int dest){
		this.src = src;
		this.dest = dest;
	}
}

class Graph{
	List<List<Integer>> adjList = new ArrayList<>();
	public Graph(List<Edge> edges) {
		//find the maximum numbered vertex
		int n = 0;
		for(Edge e:edges) {
			n = Integer.max(n, Integer.max(e.src, e.dest));
		}
		//allocate memory for the adjacency list
		for(int i=0;i<=n;i++) {
			adjList.add(i, new ArrayList<>());
		}
		
		for(Edge current:edges) {
			// allocate new node in adjacency list from src to dest
			adjList.get(current.src).add(current.dest);
			// allocate new node in adjacency list from dest to src
			//adjList.get(current.dest).add(current.src);
		}
	}
	
	public static void printGraph(Graph graph) {
		int src = 0;
		int n = graph.adjList.size();
		while(src<n) {
			for(int dest:graph.adjList.get(src)) {
				System.out.print("("+ src + "->"+dest+")\t");
			}
			System.out.println();
			src++;
		}
	}
}




public class AdjacenyListImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Edge> edges = Arrays.asList(
				new Edge(0,1),
				new Edge(1,2),
				new Edge(2,0),
				new Edge(2,1),
				new Edge(3,2),
				new Edge(4,5),
				new Edge(5,4)
				);
		
		//construct a graph
		Graph graph = new Graph(edges);
		
		Graph.printGraph(graph);
	}
	
	

}
