package algouGraph.BFSContest;

import java.io.*;
import java.util.*;


class Pair{
	int first;
	int second;
	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

public class CoronaAgainOnFire {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =
			    new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			char[][] grid = new char[n][m];
			for (int i = 0; i < n; i++) { grid[i] = br.readLine().toCharArray(); }
		
		Pair start = null;
		Pair dest = null;
		List<Pair> virusList = new ArrayList<>();
		Pair virus = null;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(grid[i][j] == 's') {
					start = new Pair(i,j);
				}
				if(grid[i][j] == 'h') {
					dest = new Pair(i,j);
				}
				if(grid[i][j] == 'd') {
					virus = new Pair(i,j);
					virusList.add(virus);
				}
				
			}
			
		}
//		if(virusList.size()==0) {
//			System.out.println("YES");
//			return;
//			
//		}
		int vis[][] = new int[n][m];
		int distFromVirus[][] = new int[n][m]; 
		distFromVirus = bfsDistVirus(n,m,grid,virusList,vis);
		vis = new int[n][m];
		int distFromSrc[][] = new int[n][m];
		distFromSrc = bfsDistSrc(n,m,grid,start,vis);
		//System.out.println(distFromSrc[dest.first][dest.second]);
		if(distFromSrc[dest.first][dest.second]==0) {
			System.out.println("NO");
			return;
		}
		if(distFromVirus[dest.first][dest.second]==0) {
			System.out.println("YES");
			return;
		}
		if(distFromSrc[dest.first][dest.second]<distFromVirus[dest.first][dest.second]) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}

	private static int[][] bfsDistSrc(int n, int m, char[][] grid, Pair start, int[][] vis) {
		Deque<Pair> q = new ArrayDeque<>();
		int dist[][] = new int[n][m];
		int sx = start.first;
		int sy = start.second;
		q.add(start);
		vis[sx][sy] = 1;
		dist[sx][sy] = 0;
		
		int X[] = {0,0,1,-1};
		int Y[] = {-1,1,0,0};
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			int x = curr.first;
			int y = curr.second;
			for(int i=0;i<4;i++) {
				int newX = x+X[i];
				int newY = y+Y[i];
				if(check(n,m,newX,newY)&&vis[newX][newY]==0&&grid[newX][newY]!='#') {
					q.add(new Pair(newX,newY));
					vis[newX][newY] = 1;
					dist[newX][newY] = dist[x][y]+1;
				}
			}
		}	
		return dist;
	}

	private static int[][] bfsDistVirus(int n, int m, char[][] grid, List<Pair> monsterList,int [][]vis) {
		
		Deque<Pair> q = new ArrayDeque<>();
		int dist[][] = new int[n][m];
		for(Pair monster:monsterList) {
			int sx = monster.first;
			int sy = monster.second;
			q.add(monster);
			vis[sx][sy] = 1;
			dist[sx][sy] = 0;
		}
		int X[] = {0,0,1,-1};
		int Y[] = {-1,1,0,0};
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			int x = curr.first;
			int y = curr.second;
			for(int i=0;i<4;i++) {
				int newX = x+X[i];
				int newY = y+Y[i];
				if(check(n,m,newX,newY)&&vis[newX][newY]==0&&grid[newX][newY]!='#') {
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
