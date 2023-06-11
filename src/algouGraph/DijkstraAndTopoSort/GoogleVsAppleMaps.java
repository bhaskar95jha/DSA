package algouGraph.DijkstraAndTopoSort;

import java.io.*;
import java.util.*;

public class GoogleVsAppleMaps {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<List<Pairs>> googleList = new ArrayList<>();
		List<List<Pairs>> appleList = new ArrayList<>();
		
		for(int i=0;i<n+1;i++) {
			googleList.add(new ArrayList<>());
			appleList.add(new ArrayList<>());
		}
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			//googleList.get(u).add(v);	
		}
		int src = 1;
		int dist[] = new int[n+1];
		dist = dijKstra(googleList,n,src);
		
		for(int ele:dist) {
			System.out.print(ele+" ");
		}

	}

	private static int[] dijKstra(List<List<Pairs>> googleList, int n, int src) {
		// TODO Auto-generated method stub
		return null;
	}

}
