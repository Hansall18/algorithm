package graph;

import java.util.ArrayList;

public class Node {
    public int value;
    public int in;//有多少个节点指向这个点
    public int out;//这个点指向有多少个其他点
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
