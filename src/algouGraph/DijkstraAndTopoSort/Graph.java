package algouGraph.DijkstraAndTopoSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Graph {
    private int numNodes;
    private List<List<Integer>> adjacencyList;

    public Graph(int numNodes) {
        this.numNodes = numNodes;
        adjacencyList = new ArrayList<>(numNodes + 1);
        for (int i = 0; i <= numNodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int a, int b) {
        adjacencyList.get(a).add(b);
    }

    public List<Integer> findNodesWithoutCycles() {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 1; i <= numNodes; i++) {
            if (!visited.contains(i)) {
                boolean hasCycle = dfs(i, visited);
                if (!hasCycle) {
                    result.add(i);
                }
            }
        }

        return result;
    }

    private boolean dfs(int node, Set<Integer> visited) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> dfsVisited = new HashSet<>();

        stack.push(node);

        while (!stack.isEmpty()) {
            int currNode = stack.pop();

            if (!dfsVisited.contains(currNode)) {
                visited.add(currNode);
                dfsVisited.add(currNode);

                for (int neighbor : adjacencyList.get(currNode)) {
                    if (dfsVisited.contains(neighbor)) {
                        return true;  // Cycle found, break the loop
                    }
                    stack.push(neighbor);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int numNodes = 6;
        Graph graph = new Graph(numNodes);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        List<Integer> result = graph.findNodesWithoutCycles();

        System.out.println("Nodes without cycles:");
        for (int node : result) {
            System.out.print(node + " ");
        }
    }
}

