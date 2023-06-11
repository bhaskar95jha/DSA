package algouGraph.MST;

import java.io.*;
import java.util.*;

class Cordinates{
	long x;
	long y;
	long z;
	
	public Cordinates(long x, long y, long z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

class Pairs{
	long first;
	long second;
	
	public Pairs(long first, long second) {
		this.first = first;
		this.second = second;
	}
	
}

class WeightNodeParents implements Comparable<WeightNodeParents>{
	long weight;
	long node;
	long parent;
	
	public WeightNodeParents(long weight, long node, long parent) {
		this.weight = weight;
		this.node = node;
		this.parent = parent;
	}

	@Override
	public int compareTo(WeightNodeParents wnp) {
		return Long.compare(this.weight, wnp.weight);
	}
}

public class ConnectingRoads {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<List<Pairs>> adjList = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			adjList.add(new ArrayList<>());
		}
		
		List<Cordinates> cordinateList = new ArrayList<>();
		int road = n;
		while(road-- > 0) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			long z = Long.parseLong(st.nextToken());
			cordinateList.add(new Cordinates(x, y, z));
		}
		
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				long price = m * (
						Math.abs(cordinateList.get(i).x-cordinateList.get(j).x) +
						Math.abs(cordinateList.get(i).y-cordinateList.get(j).y) +
						Math.abs(cordinateList.get(i).z-cordinateList.get(j).z)
						);
				adjList.get(i).add(new Pairs(j,price));
				adjList.get(j).add(new Pairs(i,price));
			}
		}
		
		
		prims(adjList,n);
	}

	private static void prims(List<List<Pairs>> adjList, int n) {
		// TODO Auto-generated method stub
		PriorityQueue<WeightNodeParents> pq = new PriorityQueue<>();
		int vis[] = new int[n];
		List<Pairs> mst = new ArrayList<>();
		pq.add(new WeightNodeParents(0, 0, -1));
		long sum = 0;
		
		while(!pq.isEmpty()) {
			WeightNodeParents wnp = pq.poll();
			if(vis[(int) wnp.node]==0) {
				vis[(int) wnp.node] = 1;
				if(wnp.parent != -1) {
					mst.add(new Pairs(wnp.parent,wnp.node));
				}
				sum += wnp.weight;
				
				for(Pairs child:adjList.get((int)wnp.node)) {
					if(vis[(int) child.first]==0) {
						pq.add(new WeightNodeParents(child.second, child.first, wnp.node));
					}
				}
				
			}
		}
		
		System.out.println(sum);
		
	}

}
