package algouGraph.DFSBasic;

import java.util.*;

public class MostProfitableTeam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<List<Integer>> adjList = new ArrayList<>();
		for(int i=0;i<n+1;i++) {
			adjList.add(new ArrayList<>());
		}
		for(int i=2;i<n+1;i++) {
			int j = sc.nextInt();
			adjList.get(j).add(i);
		}
	}

}
