package AlgoUHashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
public class SortTheArrayOnFrequency {
	
	static class Pair{
        int el;
        int count;
        Pair(int el, int count){
            this.el = el;
            this.count = count;
        }
    }

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        
        int [] arr = new int [n];
        String [] input1 = br.readLine().split(" ");
        
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(input1[i]);
        }
        
		Map<Integer,Integer> hm = new LinkedHashMap<>();
		
		for(int ele:arr) {
			hm.compute(ele, (k,v) -> hm.containsKey(k) ? v+1 : 1);
		}
		
		List<Pair> pairList = new ArrayList<Pair>();
			
		for(int ele:arr) {
			if(hm.get(ele)!=null){
                pairList.add(new Pair(ele, hm.get(ele)));
                hm.remove(ele);
            }
		}
        
        
        Collections.sort(pairList, new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b){
                if(a.count == b.count){
                    return (a.el - b.el);
                }
                return (b.count - a.count);
            }
        });
        
		
        for(Pair p:pairList) {
        	int freq = p.count;
        	while(freq-- > 0) {
        		System.out.print(p.el+" ");
        	}
        }
	}

}
