package offer;

import com.list.Node;
import util.MyTools;

/**
 * @author:leedom
 * @date:2019/6/26 23:21
 * Description:找寻链表倒数第K个节点
 * License: (C)Copyright 2019
 */
public class Question26 {
    public static Node findLastKNode(Node head, int k) {
        if(head == null) {
            return null;
        }
        Node first = head,second = head;
        while(k-- != 0) {
            first = head.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
    public static void main(String[] args) {
        Node head = new MyTools().generateList();
        new MyTools().printList(head);
        System.out.println();
        new MyTools().printList(findLastKNode(head, 2));
    }
}
