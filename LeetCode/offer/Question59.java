package offer;

import com.list.Node;

/***************************************************************************
 @description :     两个链表的第一个公共节点
 当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；同样地，
 当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-07-30 23:20  caoshipeng  create
 ****************************************************************************/
public class Question59 {
    public Node FindFirstCommonNode(Node pHead1, Node pHead2) {
        Node l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }
}
