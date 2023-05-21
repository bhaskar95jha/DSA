package AlgoUStack;

import java.util.*;

class Edge{
	String src;
	String dest;
	String roadName;
	public Edge() {
		
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	
}

public class TripToAlgoLand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Map<String, List<String>> adjList = new HashMap<>();
		List<Edge> cityRoadName = new ArrayList<>();
		while(m-->0) {
			String u = sc.next();
			String v = sc.next();
			String l = sc.next();
			
			Edge edge = new Edge();
			edge.setSrc(u);
			edge.setDest(v);
			edge.setRoadName(l);
			cityRoadName.add(edge);
			
			adjList.putIfAbsent(u, new ArrayList<>());
			adjList.get(u).add(v);
		}
		String src = sc.next();
		String dest = sc.next();
		Set<String> vis = new HashSet<>();

		Map<String,String> parentOf = bfs(adjList,vis,src);
		String temp = dest;
		List<String> city = new ArrayList<>();
		while(!temp.equals("grandPa")) {
			city.add(temp);
			if(parentOf.containsKey(temp))
				temp = parentOf.get(temp);
			else {
				System.out.println("Impossible");
				return;
			}
		}
		
		Collections.reverse(city);
		System.out.println(city.size()-1);
		for(int i=1;i<city.size();i++) {
			String s = city.get(i-1);
			String d = city.get(i);
			for(Edge edge:cityRoadName) {
				if(edge.src.equalsIgnoreCase(s) && edge.dest.equalsIgnoreCase(d)) {
					System.out.println(edge.roadName);
				}
			}
		}
		
	}

	private static Map<String,String> bfs(Map<String, List<String>> adjList, Set<String> vis, String src) {
		Deque<String> q = new ArrayDeque<>();
		Map<String,String> parentOf = new HashMap<>();
		q.add(src);
		vis.add(src);
		parentOf.put(src,"grandPa");
		
		while(!q.isEmpty()) {
			String curr = q.poll();
			for(String child:adjList.getOrDefault(curr, new ArrayList<>())) {
				if(!vis.contains(child)) {
					vis.add(child);
					q.add(child);
					//this will give me the parent of all nodes
					parentOf.put(child, curr);
				}
			}
		}
		
		return parentOf;
	}

}
