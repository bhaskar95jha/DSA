package algouGraph.BFSAdvance;

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
public class PrisonBreak {

	public static void main(String[] args) throws Exception{
		BufferedReader br =
			    new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			char[][] grid = new char[n][m];
			for (int i = 0; i < n; i++) { grid[i] = br.readLine().toCharArray(); }
		
		Pair start = null;
		List<Pair> monsterList = new ArrayList<>();
		Pair monster = null;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(grid[i][j] == 'A') {
					start = new Pair(i,j);
				}
				if(grid[i][j] == 'M') {
					monster = new Pair(i,j);
					monsterList.add(monster);
				}
			}
			
		}
		
		
		int vis[][] = new int[n][m];
		int distFromMonster[][] = new int[n][m]; 
		distFromMonster = bfsDistMonster(n,m,grid,monsterList,vis);
		
		
		bfsDistStart(n,m,grid,start,distFromMonster,vis);
		
		
	}

	private static int[][] bfsDistMonster(int n, int m, char[][] grid, List<Pair> monsterList,int [][]vis) {
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

	private static void bfsDistStart(int n, int m, char[][] grid, Pair start,int[][] distFromMonster,int [][]monsVis) {
		Deque<Pair> q = new ArrayDeque<>();
		int distFromSource[][] = new int[n][m];
		int vis[][] = new int[n][m];
		int sx = start.first;
		int sy = start.second;
		q.add(new Pair(sx,sy));
		distFromSource[sx][sy] = 0;
		vis[sx][sy] = 1;
		int X[] = {0,0,1,-1};
		int Y[] = {-1,1,0,0}; 
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			int x = curr.first;
			int y = curr.second;
			for(int i=0;i<4;i++) {
				int newX = x + X[i];
				int newY = y + Y[i];
				// Reached out of boundary square.
				if(!check(n,m,newX,newY)) {
					System.out.println("YES");
					return;
				}
				if(vis[newX][newY]==0&&grid[newX][newY]!='#') {
					if(monsVis[newX][newY]==1 && distFromMonster[newX][newY] <= distFromSource[x][y] + 1) {
						continue;
					}
					q.add(new Pair(newX,newY));
					vis[newX][newY] = 1;
					distFromSource[newX][newY] = distFromSource[x][y]+1;
				}
			}
		}
		System.out.println("NO");
		
	}

	private static boolean check(int n, int m, int newX, int newY) {
		return (newX>=0 && newX<n && newY>=0 && newY<m );
			
	}
	
}