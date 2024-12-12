package LeetCode_Hot_100.链表;

import java.util.Stack;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表 如果是，返回 true ；否则，返回 false 。
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 */
public class isPalindrome {
    public static boolean process(ListNode head){
        // 使用栈来判断回文
        Stack<ListNode> stack = new Stack<>();
        ListNode p1 = head;
        while (p1 != null){
            stack.push(p1);
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p2 != null){
            if (p2.val != stack.pop().val){
                return false;
            }
            p2 = p2.next;
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
