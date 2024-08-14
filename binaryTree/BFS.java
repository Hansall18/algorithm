package binaryTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public void BFS(TreeNode head){
        if (head == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.print(poll.val+" ");
            if (poll.left != null){
                queue.add(poll.left);
            }
            if (poll.right != null){
                queue.add(poll.right);
            }
        }
    }

}
