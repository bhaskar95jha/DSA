package interviewbit.backtracking;

import java.util.*;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = new ArrayList<>();
		a.add(8);
		a.add(10);
		a.add(6);
		a.add(11);
		a.add(1);
		a.add(16);
		a.add(8);
		int target = 28;
		int ip[] = new int[a.size()];
		
        for(int i=0;i<ip.length;i++){
            ip[i] = a.get(i);
        }
        Arrays.sort(ip);
        List<Integer> ds = new ArrayList<>();
		Set<ArrayList<Integer>> ans = new HashSet<>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		int i = 0;
		solve(i,0,target,ip,ds,ans);
		for(ArrayList<Integer> li:ans) {
			list.add(li);
		}
		
		Comparator<List<Integer>> listComparator = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> list1, List<Integer> list2) {
                // Compare the lists element by element until a difference is found
                for (int i = 0; i < list1.size() && i < list2.size(); i++) {
                    int cmp = Integer.compare(list1.get(i), list2.get(i));
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                // If all elements are equal, compare based on the size of the lists
                return Integer.compare(list1.size(), list2.size());
            }
        };

        // Sort the list of lists using the custom comparator
        Collections.sort(list, listComparator);
		
		list.forEach(innerList -> {
			innerList.forEach(num -> System.out.print(num+" "));
			System.out.println();
		});
		//return list;
	}


	private static void solve(int ind,int sum,int target, int[] ip, List<Integer> ds, Set<ArrayList<Integer>> ans) {
		
		// TODO Auto-generated method stub
		if(ind==ip.length) {
			if(target==sum) {
				ans.add(new ArrayList<>(ds));
			}
			return;
		}
		if(sum>target)
			return;
		//take
		ds.add(ip[ind]);
		sum += ip[ind];
		solve(ind,sum,target,ip,ds,ans);
		ds.remove(ds.size()-1);
		sum -= ip[ind];
		//not take
		solve(ind+1,sum,target,ip, ds, ans);
		
		
	}

}
