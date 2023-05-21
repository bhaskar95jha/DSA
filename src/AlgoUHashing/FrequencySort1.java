package AlgoUHashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FrequencySort1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        
        int [] arr = new int [n];
        String [] input1 = br.readLine().split(" ");
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(input1[i]);
            max = Math.max(max, arr[i]);
        }
		Arrays.sort(arr);
		int freq[] = new int[max+1];
		for(int ele:arr) {
			freq[ele]++;
		}
		int freqCopy[] = Arrays.copyOf(freq, freq.length);
		Arrays.sort(freqCopy);
		for(int i=freqCopy.length-1;i>=0;i--) {
			int ele = freqCopy[i];
			if(ele == 0)
				break;
			for(int j=0;j<freq.length;j++) {
				if(ele == freq[j]) {
					for(int k=0;k<ele;k++) {
						System.out.print(j+" ");
					}
					freq[j] = -1;
					break;
				}
			}
		}
		
	}

}
