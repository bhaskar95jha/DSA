package algouGraph.BFSAdvance;

import java.util.*;

public class GridBasedImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		bfsGrid(n,m);
	}

	private static void bfsGrid(int n, int m) {
		Deque<Pair> q = new ArrayDeque<>();
		q.add(new Pair(1,1));
		int visited[][] = new int[n][m];
		int distance[][] = new int[n][m];
		distance[1][1] = 0;
		visited[1][1] = 1;
		
		int X[] = {0,0,1,-1};
		int Y[] = {-1,1,0,0};
		
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			int x = curr.first;
			int y = curr.second;
			for(int i=0;i<4;i++) {
				int newX = x + X[i];
				int newY = y + Y[i];
				
				if(check(n,m,newX,newY)&&visited[newX][newY]==0) {
					
					q.add(new Pair(newX,newY));
					distance[newX][newY] = distance[x][y]+1;
					visited[newX][newY] = 1;
					
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(distance[i][j]+" "); 
			}
			System.out.println();
		}
		
	}

	private static boolean check(int n,int m,int newX, int newY) {
		if(newX>=0 && newX<n && newY>=0 && newY<m) {
			return true;
		}
		return false;
	}

}
