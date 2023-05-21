/**
 * 
 */
package AlgoUBinarySearchMaximin_MiniMax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

 class LRSet implements Comparable<LRSet> {
	long l;
	long r;
	public LRSet() {
		super();
	}
	public long getL() {
		return l;
	}
	public void setL(long l) {
		this.l = l;
	}
	public long getR() {
		return r;
	}
	public void setR(long r) {
		this.r = r;
	}
	
	@Override
	public int compareTo(LRSet ele) {
		return (int) (this.getL() - ele.getL());
	}
	
 }

public class Corona {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<LRSet> lrList = new ArrayList<>();
		while(m-- > 0) {
			long s = sc.nextLong();
			long e = sc.nextLong();
			LRSet lr = new LRSet();
			lr.setL(s);
			lr.setR(e);
			lrList.add(lr);
		}
		Collections.sort(lrList);
		long l = 0;
		long r = Long.MAX_VALUE;
		while(l+1<r) {
			long mid = l+(r-l)/2;
			if(predicate(lrList,mid,n)==0) {
				l = mid;
			}else {
				r = mid;
			}
		}
		System.out.println(l);
	}

	private static int predicate(List<LRSet> lrList, long mid, int n) {
		// TODO Auto-generated method stub
		long people = 0;
		long last = 0;
		int flag = 0;
		for(LRSet ele:lrList) {
			long li = ele.getL();	
			long ri = ele.getR();
			
			if(flag == 1) {
				long k = last+mid; 
				if(k>=li) {
					li = k;
				}
			}
			
			if(li>ri) {
				continue;
			}
			
			long currPeople = (ri-li)/mid + 1;
			last = li + (currPeople-1)*mid  ;
			people += currPeople;
			flag = 1;
		
		}
		if(people>=n) {
			return 0;
		}else {
			return 1;
		}
	}

}
