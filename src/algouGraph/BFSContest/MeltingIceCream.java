package algouGraph.BFSContest;

import java.io.*;
import java.util.*;



public class MeltingIceCream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =
			    new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			char[][] grid = new char[n][m];
			for (int i = 0; i < n; i++) { grid[i] = br.readLine().toCharArray(); }
		
			Pair start = null;
			Pair dest = null;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(grid[i][j] == 'i') {
						start = new Pair(i,j);
					}
					if(grid[i][j] == 'h') {
						dest = new Pair(i,j);
					}
				}
				
			}
			
			int vis[][] = new int[n][m];
			int distFromShop[][] = new int[n][m]; 
			distFromShop = bfsDistShop(n,m,grid,start,vis);
			if(distFromShop[dest.first][dest.second]>k) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
	}

	private static int[][] bfsDistShop(int n, int m, char[][] grid, Pair start, int[][] vis) {
		Deque<Pair> q = new ArrayDeque<>();
		int dist[][] = new int[n][m];
		int sx = start.first;
		int sy = start.second;
		q.add(new Pair(sx,sy));
		dist[sx][sy] = 0;
		vis[sx][sy] = 1;
		int X[] = {0,0,1,-1};
		int Y[] = {-1,1,0,0}; 
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			int x = curr.first;
			int y = curr.second;
			for(int i=0;i<4;i++) {
				int newX = x+X[i];
				int newY = y+Y[i];
				if(check(n,m,newX,newY)&&vis[newX][newY]==0) {
					q.add(new Pair(newX,newY));
					vis[newX][newY] = 1;
					dist[newX][newY] = dist[x][y]+1;
				}
			}
		}	
		return dist;
	}

	private static boolean check(int n, int m, int newX, int newY) {
		return (newX>=0 && newX<n && newY>=0 && newY<m );
	}

}
