package linkedList;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * 翻转链表！
 */
public class reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode rHead = null;
        ListNode cur = head;
        ListNode nextNode = null;

        while(cur != null){
            nextNode = cur.next;
            cur.next = rHead;
            rHead = cur;
            cur = nextNode;
        }

        return rHead;
    }
}
