package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//拓扑排序
//条件：有入度为0的节点，无环，有向图
public class topologySort {
    public static ArrayList topologySort(Graph graph){
        //记录每个节点的入度
        HashMap<Node,Integer> map = new HashMap<>();
        //每一个入度为0的节点，进入队列
        Queue<Node> queue = new LinkedList<>();
        //遍历图的每一个节点
        for (Node node:
                graph.nodes.values()) {
            map.put(node,node.in);
            if (node.in == 0){
                queue.add(node);
            }
        }
        //保存排序的结果
        ArrayList<Node> list = new ArrayList<>();
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            //加入结果list中
            list.add(tmp);
            //遍历node邻居节点
            for (Node node:
                 tmp.nexts) {
                //节点入度-1
                map.put(node,map.get(node)-1);
                //入度为0，加入队列
                if (map.get(node) == 0){
                    queue.add(node);
                }
            }
        }
        return list;
    }
}
