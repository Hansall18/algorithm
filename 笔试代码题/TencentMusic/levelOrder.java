package 笔试代码题.TencentMusic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//层序遍历树，将结果以如下格式返回
//[[3],[9,20],[14,3]]
public class levelOrder {
    //给定树的头结点root
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        //存储遍历顺序的节点queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //保存每一层的节点l
            List<Integer> l = new ArrayList<>();
            //用队列的长度区分每一层
            for (int i = queue.size(); i > 0; i--) {
                TreeNode tmp = queue.poll();
                l.add(tmp.val);
                if (tmp.left != null){
                    queue.add(tmp.left);
                }
                if (tmp.right != null){
                    queue.add(tmp.right);
                }
            }
            lists.add(l);
        }
        return lists;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}