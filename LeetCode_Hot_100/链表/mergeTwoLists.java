package LeetCode_Hot_100.链表;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class mergeTwoLists {
    public static ListNode process(ListNode list1, ListNode list2){
        ListNode cur = new ListNode(-1);
        ListNode newHead = cur;
        ListNode l1 = list1;
        ListNode l2 = list2;
        while (l1 != null && l2 != null){
            int v1 = l1.val;
            int v2 = l2.val;
            ListNode temp;
            // 比完大小，将小的node置给temp
            if (v1 <= v2){
                temp = l1;
                l1 = l1.next;
            }else {
                temp = l2;
                l2 = l2.next;
            }
            // 将新链表的cur.next 连接到 temp
            cur.next = temp;
            cur = temp;
        }
        // 处理剩下的两个链表中还剩下的节点
        while (l1 != null){
            cur.next = l1;
            cur = l1;
            l1 = l1.next;
        }
        while (l2 != null){
            cur.next = l2;
            cur = l2;
            l2 = l2.next;
        }
        return newHead.next;
    }
}
