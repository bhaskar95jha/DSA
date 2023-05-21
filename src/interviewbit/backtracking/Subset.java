package interviewbit.backtracking;

import java.util.*;

public class Subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<>();
		
		A.add(13);
		A.add(12);
		int ip[] = new int[A.size()];
		int i = 0;
		for(int ele:A) {
			ip[i++] = ele;
		}
		Arrays.sort(ip);
		ArrayList<Integer> ds = new ArrayList<>();
		Set<List<Integer>> op = new HashSet<>();
		solve(0,ip,ds,op);
		
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(List<Integer> li:op) {
			ans.add(new ArrayList<>(li));
		}
		Comparator<List<Integer>> listComp = new Comparator<List<Integer>>() {
			
			@Override
			public int compare(List<Integer> li1, List<Integer> li2) {
				for(int i=0;i<li1.size()&& i<li2.size();i++) {
					int cmp = Integer.compare(li1.get(i), li2.get(i));
					if(cmp != 0) {
						return cmp;
					}
				}
				return Integer.compare(li1.size(), li2.size());
			}
		};
		Collections.sort(ans,listComp);
		ans.forEach(list -> {
			list.forEach(num -> System.out.print(num+" "));
			System.out.println();
		});
	}

	private static void solve(int ind, int[] ip, ArrayList<Integer> ds, Set<List<Integer>> op) {
		// TODO Auto-generated method stub
		if(ind ==ip.length) {
			op.add(new ArrayList<>(ds));
			return;
		}
		
		ds.add(ip[ind]);
		solve(ind+1, ip, ds, op);
		ds.remove(ds.size()-1);
		solve(ind+1, ip, ds, op);
		
	}

}
