package com.list;

/**
 * @author:leedom
 * @date: 6/10/19 9:56 PM
 * Description:打印两个有序链表的公共部分
 * License: (C)Copyright 2019
 */
public class PrintCommonList {
    public void print(Node head1, Node head2) {
        if(head1 == null || head2 == null) {
            return;
        }
        while(head1 != null && head2 != null) {
            if(head1.value == head2.value) {
                System.out.println(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            } else if(head1.value < head2.value) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }
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

        Node node6 = new Node(4);
        Node node7 = new Node(5);
        Node node8 = new Node(6);
        Node node9 = new Node(7);
        Node node10 = new Node(8);
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        PrintCommonList pl = new PrintCommonList();
        pl.print(node1, node6);
    }

}
