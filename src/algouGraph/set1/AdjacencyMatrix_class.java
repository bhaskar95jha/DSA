package algouGraph.set1;

import java.util.Scanner;

class Graph_Matrix {
	
	int[][] adjMatrix;
	int vertices;
	
	public Graph_Matrix(int vertices) {
		this.vertices = vertices;
		adjMatrix = new int[vertices+1][vertices+1];
	}
	
	public void addEdge(int i,int j) {
		//undirected and unweighted graph
		adjMatrix[i][j] = 1;
		adjMatrix[j][i] = 1;
		//directed and unweighted
		//adjMatrix[i][j] = 1;
		//undirected and weighted graph (w)
        // adjMatrix[i][j] = w;
        // adjMatrix[j][i] = w;
        //directed and weighted graph (w)
        // adjMatrix[i][j] = w;
	}
	
	public void removeEdge(int i,int j) {
		//undirected
		adjMatrix[i][j] = 0;
		adjMatrix[j][i] = 0;
		//directed
		//adjMatrix[i][j] = 0;
	}
	
	public boolean isEdge(int i,int j) {
		return adjMatrix[i][j] != 0;
	}
	
	public void printGraph() {
		// TODO Auto-generated method stub
		for(int i=0;i<=vertices;i++) {
			System.out.println("vertex "+ i +" is connected to:");
			for(int j=0;j<=vertices;j++) {
				if(adjMatrix[i][j]==1) {
					System.out.print(j+" ");
				}
			}
			System.out.println();
		}
	}
}

public class AdjacencyMatrix_class {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph_Matrix g;
		Scanner sc = new Scanner(System.in);
		System.out.println("No. of vertex");
		int vertices = sc.nextInt();
		g = new Graph_Matrix(vertices);
		System.out.println("No. of edges");
		int edges = sc.nextInt();
		for(int i=0;i<edges;i++) {
			System.out.println("src and dest");
			g.addEdge(sc.nextInt(),sc.nextInt());
		}
		g.printGraph();
	}

}
