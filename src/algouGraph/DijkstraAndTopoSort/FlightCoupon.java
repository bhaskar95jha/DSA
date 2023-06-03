package algouGraph.DijkstraAndTopoSort;

import java.io.*;
import java.util.*;

class PathWeight{
	int src;
	int dest;
	int weight;
	public PathWeight(int src, int dest, int weight) {
		
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
	
}


public class FlightCoupon {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<List<Pair>> adjList = new ArrayList<>();
		List<PathWeight> pathweight = new ArrayList<>();
		
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			Pair destWeight = new Pair(v,w);
			pathweight.add(new PathWeight(u, v, w));
			adjList.get(u).add(destWeight);	
		}
		int src = 1;
		int distFrmSrc[] = new int[n+1];
		int parent[] = new int[n+1];
		Arrays.fill(parent, -1);
		//min cost from src to dest
		distFrmSrc = dijKstra(adjList,n,src,parent);
		
		//making path from src to dest
		int temp = n;
		List<Integer> path = new ArrayList<>();
		while(temp != -1) {
			path.add(temp);
			temp = parent[temp];
		}
		Collections.reverse(path);
		
		//creating list of fare which path gave us minimum cost
		List<Integer> weightList = new ArrayList<>();
		for(int i=0;i<path.size()-1;i++) {
			src = path.get(i);
			int dest = path.get(i+1);
			for(PathWeight pw:pathweight) {
				if(src == pw.src && dest == pw.dest) {
					weightList.add(pw.weight);
				}
			}
		}
		
		//finding the maximum fair
		int max = Integer.MIN_VALUE;
		for(int ele:weightList) {
			max = Math.max(ele, max);
		}
		
		//half the and calculate total fare
		long ans = 0;
		int flag = 0;
		for(int ele:weightList) {
			if(flag == 0 && ele == max) {
				ans += (ele/2);
				flag = 1;
			}
			else
				ans += ele;
		}
		System.out.println(ans);
		
	}

	private static int[] dijKstra(List<List<Pair>> adjList, int n, int src,int []parent) {
		int dist[] = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[src] = 0;
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(dist[src],src));
		
		while(!pq.isEmpty()) {
			Pair curr = pq.poll();
			int distFromsrc = curr.first;
			int currNode = curr.second;
			if(distFromsrc != dist[currNode])
				continue;
			for(Pair child:adjList.get(currNode)) {
				int childNode = child.first;
				int childWeight = child.second;
				if(dist[childNode]>childWeight+dist[currNode]) {
					dist[childNode] = childWeight+dist[currNode];
					parent[childNode] = currNode;
					pq.add(new Pair(dist[childNode],childNode));
				}
			}
		}
		
		return dist;
	}

}
