package AlgoUHashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Consecutiveness {

	public static void main(String[] args) throws IOException  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        
        int n = Integer.parseInt(in[0]);

        String[] in1 = br.readLine().split(" ");
        int[] arr = new int[n];
        
        int i = 0;
        while(i < n){
           arr[i] = Integer.parseInt(in1[i]);
           i++;
        }
//        HashMap<Integer, Integer> hm = new HashMap<>();
//       
//        for(i=0;i<n;i++) {
//        	hm.put(arr[i], i);
//        }
//        
//        int count = 0;
//        int max = -1;
//        for(i=0;i<1000000001;i++) {
//        	if(hm.containsKey(i)) {
//        		count++;
//        		continue;
//        	}
//        	
//        	max = Math.max(max, count);
//        	count = 0;
//        }
//        System.out.println(max);
        
        
        Arrays.sort(arr);
        
        List<Integer> consecutiveList = new ArrayList<>();
        int count = 1;
        for(i=1;i<n;i++) {
        	if(arr[i]==arr[i-1]) {
        		continue;
        	}
        	while(i<n && arr[i]==arr[i-1]+1) {		
        		count++;
        		i++;
        		while(i<n && arr[i]==arr[i-1]) {
            		i++;
            	}
        	}
			consecutiveList.add(count);
        	count = 1;
        }
        int max = -1;
        for(int ele:consecutiveList) {
        	max = Math.max(max, ele);
        }
        System.out.println(max);
	}
}