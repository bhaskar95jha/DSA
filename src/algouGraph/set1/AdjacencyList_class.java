package algouGraph.set1;

import java.util.ArrayList;
import java.util.Scanner;

class Graph_List {
    int vertices;
    ArrayList<ArrayList<Integer>> adjList;
    public Graph_List(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<Integer>());
        }
    }
    public void addEdge(int i, int j) {
        // add an edge from i to j here
        // unweighted and undirected
        adjList.get(i).add(j);
        adjList.get(j).add(i);
        // TRY :: unweighted and directed
        // TRY :: directed and weighted
    }
    public void removeEdge(int i, int j) {
        // remove an edge from i to j
        int index = -1;
        // removing the connection bt i->j
        for(int children: adjList.get(i)){
            index ++;
            if(children == j){
                adjList.get(i).remove(index);
                break;
            }
        }
        index = -1;
        // removing the connection bt j->i
        for(int children: adjList.get(j)){
            index ++;
            if(children == i){
                adjList.get(j).remove(index);
                break;
            }
        }
    }
    public boolean isEdge(int i, int j) {
        // check if an edge exists from i to j
        for(int children: adjList.get(i)){
            if(children == j){
                return true;
            }
        }
        return false;
    }
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

public class AdjacencyList_class{
    public static void main(String args[]){
        Graph_List g;
        try (Scanner sc = new Scanner(System.in)) {
            int vertices = sc.nextInt();
            g = new Graph_List(vertices);
            int edges = sc.nextInt();
            for (int i = 0; i < edges; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                g.addEdge(v1, v2);
            }
            g.addEdge(1, 0);
            g.printGraph();
            g.removeEdge(1, 0);
            g.printGraph();
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
}