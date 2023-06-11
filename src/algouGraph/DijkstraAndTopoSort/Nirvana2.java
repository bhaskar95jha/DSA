package algouGraph.DijkstraAndTopoSort;

import java.io.*;
import java.util.*;

public class Nirvana2 {
	
	static List<List<Integer>> adjList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adjList.get(u).add(v);
			
		}
		
		List<Integer> result = findNodesWithoutCycles(n);

        System.out.print(result.size()+" ");
        for (int node : result) {
            System.out.print(node + " ");
        }
		
	}
	
	static public List<Integer> findNodesWithoutCycles(int n) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
            	visited = new HashSet<>();
                boolean hasCycle = dfs(i, visited);
                if (!hasCycle) {
                    result.add(i);
                }
            }
        }

        return result;
    }

    private static boolean dfs(int node, Set<Integer> visited) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> dfsVisited = new HashSet<>();

        stack.push(node);

        while (!stack.isEmpty()) {
            int currNode = stack.pop();

            if (!dfsVisited.contains(currNode)) {
                visited.add(currNode);
                dfsVisited.add(currNode);

                for (int neighbor : adjList.get(currNode)) {
                    if (dfsVisited.contains(neighbor)) {
                        return true;  // Cycle found, break the loop
                    }
                    stack.push(neighbor);
                }
            }
        }
        visited.remove(node);
        return false;
    }


}
