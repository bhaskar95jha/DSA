package algouGraph.DijkstraAndTopoSort;

import java.io.*;
import java.util.*;

class Pairs implements Comparable<Pairs>{
	int first;
	int second;

	public Pairs() {
		
	}
	
	public Pairs(int first, int second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public int compareTo(Pairs p) {
		// TODO Auto-generated method stub
		return Integer.compare(this.first, p.first);
	}
	
}

public class Nirvana {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<List<Pairs>> adjList = new ArrayList<>();
		
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			Pairs destWeight = new Pairs(v,w);
	
			adjList.get(u).add(destWeight);	
		}
		int src = 1;
		int dist[] = new int[n+1];
		dist = dijKstra(adjList,n,src);
		
		for(int ele:dist) {
			System.out.print(ele+" ");
		}
	}

	private static int[] dijKstra(List<List<Pairs>> adjList, int n, int src) {
		
		int dist[] = new int[n+1];
		//initialize distance with infinity 
		Arrays.fill(dist, Integer.MAX_VALUE);
		int parent[] = new int[n+1];
		//initialize parent with -1
		Arrays.fill(parent,-1);
		
		
		dist[src] = 0;
		
		//first is distance and second is node
		PriorityQueue<Pairs> pq = new PriorityQueue<>();
		
		pq.add(new Pairs(dist[src],src));
		while(!pq.isEmpty()) {
			Pairs curr = pq.poll();
			int distOfCurrNodeFromSrc = curr.first;
			int currNode = curr.second;
			
			if(distOfCurrNodeFromSrc != dist[currNode])
				continue;
			
			for(Pairs child:adjList.get(currNode)) {
				int childNode = child.first;
				int childWeight = child.second;
				if(dist[childNode]>dist[currNode]+childWeight) {
					dist[childNode] = dist[currNode]+childWeight;
					parent[childNode] = currNode;
					pq.add(new Pairs(dist[childNode],childNode));
				}
			}
			
		}
		return dist;	
	}

}
