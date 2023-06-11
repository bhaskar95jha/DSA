package algouGraph.DijkstraAndTopoSortContest;

import java.io.*;
import java.util.*;

public class TravellingKing {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		
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
			Pairs reverse = new Pairs(u,w);
			adjList.get(u).add(destWeight);
			adjList.get(v).add(reverse);
		}
		
		List<Integer> destList = new ArrayList<>();
		while(q-->0) {
			st = new StringTokenizer(br.readLine());
			int dest = Integer.parseInt(st.nextToken());
			destList.add(dest);
		}
		
		int dist[] = new int[n+1];
		dist = dijKstra(adjList,n,c);
		
		for(int dest:destList) {
			  if(dist[dest] == Integer.MAX_VALUE)
				  System.out.println("-1");
				else
				  System.out.println(dist[dest]);
		}
	}

	private static int[] dijKstra(List<List<Pairs>> adjList, int n, int src) {
		// TODO Auto-generated method stub
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
