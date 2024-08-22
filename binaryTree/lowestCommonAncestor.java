package binaryTree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 最近公共祖先节点！
 */

/**
 * 思路：
 * 1、HashMap保存所有节点的父节点！
 * 2、遍历map保存p的路径在set1！
 * 3、在set1中遍历q，找到即返回！
 */
public class lowestCommonAncestor {
    private HashMap<TreeNode,TreeNode> fatherMap;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        mapInit(root);
        HashSet<TreeNode> set1 = new HashSet<>();
        while (fatherMap.containsKey(p)){
            set1.add(p);
            p = fatherMap.get(p);
        }
        while (!set1.contains(q)){
            q = fatherMap.get(q);
        }
        return q;
    }
    public void mapInit(TreeNode head){
        fatherMap = new HashMap<>();
        if (head != null) fatherMap.put(head,null);
        setMap(head);
    }
    public void setMap(TreeNode head){
        while (head == null) return;
        if(head.left != null)fatherMap.put(head.left,head);
        if(head.right != null)fatherMap.put(head.right,head);
        setMap(head.left);
        setMap(head.right);
    }
}
