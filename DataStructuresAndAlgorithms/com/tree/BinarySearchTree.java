package com.tree;

import java.util.Stack;

/***************************************************************************
 @description :
 二叉查找树是为了实现快速查找而生的，不过，它不仅仅支持快速查找一个数据，还支持快速插入、删除一个数据。
 二叉查找树要求，在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这
 个节点的值。
 二叉查找树中序遍历是有序的。
 时间复杂度最差为O(n)，而我们的平衡二叉查找树，它的插入，删除，查找时间复杂度可以做到O(logn)
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-12 14:11  caoshipeng  create
 ****************************************************************************/
public class BinarySearchTree {
    private static TreeNode tree;

    /**
     * 二叉树的查找操作
     * @param data
     * @return
     */
    public static TreeNode find(int data) {
        TreeNode tmp = tree;
        while(tmp != null) {
            if(data < tmp.val) {
                tmp = tmp.left;
            } else if(data > tmp.val) {
                tmp = tmp.right;
            } else {
                return tmp;
            }
        }
        return null;
    }

    /**
     * 二叉树的插入操作
     * @param data
     */
    public static void insert(int data) {
        if(tree == null) {
            tree = new TreeNode(data);
            return;
        }

        TreeNode tmp = tree;
        while(tmp != null) {
            if(data > tmp.val) {
                if(tmp.right == null) {
                    tmp.right = new TreeNode(data);
                    return;
                }
                tmp = tmp.right;
            } else {
                if(tmp.left == null) {
                    tmp.left = new TreeNode(data);
                    return;
                }
                tmp = tmp.left;
            }
        }
    }

    /**
     * 二叉树的删除操作
     * @param data
     */
    public static void delete(int data) {
        TreeNode target = tree;//target指向要删除的节点，初始化指向根节点
        TreeNode parent = null;//parent记录的是target的父节点
        while(target != null && target.val != data) {
            parent = target;
            if(data > target.val) {
                target = target.right;
            }else{
                target = target.left;
            }
        }
        if(target == null) {
            return;//没有找到
        }

        //要删除的节点有两个子节点
        if(target.left != null && target.right != null) {
            TreeNode minTarget = target.right;
            TreeNode minParent = target;//表示minTarget的父节点
            while(minTarget.left != null) {
                minParent = minTarget;
                minTarget = minParent.left;
            }
            target.val = minTarget.val;
            target = minTarget;
            parent = minParent;
        }

        //要删除的节点是叶子节点或者仅有一个子节点
        TreeNode child;//target的子节点
        if(target.left != null) {
            child = target.left;
        }else if(target.right != null) {
            child = target.right;
        }else{
            child = null;
        }
        if(parent == null) {
            tree = child;//删除的是根节点
        }else if(parent.left == target){
            parent.left = child;
        }else{
            parent.right = child;
        }
    }

    /**
     * 判断一颗树是不是二叉查找树，哎呀，有坑，要有中序遍历的思路来解决，或者用栈存储
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()) {
            //先得到所有的左节点
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //当中序遍历前一个节点的值大于后一节点值的时候
            if(pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return false;
    }


    private static int target = Integer.MIN_VALUE;

    /**
     * 我们可以采用数组存住遍历顺序，然后判断我们的数组是否为递增数组，有更简单的方法，只保存遍历节点的上一个节点
     * 值，不需要另外开辟空间。因为中序遍历是递增的，所以只需要比较上一个节点的值和该节点值的大小即可。
     * @param root
     * @return
     */
    public static boolean isTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(!isTree(root.left)) {
            return false;
        }
        if(root.val <= target) {
            return false;
        }
        target = root.val;
        if(!isTree(root.right)) {
            return false;
        }
        return true;
    }
}
