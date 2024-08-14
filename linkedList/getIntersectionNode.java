package linkedList;

import java.util.Stack;

/**
 * 单链表相交问题！
 * 注意这里是一个无环的单链表！
 */
public class getIntersectionNode {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode t1 = headA;
            ListNode t2 = headB;

            int size1 = 0;
            int size2 = 0;
            //获取A的长度
            while(t1 != null){
                size1++;
                t1 = t1.next;
            }
            //获取B的长度
            while(t2 != null){
                size2++;
                t2 = t2.next;
            }
            //将A,B中较长的一个移动dif步,使两个链表一样长
            if(size1 > size2){
                int dif = size1 - size2;
                for(int i = 0; i < dif; i++){
                    headA = headA.next;
                }
            }else{
                int dif = size2 - size1;
                for(int i = 0; i < dif; i++){
                    headB = headB.next;
                }
            }
            //遍历链表找公共节点
            while(headA != null){
                if(headA == headB){
                    return headA;
                }else{
                    headA = headA.next;
                    headB = headB.next;
                }
            }

            return null;
        }
    }
}
