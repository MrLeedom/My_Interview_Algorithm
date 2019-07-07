package offer;

/**
 * @author:leedom
 * @date:2019/7/7 20:34
 * Description:复杂链表的复制
 * 输入一个复杂的链表，每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点，返回结果为复制后
 * 复杂链表的head
 * 做法是：在每一个节点后面插入复制的节点，对复制的节点random链接进行赋值，最后拆分开
 * License: (C)Copyright 2019
 */
class RandomListNode{
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    public RandomListNode(int label) {
        this.label = label;
    }
}
public class Question41 {
    public static RandomListNode clone(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }
        //插入新节点
        RandomListNode cur = pHead;
        while(cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        //建立random链接
        cur = pHead;
        while(cur != null) {
            RandomListNode clone = cur.next;
            if(cur.random != null) {
                clone.random = cur.random.next;
                cur = clone.next;
            }
        }

        //拆分,一个节点一个节点去拆
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }
}
