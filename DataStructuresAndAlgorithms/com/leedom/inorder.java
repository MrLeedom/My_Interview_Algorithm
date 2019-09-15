package com.leedom;

/***************************************************************************
 @description :     中序遍历打印二叉树
 原本的思路应该是没有问题的，代码逻辑应该也是合理的，面试官的疑问没太能理解，回来想了想可能是由于自己函数的
 返回值这一块没有捋清楚，希望放过。
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-12 12:50  caoshipeng  create
 ****************************************************************************/
public class inorder {
    static class TreeNode {
        private int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int value) {
            this.val = value;
        }
    }

    public static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        print(root.val);
        inOrder(root.right);
    }

    public static void print(int value) {
        System.out.print(value + " ");
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        inOrder(node1);
    }
}
