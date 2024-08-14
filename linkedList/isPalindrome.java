package linkedList;

import java.util.Stack;

/**
 * 判断是否为回文列表！
 */

public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;

        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null){
            ListNode n = stack.pop();
            if (n.val != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
