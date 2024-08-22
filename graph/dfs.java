package graph;

import java.util.HashSet;
import java.util.Stack;

//深度优先遍历 ==》 使用栈
public class dfs {
    public static void dfs(Node node){
        if(node == null) return;
        //防止重复set
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        //入栈就打印
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()){
            Node tmp = stack.pop();
            for (Node next: tmp.nexts
                 ) {
                if (!set.contains(next)){
                    stack.push(tmp);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    //为了在一条路上走到底
                    break;
                }
            }
        }
    }
}
