package offer;

import com.list.Node;

/**
 * @author:leedom
 * @date:2019/6/30 20:52
 * Description:一个链表中包含环，请找出该链表的环入口节点，要求不要使用额外的空间
 * License: (C)Copyright 2019
 */
public class Question27 {
    public static Node entryNodeOfLoop(Node head) {
        if(head == null || head.next == null) {
            return null;
        }
        Node fast = head, slow = head;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while(fast != slow);
        fast = head;
        while(fast != head) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
