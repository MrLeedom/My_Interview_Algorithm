package com.list;

/**
 * @author:leedom
 * @date: 6/11/19 1:56 PM
 * Description:   经典题目  :   单链表反转
 *      输入一个链表,反转链表后,输出链表的所有元素,反转链表的关键点
 *    要去深刻理解下链表中涉及到的类似指针的思想，你就直接把左边当成未知，右边怎么指你就怎么去。
 * License: (C)Copyright 2019
 */
public class ReverseList {
    public Node reverse(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        
        ReverseList list = new ReverseList();
        Node node = list.reverse(node1);
        System.out.println(node.value);
        System.out.println(node.next.value);
        System.out.println(node.next.next.value);
        System.out.println(node.next.next.next.value);
        System.out.println(node.next.next.next.next.value);
    }
}
