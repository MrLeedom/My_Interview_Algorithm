package offer;

import com.list.Node;

/**
 * @author:leedom
 * @date:2019/7/7 10:10
 * Description:合并两个有序的链表
 * License: (C)Copyright 2019
 */
public class Question29 {
    //利用递归的思想来解决合并两个有序链表
    public static Node mergeList(Node head1, Node head2) {
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }
        if(head1.value <= head2.value) {
            head1.next = mergeList(head1.next, head2);
            return head1;
        }else {
            head2.next = mergeList(head1, head2.next);
            return head2;
        }
    }

    //利用迭代的思想来解决两个有序链表合并操作
    public static Node mergeList2(Node head1, Node head2) {
        Node head = new Node(-1);
        Node cur = head;
        while(head1 != null && head2 != null){
            if(head1.value <= head2.value) {
                cur.next = head1;
                head1 = head1.next;
            }else{
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if(head1 == null) {
            cur.next = head2;
        }
        if(head2 == null) {
            cur.next = head1;
        }
        return head.next;
    }
}
