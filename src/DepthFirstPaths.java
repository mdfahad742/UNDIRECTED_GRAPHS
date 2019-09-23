import java.util.ArrayList;
import java.util.Collections;

public class DepthFirstPaths {
    boolean[] visited; //visited[v] = true if v is connected to s
    int[] edgeTo; //edgeTo[v] = previos vertex on path from s to v
    int s;

    public DepthFirstPaths(Graph G, int s) {
        this.s = s;
        visited = new boolean[G.V];
        edgeTo = new int[G.V];
        dfs(G, s);
    }

    public void dfs(Graph G, int v) {
        visited[v] = true;
        for (int w : G.adj[v]) {
            if (!visited[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
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
