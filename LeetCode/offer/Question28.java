package offer;

import com.list.Node;

/**
 * @author:leedom
 * @date:2019/6/30 21:00
 * Description:反转链表
 * License: (C)Copyright 2019
 */
public class Question28 {
    /**
     第一种策略： 递归思想,化繁为简
     */
    public static Node ReverseList(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node next = head.next;
        head.next = null;
        Node newNode = ReverseList(next);
        next.next = head;
        return newNode;
    }

    /**
     * 第二种策略：空间复杂度低的做法
     */
    public static Node ReverseListNode(Node head) {
        Node newNode = new Node(-1);
        while(head != null) {
            Node next = head.next;
            head.next = newNode.next;
            next.next = head;
            head = newNode;
        }
        return newNode.next;
    }
}
