package AlgoUHashing;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Map;
//
////there is 5 solution i have tried
//
//public class UniqueWindow {
//
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
//        String [] input = br.readLine().split(" ");
//        int n = Integer.parseInt(input[0]);
//        int k = Integer.parseInt(input[1]);
//        
//            int [] arr = new int [n];
//        String [] input1 = br.readLine().split(" ");
//            for(int i=0;i<n;i++){
//
//                arr[i]=Integer.parseInt(input1[i]);
//
//
//            }
//		
//		uniqueElementsInWindow(arr,k);
//		
//	}
//
//
//	private static void uniqueElementsInWindow(int[] A, int K) {
//        int N = A.length;
//        Map<Integer, Integer> counts = new HashMap<>();
//        int uniqueCount = 0;
//        for (int i = 0; i < K; i++) {
//            int x = A[i];
//            counts.put(x, counts.getOrDefault(x, 0) + 1);
//            if (counts.get(x) == 1) {
//                uniqueCount++;
//            }
//        }
//        System.out.print(uniqueCount+" ");
//        for (int i = K; i < N; i++) {
//            int x = A[i];
//            int y = A[i - K];
//            if (counts.get(y) == 1) {
//                uniqueCount--;
//            }
//            counts.put(y, counts.get(y) - 1);
//            if (counts.get(x) == null || counts.get(x) == 0) {
//                uniqueCount++;
//            }
//            counts.put(x, counts.getOrDefault(x, 0) + 1);
//            System.out.print(uniqueCount+" ");
//        }
//    }
//}
//
//
//
//
//
//
//



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//there is 5 solution i have tried

public class UniqueWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        
            int [] arr = new int [n];
        String [] input1 = br.readLine().split(" ");
            for(int i=0;i<n;i++){

                arr[i]=Integer.parseInt(input1[i]);


            }
		
		uniqueElementsInWindow(arr,k);
		
	}


	private static void uniqueElementsInWindow(int[] arr, int K) {
        int [] count = new int [101];
        int ans=0;
        int n = arr.length;
        for (int i =0; i<K; i++)
        {
            if(count[arr[i]]==0)
            {
                count[arr[i]]++;
                ans++;
            }
            else
              count[arr[i]]++;
        }
        System.out.print(ans+" ");
         for (int i =K; i<n; i++)
         {
             if (count[arr[i]]==0)
             {
                 count[arr[i]]++;
                ans++;
             }
             else
              count[arr[i]]++;
             if (count[arr[i-K]]==1)
             {   ans--;
                 count[arr[i-K]]--;
             }
             else
             {
                  count[arr[i-K]]--;
             }
        System.out.print(ans+" ");
             
         }
    }
}







