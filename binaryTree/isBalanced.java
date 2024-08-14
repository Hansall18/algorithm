package binaryTree;

/**
 * 判断是否是平衡二叉树
 */

/**
 * 这里套用了二叉树的递归套路！
 * 叫做 树形DP的套路
 * 1. 确定条件
 * 2. 确定返回值
 * 3. 写代码
 */
public class isBalanced {
    public boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }
    public returntype process(TreeNode root){
        if(root == null){
            return new returntype(true,0);
        }
        returntype left = process(root.left);
        returntype right = process(root.right);
        int height = Math.max(left.height,right.height)+1;
        boolean res = left.isBalanced&&right.isBalanced&&(Math.abs(left.height-right.height)<2);
        return new returntype(res,height);
    }
}
class returntype{
    boolean isBalanced;
    int height;
    public returntype(boolean a,int b){
        this.isBalanced =a;
        this.height = b;
    }
}
