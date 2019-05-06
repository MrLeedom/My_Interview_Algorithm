package offer;

/**
 * @author:leedom
 * @date: 5/6/19 9:10 PM
 * Description:从尾到头打印链表
 * 这个题目在春招华为现场面试遇到
 * License: (C)Copyright 2019
 */

public class Question6 {
    static  class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static Node reverseLinkList(Node head) {
        Node pre= null;
        Node next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void printLinkList(Node node) {
        while(node!=null) {
            if(node.value == -1) {
                node = node.next;
                continue;
            }
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        printLinkList(node1);
        Node cur = reverseLinkList(node1);
        System.out.println("=====================");
        printLinkList(cur);
    }
}
