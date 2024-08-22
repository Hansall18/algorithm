package graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    //integer 是索引
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
