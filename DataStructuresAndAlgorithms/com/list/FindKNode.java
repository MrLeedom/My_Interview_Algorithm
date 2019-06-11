package com.list;

/**
 * @author:leedom
 * @date: 6/11/19 2:49 PM
 * Description:     经典题目    :     找到链表中倒数第K个结点
 *  采用两个指针来做,先让其中一个指针走K-1步,然后让两个指针一起运动
 *  这一题改成删除的话,只用将K改动就好
 * License: (C)Copyright 2019
 */
public class FindKNode {
    public Node findKthToTail(Node head, int k) {
        Node pointer1 = null, pointer2 = null;
        pointer1 = head;
        pointer2 = head;

        int target = k;
        int count = 0;
        /*
            控制两个指针的开始运行时刻
         */
        while(pointer1 != null) {
            pointer1 = pointer1.next;
            count ++;
            if(k < 1) {
                pointer2 = pointer2.next;
            }
            k --;
        }
        if(count < target) {
            return null;
        }

//        pointer2.next = pointer2.next.next;这一行是控制节点的删除功能
        return pointer2;
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

        FindKNode newNode = new FindKNode();
        System.out.println(newNode.findKthToTail(node1,2).next.next.next.next.value);
    }
}
