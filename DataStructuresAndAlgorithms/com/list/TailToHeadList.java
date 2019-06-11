package com.list;

import java.util.ArrayList;

/**
 * @author:leedom
 * @date: 6/11/19 1:48 PM
 * Description:
 *      输入一个链表,从尾到头打印链表每个节点的值
 *      使用递归的思想来做,不要拆开看,就看每一步,只思考这一部分就好
 * License: (C)Copyright 2019
 */
public class TailToHeadList {
    ArrayList<Object> list = new ArrayList<>();
    
    public ArrayList<Object> print(Node head) {
        if(head != null) {
            print(head.next);
            list.add(head.value);
        }
        return list;
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
        TailToHeadList list = new TailToHeadList();
        ArrayList result = list.print(node1);
        for (Object item: result) {
            System.out.println((int)item);
        }
    }
}
