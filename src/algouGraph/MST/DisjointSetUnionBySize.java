package algouGraph.MST;

import java.util.*;

class DisjointSetSize{
	List<Integer> size = new ArrayList<>();
	List<Integer> parent = new ArrayList<>();
	public DisjointSetSize(int n) {
		for(int i=0;i<=n;i++) {
			size.add(1);
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
	
	public void unionBySize(int u,int v) {
		int ulp_u = findUPar(u);
		int ulp_v = findUPar(v);
		if(ulp_u==ulp_v)
			return;
		
		if(size.get(ulp_u)<size.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
			size.set(ulp_v, size.get(ulp_v)+ size.get(ulp_u));
		}else {
			parent.set(ulp_v, ulp_u);
			size.set(ulp_u, size.get(ulp_v)+ size.get(ulp_u));
		}
	}
 }

public class DisjointSetUnionBySize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisjointSetSize dsu = new DisjointSetSize(7);
		dsu.unionBySize(1, 2);
		dsu.unionBySize(2, 3);
		dsu.unionBySize(4, 5);
		dsu.unionBySize(6, 7);
		dsu.unionBySize(5, 6);
		//if 3 and 7 are in same component
		if(dsu.findUPar(3)==dsu.findUPar(7)) {
			System.out.println("same");
		}else {
			System.out.println("Not Same");
		}
		dsu.unionBySize(3, 7);
		
		if(dsu.findUPar(3)==dsu.findUPar(7)) {
			System.out.println("same");
		}else {
			System.out.println("Not Same");
		}
	}

}
