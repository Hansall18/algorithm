package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class isCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        boolean leaf = false;
        TreeNode l;
        TreeNode r;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            l  = poll.left;
            r = poll.right;
            if ( (leaf&& (l != null || r != null))
                    ||
                    (l == null && r != null)
            ) return  false;
            if (l != null){
                queue.add(l);
            }
            if (r != null){
                queue.add(r);
            }
            if (l == null ||  r == null){
                leaf = true;
            }
        }
        return true;
    }
}
