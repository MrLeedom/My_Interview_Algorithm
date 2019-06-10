package com.list;

import java.util.HashSet;

/**
 * @author:leedom
 * @date: 6/10/19 9:23 PM
 * Description:删除无序单链表中值重复出现的节点
 *      采用哈希表来做
 * License: (C)Copyright 2019
 */

public class DeleteRepeatNode {
    /*
    这一块主要是要将列表中重复的元素进行删除,所以涉及到链表指针的相关操作
     */
    public void remove(Node head) {
        if(head == null) {
            return;
        }

        HashSet<Object> set = new HashSet<>();
        Node pre = head;
        Node current = head.next;
        set.add(pre.value);

        while(current!=null) {
            if(set.contains(current.value)) {
                pre.next = current.next;
            }else {
                set.add(current.value);
                pre = current;
            }
            current = current.next;
        }

    }
}
