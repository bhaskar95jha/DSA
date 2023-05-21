package AlgoUHashing;
import java.util.*;
import java.io.*;
public class FrequencySort
{
    static class Pair{
        long el;
        long count;
        Pair(long el, long count){
            this.el = el;
            this.count = count;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        
        int N = Integer.parseInt(in[0]);

        String[] in1 = br.readLine().split(" ");
        int[] arr = new int[N];
        
        int i = 0;
        while(i < N){
           arr[i] = Integer.parseInt(in1[i]);
           i++;
        }
        
        List<Pair> pairList = new ArrayList<Pair>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<Integer, Integer> keys = new HashMap<Integer, Integer>();
        
        i = 0;
        int max = Integer.MIN_VALUE;
        while(i < N){
            max = Math.max(max, arr[i]);
            int count = 0;
            if(map.get(arr[i]) != null){
                count = map.get(arr[i]);
                map.remove(arr[i]);
            }
            map.put(arr[i], count + 1);
            if(keys.get(arr[i]) == null){
                keys.put(arr[i], 1);
            }
            i++;
        }
        
        System.out.println("map : = "+map);
        System.out.println("keys : = "+keys);
        
        i = 0;
        while(i < N){
            if(keys.get(arr[i]) != null){
                pairList.add(new Pair(arr[i], map.get(arr[i])));
                keys.remove(arr[i]);
            }
            i++;
        }
        for(Pair ele:pairList) {
        	System.out.println(ele.el+" "+ ele.count);
        }
        
        System.out.println("Keys : "+keys);
        
        Collections.sort(pairList, new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b){
                if(a.count == b. count){
                    return (int)(a.el - b.el);
                }
                return (int)(b.count - a.count);
            }
        });
        
        i = 0;
        while(i < pairList.size()){
            Pair p = pairList.get(i);
            int j = 0;
            while(j < p.count){
                System.out.print(p.el + " ");
                j++;
            }
            i++;
        }
    }
}