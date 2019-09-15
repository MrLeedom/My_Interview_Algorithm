package com.tree;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-12 14:24  caoshipeng  create
 ****************************************************************************/
public class TraverseTree {
    public static void printNode(int value) {
        System.out.print(value + " ");
    }

    public static void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        printNode(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        printNode(root.val);
        inOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.right);
        postOrder(root.left);
        printNode(root.val);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        preOrder(node1);
        System.out.println();
        inOrder(node1);
        System.out.println();
        postOrder(node1);
    }
}
