package 笔试代码题.美团;


// 给你单链表的头指针 head 和两个整数 left 和 right ，
// 其中 left <= right 。
// 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class reverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        if (left == right) return head;
        ListNode rhead = head;
        // pre 需要翻转的第一个节点
        ListNode pre = null;
        // last 需要翻转的最后一个节点
        ListNode last = null;
        for (int i = 1; i <= right; i++) {
            if (i == left) {
                pre = head;
            }
            if (i == right){
                last = head;
            }
            head = head.next;
        }
        ListNode reverse = reverse(pre,last,right-left);
        // left == 1 直接返回翻转的链表
        if (left == 1) return reverse;
        // cur 为rhead的下一个节点
        ListNode cur = rhead.next;
        // left == 2 将rhead的next指向返回的reverse
        // 然后直接返回 rhead
        if (left == 2) {
            rhead.next  = reverse;
            return rhead;
        }
        // 找到pre之前的节点，赋值给cur
        for (int i = 3; i < left; i++) {
            cur = cur.next;
        }
        // 将cur的下一个节点指向返回的reverse
        cur.next = reverse;
        return rhead;
    }
    // 翻转指定范围的链表
    // head 表示翻转的第一个节点
    // end 表示翻转的最后一个节点
    // count 记录翻转节点次数，保证只翻转[head,end]范围的链表
    // 返回的是一条翻转后节点的头节点，包含end节点的后续节点
    public ListNode reverse(ListNode head,ListNode end,int count){
        // rhead 为end节点的下一个节点，保证翻转后的链表后续能够接上end后的节点
        ListNode rhead = end.next;
        ListNode cur = head;
        ListNode nextNode = null;
        while (cur != null && count >= 0){
            nextNode = cur.next;
            cur.next = rhead;
            rhead = cur;
            cur = nextNode;
            count--;
        }
        return rhead;
    }
}
