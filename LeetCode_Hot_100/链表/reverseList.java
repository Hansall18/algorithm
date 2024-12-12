package LeetCode_Hot_100.链表;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class reverseList {
    public static ListNode process(ListNode head){
        // 新链表头newHead
        ListNode newHead = null;
        // 当前链表节点cur
        ListNode cur = head;
        while (cur != null){
            // 记录当前节点的temp,作为新的链表头
            ListNode temp = cur;
            // cur置为下一个节点
            cur = cur.next;
            // temp节点连接到新链表表头
            temp.next = newHead;
            // newHead置为temp，成为新的表头
            newHead = temp;
        }
        return newHead;
    }
}
