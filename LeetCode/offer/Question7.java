package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:leedom
 * @date: 5/6/19 9:50 PM
 * Description:根据二叉树前序遍历和中序遍历的结果,重建二叉树,加设输入的前序遍历和后序遍历的结果中都不含重复的数字
 * License: (C)Copyright 2019
 */
public class Question7 {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value) {
            this.value = value;
        }
    }
    private static Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for(int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length-1, 0);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if(preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int index = indexForInOrders.get(root.value);
        int leftTreeSize = index - inL;
        root.left = reConstructBinaryTree(pre, preL+1,preL+leftTreeSize,inL);
        root.right = reConstructBinaryTree(pre, preL+leftTreeSize+1,preR,preL+leftTreeSize+1);
        return root;
    }
    
    public static void main(String[] args){
//        TreeNode node1 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(9);
//        TreeNode node3 = new TreeNode(20);
//        TreeNode node4 = new TreeNode(15);
//        TreeNode node5 = new TreeNode(7);
//        node1.left = node2;
//        node1.right = node3;
//        node3.left = node4;
//        node3.right = node5;
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode node = reConstructBinaryTree(pre,in);
        System.out.println(node.left.value);
        System.out.println(node.right.value);
    }
}
