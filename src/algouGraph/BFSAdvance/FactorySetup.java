package algouGraph.BFSAdvance;

import java.io.*;
import java.util.*;

public class FactorySetup {

	public static void main(String[] args) throws IOException {
		InputStreamReader r=new InputStreamReader(System.in);    
	    BufferedReader br=new BufferedReader(r); 
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		char[][] grid= new char[n][m];
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				grid[i][j] = str.charAt(j);
			}
		}
		
		int distEngine[][] = new int[n][m];
		Pair startEngine = new Pair(0,0);
		distEngine = bfsDist(startEngine,n,m,grid);
		System.out.println("distance from engine");
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(distEngine[i][j]+" ");
			}
			System.out.println();
		}
		int distTyre[][] = new int[n][m];
		Pair startTyre = new Pair(n-1,0);
		distTyre = bfsDist(startTyre,n,m,grid);
		System.out.println("distance from Tyre");
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(distTyre[i][j]+" ");
			}
			System.out.println();
		}
		int distWheel[][] = new int[n][m];
		Pair startWheel = new Pair(0,m-1);
		distWheel = bfsDist(startWheel,n,m,grid);
		System.out.println("distance from Wheel");
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(distWheel[i][j]+" ");
			}
			System.out.println();
		}
		int distBody[][] = new int[n][m];
		Pair startBody = new Pair(n-1,m-1);
		distBody = bfsDist(startBody,n,m,grid);
		System.out.println("distance from Body");
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(distBody[i][j]+" ");
			}
			System.out.println();
		}
		int engineFairCost = 5;
		int bodyFairCost = 10;
		int tyreFairCost = 2;
		int wheelFairCost = 1;
		
		System.out.println("Cost of each grid that is reachable from everywhere");
		int minAns = Integer.MAX_VALUE;
		int costForEachGrid[][] = new int[n][m];
		int li = -1;
		int lj = -1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(distBody[i][j]==0) {
					continue;
				}
				int ans = distEngine[i][j] * engineFairCost +
						distBody[i][j] * bodyFairCost +
						distTyre[i][j] * tyreFairCost +
						distWheel[i][j] * wheelFairCost;
				costForEachGrid[i][j] = ans;
				minAns = Math.min(ans, minAns);
				if(minAns==ans) {
					li = i;
					lj = j;
				}
				
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(costForEachGrid[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Minimum cost and location is "+minAns+" "+li+","+lj);
		
		
	}

	private static int[][] bfsDist(Pair start, int n, int m, char[][] grid) {
		int vis[][] = new int[n][m];
		int dis[][] = new int[n][m];
		Deque<Pair> q = new ArrayDeque<>();
		q.add(start);
		int sx = start.first;
		int sy = start.second;
		vis[sx][sy] = 1;
		dis[sx][sy] = 1;
		int X[] = {0,0,1,-1};
		int Y[] = {-1,1,0,0};
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			int x = curr.first;
			int y = curr.second;
			for(int i=0;i<4;i++) {
				int newX = x+X[i];
				int newY = y+Y[i];
				if(check(newX,newY,n,m,grid) && vis[newX][newY]==0) {
					vis[newX][newY] = 1;
					dis[newX][newY] = dis[x][y] + 1;
					q.add(new Pair(newX,newY));
				}
			}
		}
		
		return dis;
	}

	private static boolean check(int newX, int newY, int n, int m, char[][] grid) {
		if(newX>=0 && newX<n && newY>=0 && newY<m && grid[newX][newY]!='#')
			return true;
		return false;
	}

}
