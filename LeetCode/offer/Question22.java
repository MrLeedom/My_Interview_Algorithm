package offer;

import com.list.Node;

import java.util.HashSet;

/**
 * @author:leedom
 * @date: 6/24/19 2:59 PM
 * Description: 删除链表中重复的节点
 *      有两种:
 *          1.一种是每个元素只出现一次
 *          2.所有重复的元素全部给删除掉,一旦重复就认为是异常,必删
 * License: (C)Copyright 2019
 */
public class Question22 {
    /*
        非递归版本,采用hashset来做
     */
    public static Node deleteRepeatNode(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        HashSet<Integer> set = new HashSet<>();
        Node cur = head;
        set.add(head.value);
        while(cur.next != null) {
            if(!set.contains(cur.next.value)){
                set.add(cur.next.value);
                cur = cur.next;
            }else{
                cur.next = cur.next.next;
            }
        }
        return head;
    }
    /*
    将重复节点全部删除掉,与上面的方法有区别
     */
    public static Node deleteDuplication(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node next = head.next;
        if(head.value == next.value) {
            while(next != null && head.value == next.value) {
                next = next.next;
            }
            return deleteDuplication(next);
        }else {
            head.next = deleteDuplication(head.next);
            return head;
        }
    }

    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        Node node4 = new Node(3);
        Node node5 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node.printList(node1);

        deleteDuplication(node1);
        Node.printList(node1);
    }

}
