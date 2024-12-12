package LeetCode_Hot_100.链表;

import java.util.HashSet;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 */
public class getIntersectionNode {
    public static ListNode process(ListNode headA, ListNode headB){
        // 哈希表set存储A链表所有元素
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        // 添加元素到set中
        while (temp != null){
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null){
            // set中包含B的元素，说明相交，返回该节点
            if (set.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}