package binaryTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * 判断是否为搜索二叉树！
 */
public class isValidBST {
    public static long preValue = Long.MIN_VALUE;
    public static boolean  isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean b1 = isValidBST(root.left);
        if(!b1){
            return false;
        }
        if(root.val <= preValue){
            return false;
        }else {
            preValue = root.val;
        }
        boolean b2 = isValidBST(root.right);
        return b2;
    }
}
