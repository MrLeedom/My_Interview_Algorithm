package com.list;

/**
 * @author:leedom
 * @date: 6/11/19 4:19 PM
 * Description:     经典题目    :    求链表的中间节点
 *      采用快慢指针来做,慢指针一次走一步,快指针一次走两步,不过要区分奇数偶数链表情况,采用举例法来做:
 *      1->2->3->4->null            mid:3
 *      1->2->3->4->5->null         mid:3
 * License: (C)Copyright 2019
 */
public class MiddleNode {
    public Node findMidNode(Node head) {
        if(head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast == null ? slow : slow.next;
    }

    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        MiddleNode list = new MiddleNode();
        System.out.println(list.findMidNode(node1).next.value);
    }
}
