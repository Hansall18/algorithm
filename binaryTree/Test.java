package binaryTree;

import javax.jnlp.SingleInstanceListener;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        TreeNode head = null;
        head = init();

//        RecursiveShow(head);

//        Preorder(head);
//        LDR(head);
//        postorder(head);

        BFS bfs = new BFS();
        bfs.BFS(head);
    }


    //初始化二叉树
    public static TreeNode init(){
        // 初始化节点
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        // 构建节点之间的引用（指针）
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        return n1;
    }

    //递归遍历二叉树
    public static void RecursiveShow(TreeNode head){
        if(head == null) return;

//        System.out.print(""head.val+" ");  // 前序遍历
        RecursiveShow(head.left);
//        System.out.print(head.val+" ");  //中序遍历
        RecursiveShow(head.right);
//        System.out.print(head.val+" ");  //后序遍历
    }


    //非递归实现前序遍历
    public static void Preorder(TreeNode head){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = head;
        stack.push(cur);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            System.out.print(pop.val+" ");
            if (pop.right != null){
                stack.push(pop.right);
            }
            if (pop.left != null){
                stack.push(pop.left);
            }
        }
    }
    //非递归实现中序遍历
    public static void LDR(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.val + " ");
            if (pop.right != null) {
                cur = pop.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
    }
    //非递归实现后序遍历
    public static void postorder(TreeNode head){
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode cur = head;
        stack.push(cur);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            stack2.push(pop);
            if (pop.left != null){
                stack.push(pop.left);
            }
            if (pop.right != null){
                stack.push(pop.right);
            }
        }
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().val+" ");
        }
    }

}
