package algouGraph.BFSBasic;

import java.util.*;

public class BigDisk {
    static Scanner sc = new Scanner(System.in);
    static int t = 0;
    static int b = 1;
    static int l = 2;
    static int r = 3;

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            solve();
        }
    }

    private static void solve() {
    	//denoting the co-ordinate of top right vertex of rectangle 
        long x = sc.nextInt();
        long y = sc.nextInt();
        
        //# of circle
        int n = sc.nextInt();
        
        List<List<Long>> circles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        	//co-ordinate of the radius
            long cx = sc.nextInt();
            long cy = sc.nextInt();
            
            //radius of circle
            long r = sc.nextInt();
            List<Long> arr = new ArrayList<>();
            arr.add(cx);
            arr.add(cy);
            arr.add(r);
            circles.add(arr);
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int z = 0; z <= n + 4; z++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            List<Long> circle = circles.get(i);
            int index = i + 4;
            if (circle.get(0) - circle.get(2) <= 0) {
                addEdge(graph, l, index);
            }
            if (circle.get(0) + circle.get(2) >= x) {
                addEdge(graph, r, index);
            }
            if (circle.get(1) - circle.get(2) <= 0) {
                addEdge(graph, b, index);
            }
            if (circle.get(1) + circle.get(2) >= y) {
                addEdge(graph, t, index);
            }
        }

        for (int i = 0; i < n; i++) {
            int indexi = i + 4;
            for (int j = i + 1; j < n; j++) {
                int indexj = j + 4;
                if (distance(circles.get(j).get(0), circles.get(i).get(0), circles.get(j).get(1), circles.get(i).get(1)) <= ((circles.get(i).get(2) + circles.get(j).get(2)) * (circles.get(i).get(2) + circles.get(j).get(2)))) {
                    addEdge(graph, indexi, indexj);
                }
            }
        }

        boolean[] tv = bfs(t, graph);
        boolean[] bv = bfs(b, graph);
        boolean[] lv = bfs(l, graph);
        boolean[] rv = bfs(r, graph);

        boolean ans = !(tv[b] || tv[l] || rv[l] || rv[b]);
        if (ans) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean[] bfs(int t, ArrayList<ArrayList<Integer>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(t);
        visited[t] = true;

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (int child : graph.get(parent)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);
                }
            }
        }
        return visited;

    }

    private static long distance(Long x2, Long x1, Long y2, Long y1) {
        return ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> graph, int plain, int cIndex) {
        graph.get(plain).add(cIndex);
        graph.get(cIndex).add(plain);
    }


}
