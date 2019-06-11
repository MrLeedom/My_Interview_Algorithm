package com.list;

/**
 * @author:leedom
 * @date: 6/11/19 2:15 PM
 * Description:  经典题目   :    两个有序链表的合并
 *  输入两个单调递增的链表,输出两个链表合成后的链表,合成后的链表需要满足单调不减的原则
 *  注意要点:这一块设计的时候不要讨论两个指针一起运动的情况,很难来做,所以可以合并两种情况,同样也能实现合并
 * License: (C)Copyright 2019
 */
public class MergeList {
    public Node merge(Node head1, Node head2) throws Exception{
        Node newNode;
        if(head1 == null && head2 == null) {
            throw new RuntimeException("lists are null!");
        }else if(head1 == null) {
            return head2;
        }else if(head2 == null) {
            return head1;
        }else{
            if(head1.value < head2.value) {
                newNode = head1;
                newNode.next = merge(head1.next, head2);
            }else{
                newNode = head2;
                newNode.next = merge(head1, head2.next);
            }
        }
        return newNode;
    }
    
    public static void main(String[] args) throws Exception{
        
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
        
        MergeList merge = new MergeList();
        Node list = merge.merge(node1, node6);
        System.out.println(list.next.next.next.next.next.next.next.next.next.next.next.next.value);
    }
}
