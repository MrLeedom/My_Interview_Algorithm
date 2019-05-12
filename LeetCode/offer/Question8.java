package offer;

/**
 * @author:leedom
 * @date: 5/12/19 8:43 PM
 * Description:给定一个二叉树和其中一个结点,请找出中序遍历的下一个节点并且返回.注意:树中的结点不仅包含左右子节点,同时包含指向父节点的指针
 * License: (C)Copyright 2019
 */
class TreeLinkNode{
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class Question8 {
    public static TreeLinkNode getNext(TreeLinkNode node) {
        if(node == null) {
            return null;
        }
        if(node.right != null) {
            TreeLinkNode curNode = node.right;
            while (curNode.left != null) {
                curNode = curNode.left;
            }
            return curNode;
        } else {
            while (node.next != null) {
                TreeLinkNode parent = node.next;
                if(parent.left == node) {
                    return parent;
                }
                node = parent.next;
            }
        }
        return null;
    }
    public static void main(String[] args){
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
//        TreeLinkNode node8 = new TreeLinkNode(1);
//        TreeLinkNode node9 = new TreeLinkNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node5.right = node7;
        node2.next = node1;
        node3.next = node1;
        node4.next = node2;
        node5.next = node2;
        node6.next = node5;
        node7.next = node5;
        System.out.println(getNext(node7).val);
    }
}
