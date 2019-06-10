package com.list;

import java.util.Stack;

/**
 * @author:leedom
 * @date: 6/10/19 9:35 PM
 * Description:判断一个链表是否是回文结构(从左遍历和从右遍历的结果是一样的)
 * 1.采用策略是利用栈来做,弹出的元素与遍历进行比较
 * License: (C)Copyright 2019
 */

public class IsPalindrome {
    public boolean isPalindrome(Node head) throws Exception {
        if(head == null) {
            throw new Exception("list is null!");
        }
        Stack<Node> stack = new Stack<>();
        Node current = head;

        while(current != null) {
            stack.push(current);
            current = current.next;
        }

        while(head != null) {
            if(head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
    
    public static void main(String[] args) throws Exception{
        IsPalindrome is = new IsPalindrome();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        
        System.out.println(is.isPalindrome(node1));
    }

}
