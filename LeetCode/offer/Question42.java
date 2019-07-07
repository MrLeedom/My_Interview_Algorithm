package offer;

/**
 * @author:leedom
 * @date:2019/7/7 20:46
 * Description:二叉搜索树与双向链表
 * 输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表，要求不能创建任何新的节点，职能调整树中结点指针的指向。
 *      2
 *     / \
 *    1  3    1-> <- 2-><-3
 * License: (C)Copyright 2019
 */
public class Question42 {
    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode convert(TreeNode root) {
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        node.left = pre;
        if(pre != null) {
            pre.right = node;
        }
        pre = node;
        if(head == null) {
            head = node;
            inOrder(node.right);
        }
    }
}
