package algouGraph.MST;

import java.util.*;

class DisjointSet{
	List<Integer> rank = new ArrayList<>();
	List<Integer> parent = new ArrayList<>();
	public DisjointSet(int n) {
		for(int i=0;i<=n;i++) {
			rank.add(0);
			parent.add(i);
		}
	}
	
	public int findUPar(int n) {
		if(n==parent.get(n)) {
			return n;
		}
		int ulp = findUPar(parent.get(n));
		parent.set(n, ulp);
		return parent.get(n);
	}
	
	public void unionByRank(int u,int v) {
		int ulp_u = findUPar(u);
		int ulp_v = findUPar(v);
		if(ulp_u==ulp_v)
			return;
		
		if(rank.get(ulp_u)<rank.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
		}else if(rank.get(ulp_u)>rank.get(ulp_v)){
			parent.set(ulp_v, ulp_u);
		}else {
			parent.set(ulp_v, ulp_u);
			int rankU = rank.get(ulp_u);
			rank.set(ulp_u, rankU+1);
		}
	}
 }

public class DisjointSetUnionByRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisjointSet dsu = new DisjointSet(7);
		dsu.unionByRank(1, 2);
		dsu.unionByRank(2, 3);
		dsu.unionByRank(4, 5);
		dsu.unionByRank(6, 7);
		dsu.unionByRank(5, 6);
		//if 3 and 7 are in same component
		if(dsu.findUPar(3)==dsu.findUPar(7)) {
			System.out.println("same");
		}else {
			System.out.println("Not Same");
		}
		dsu.unionByRank(3, 7);
		
		if(dsu.findUPar(3)==dsu.findUPar(7)) {
			System.out.println("same");
		}else {
			System.out.println("Not Same");
		}
	}

}
