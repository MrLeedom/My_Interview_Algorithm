package com.tree;


import java.util.LinkedList;

/***************************************************************************
 @description :     采用非递归的方式获取二叉树的深度
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-04 16:39  caoshipeng  create
 ****************************************************************************/
public class TreeDepth {
    public static int findDeep(TreeNode root) {
        if(root == null) {
            return 0;
        }
        TreeNode current = null;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int cur, last;
        int level = 0;
        while (!queue.isEmpty()) {
            cur = 0;
            last = queue.size();
            while (cur < last) {
                current = queue.poll();
                cur++;
                if(current.left != null) {
                    queue.offer(current.left);
                }
                if(current.right != null) {
                    queue.offer(current.right);
                }
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        while(true) {
            TreeNode root = TreeNode.buildTree();
            System.out.println(findDeep(root));
        }

    }
}
