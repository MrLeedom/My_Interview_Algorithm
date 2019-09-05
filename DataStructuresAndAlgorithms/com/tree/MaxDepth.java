package com.tree;


/***************************************************************************
 @description :     想要获得一个二叉树的深度
 二叉树的问题其实都要用到分治的思想，递归的技巧来做
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-04 16:27  caoshipeng  create
 ****************************************************************************/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
    public static TreeNode buildTree() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(10);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node6;
        node3.left = node5;
        return node1;
    }
}
public class MaxDepth {
    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int bigger = Math.max(left, right);
        return bigger + 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        node1.left = node2;
        node2.left = node3;
        System.out.println(maxDepth(node1));
    }
}
