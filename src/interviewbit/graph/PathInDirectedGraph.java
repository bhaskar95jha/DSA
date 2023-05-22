package interviewbit.graph;

import java.io.*;
import java.util.*;

public class PathInDirectedGraph {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adjList.get(u).add(v);
			
		}
		st = new StringTokenizer(br.readLine());
		int dest = Integer.parseInt(st.nextToken());
		int ans = solve(dest,adjList);
		System.out.println(ans);
	}

	private static int solve(int A, ArrayList<ArrayList<Integer>> B) {
		//process the input that come from the machine
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<=A; i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(ArrayList<Integer> edge : B){
            int src = edge.get(0);
            int dest = edge.get(1);
            adjList.get(src).add(dest);
        }
        int dest = A;
        
        //bfs start here 
		Set<Integer> vis = new HashSet<>();
		Deque<Integer> q = new ArrayDeque<>();
		
		vis.add(1);
		q.add(1);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int child:adjList.get(curr)) {
				if(!vis.contains(child)) {
					q.add(child);
					vis.add(child);
				}
			}
		}
		return vis.contains(dest)?1:0;
	}

}
