import java.util.*;

public class BreadthFirstPath {
    int s;
    int[] edgeTo;
    boolean[] visited;
    int[] distTo;

    public BreadthFirstPath(Graph G, int s) {
        this.s = s;
        edgeTo = new int[G.V];
        visited = new boolean[G.V];
        distTo = new int[G.V];
        bfs(G, s);
    }

    public void bfs(Graph G, int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        for (int i = 0; i < G.V; i++) {
            distTo[i] = Integer.MAX_VALUE;
        }
        visited[s] = true;
        distTo[s] = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    q.add(w);
                    edgeTo[w] = v;
                    visited[w] = true;
                    distTo[w] = distTo[v] + 1;
                }
            }
        }
    }

    public int distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return visited[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        ArrayList<Integer> path = new ArrayList<>();
        int x = 0;
        for (int i = v; i != s ; i = edgeTo[i]) {
            path.add(i);
        }
        path.add(s);
        Collections.reverse(path);
        return path;
    }
}
