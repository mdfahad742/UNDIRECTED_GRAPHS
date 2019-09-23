import java.io.IOException;

public class TestGraph {
    public static void main(String[] args)throws IOException {
        Graph G = new Graph(13);
        G.addEdge(0, 5);
        G.addEdge(4, 3);
        G.addEdge(0, 1);
        G.addEdge(9, 12);
        G.addEdge(6, 4);
        G.addEdge(5, 4);
        G.addEdge(0, 2);
        G.addEdge(11, 12);
        G.addEdge(9, 10);
        G.addEdge(0, 6);
        G.addEdge(7, 8);
        G.addEdge(9, 11);
        G.addEdge(5, 3);
        System.out.println(G);
        int s = 0;
        DepthFirstPaths path1 = new DepthFirstPaths(G, s);
        System.out.println("DFS");
        for (int v = 0; v < G.V; v++) {
            if (path1.hasPathTo(v)) {
                System.out.printf("%d to %d\n", s, v); // all vertices connected to s
                System.out.println(path1.pathTo(v));
                System.out.println();
            }
            else System.out.printf("%d to %d not connected\n", s, v);
        }
        System.out.println();
        System.out.println("BFS");
        BreadthFirstPath path2 = new BreadthFirstPath(G, s);
        for (int v = 0; v < G.V; v++) {
            if (path2.hasPathTo(v)) {
                System.out.printf("%d to %d\n", s, v); // all vertices connected to s
                System.out.printf("%d is the distance from %d to %d\n", path2.distTo(v), s, v);
                System.out.println(path2.pathTo(v));
                System.out.println();
            }
            else System.out.printf("%d to %d not connected\n", s, v);
        }
        System.out.println();
        System.out.println("CC");
        CC cc = new CC(G);
        System.out.printf("%d connected components\n", cc.count);


    }
}
