package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


/**
 * 打印二叉树的指定后继节点！
 */
public class inorderSuccessor {
    private List<TreeNode> list = new ArrayList<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        setList(root);
        if (list.indexOf(p)+1 < list.size()) return list.get(list.indexOf(p)+1);
        return null;
    }
    public void setList(TreeNode root){
        if (root == null) return;
        setList(root.left);
        list.add(root);
        setList(root.right);
    }
}
