package offer;

import com.list.Node;

/**
 * @author:leedom
 * @date: 6/24/19 2:37 PM
 * Description: 删除链表节点,在O(1)时间内
 *      主要是两种情况:(主要是边界情况,往往先不要设想边界情形)
 *          1.删除节点是最后一个节点
 *          2.删除节点不是最后一个节点
 * License: (C)Copyright 2019
 */
public class Question21 {
    public static Node deleteNode(Node head, Node tobeDelete) {
        if(head == null || tobeDelete == null) {
            return null;
        }
        if(tobeDelete.next != null) {
            //删除的节点不是最后一个节点时,将原本tobeDelete复制一遍啦!!!
            Node next = tobeDelete.next;
            tobeDelete.value = next.value;
            tobeDelete.next = next.next;
        }else{
            if(head == tobeDelete) {
                head = null;
            }else {
                //关键是找到前一个节点
                Node cur = head;
                while(cur.next != tobeDelete) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
        return head;
    }

    public static void printList(Node head) {
        while(head!=null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("================");
    }

    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printList(node1);

        deleteNode(node1,node5);
        printList(node1);
    }
}
