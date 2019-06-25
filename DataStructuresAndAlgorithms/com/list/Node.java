package com.list;

/**
 * @author:leedom
 * @date: 6/10/19 9:45 PM
 * Description:  链表的标准节点构造
 * License: (C)Copyright 2019
 */
public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public static void printList(Node head) {
        while(head!=null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
