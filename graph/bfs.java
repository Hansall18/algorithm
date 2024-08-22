package graph;
import java.util.*;

//广度优先搜索 ==》 用队列
public class bfs {
    //图的起始节点node
    public static void bfs(Node node){
        if (node == null) {
            return;
        }
        //存储所有节点，以便遍历
        Queue<Node> q = new LinkedList<>();
        //防止队列出现重复的节点
        HashSet<Node> set = new HashSet<>();
        //先将起始节点加到队列和Set中
        q.add(node);
        set.add(node);
        while (!q.isEmpty()){
            //每取出一个节点就打印
            Node tmp = q.poll();
            System.out.println(tmp.value);
            //将取出节点的相邻节点加入到队列和Set中
            for (int i = 0; i < tmp.nexts.size(); i++) {
                //判断是否重复
                if (!set.contains(tmp.nexts.get(i))){
                    q.add(tmp.nexts.get(i));
                    set.add(tmp.nexts.get(i));
                }
            }
        }
    }
}
