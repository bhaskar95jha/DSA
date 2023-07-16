package hackerearth.graph;

import java.io.*;
import java.util.*;


class Pair implements Comparable<Pair>{
	long first;
	long second;

	public Pair() {
		
	}
	
	public Pair(long first, long second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public int compareTo(Pair p) {
		// TODO Auto-generated method stub
		return Long.compare(this.first, p.first);
	}
	
}
public class ShortestPathAgain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		List<List<Pair>> adjList = new ArrayList<>();
		
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			long u = Long.parseLong(st.nextToken());
			long v = Long.parseLong(st.nextToken());
			long w = Long.parseLong(st.nextToken());
			
			Pair destWeight = new Pair(v,w);
			adjList.get((int)u).add(destWeight);
			Pair srcWeight = new Pair(u,w);
			adjList.get((int)v).add(srcWeight);
			
		}
		
		int src = 1;
		
		long distFrmSrc[] = new long[(int) (n+1)];
		distFrmSrc = dijKstra(adjList,n,src);
		
		for(long ele:distFrmSrc) {
			System.out.println(ele);
		}
	}
	
	private static long[] dijKstra(List<List<Pair>> adjList, long n, long src) {
		
		long dist[] = new long[(int) (n+1)];
		Arrays.fill(dist, Long.MAX_VALUE);
		
		dist[(int) src] = 0;
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(dist[(int) src],(long)src));
		
		while(!pq.isEmpty()) {
			Pair curr = pq.poll();
			long distFromsrc = curr.first;
			long currNode = curr.second;
			if(distFromsrc != dist[(int)currNode])
				continue;
			for(Pair child:adjList.get((int)currNode)) {
				long childNode = child.first;
				long childWeight = child.second;
				if(dist[(int) childNode]>childWeight+dist[(int) currNode]) {
					dist[(int) childNode] = childWeight+dist[(int) currNode];
					pq.add(new Pair(dist[(int) childNode],childNode));
				}
			}
		}	
		return dist;
	}

}
