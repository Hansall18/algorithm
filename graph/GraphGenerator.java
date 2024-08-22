package graph;

public class GraphGenerator {
    //matrix的每一行结构为：源城市编号，目标城市编号，距离
    //将它转换为我的图结构表示
    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer weight = matrix[i][0];//距离
            Integer from = matrix[i][1];//源城市编号
            Integer to = matrix[i][2];//目标城市编号
            if (!graph.nodes.containsKey(from)) {
                //如果源城市第一次出现，则加入到图中，创立新节点
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                //如果目标城市第一次出现，则加入到图中，创立新节点
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);//源城市节点
            Node toNode = graph.nodes.get(to);//目标城市节点
            //创建源城市与目标城市之间的边
            Edge newEdge = new Edge(weight, fromNode, toNode);
            //完善源城市节点信息
            fromNode.nexts.add(toNode);
            fromNode.out++;
            fromNode.edges.add(newEdge);
            //完善目标城市节点信息
            toNode.in++;
            //完善图结构信息
            graph.edges.add(newEdge);
        }
        return graph;
    }
}

