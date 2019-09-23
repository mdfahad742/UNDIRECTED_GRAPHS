public class CC {
    boolean[] visited;
    int[] id;
    int count;

    public CC(Graph G) {
        count = 0;
        visited = new boolean[G.V];
        id = new int[G.V];
        for (int v = 0; v < G.V; v++) {
            if (!visited[v]) {
                dfs(G, v);
                count++;
            }
        }

    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }

    public void dfs(Graph G, int v) {
        visited[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!visited[w])
                dfs(G, w);
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }
}
