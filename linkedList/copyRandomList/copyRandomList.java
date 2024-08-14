package linkedList.copyRandomList;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;

/**
 * 复制随机链表！
 */

public class copyRandomList {
    public Node copyRandomList(Node head) {
        //用map保存两个链表的一对一的对应关系！
        HashMap<Node,Node> map = new HashMap<>();

        Node p = head;
        //复制一个链表！
        while (p != null){
            map.put(p,new Node(p.val));
            p = p.next;
        }

        //复制node的下一个指针
        p = head;
        while (p != null){
            Node q = map.get(p);
            Node j = map.get(p.next);
            q.next = j;
            p = p.next;
        }

        //复制node的随即指针
        p = head;
        while (p != null){
            Node q = map.get(p);
            Node j = map.get(p.random);
            q.random = j;
            p = p.next;
        }

        return map.get(head);

    }
}
