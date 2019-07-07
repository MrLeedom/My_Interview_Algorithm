package offer;

/**
 * @author:leedom
 * @date:2019/7/7 18:47
 * Description:二叉树的镜像问题，也就是从中间划分，两边能够折叠对应起来
 *    8        8
 *   / \      / \
 *  2  3     3  2
 *      只需要化繁为简，从局部出发思考
 * License: (C)Copyright 2019
 */
public class Question31 {
    public static void mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        swap(root);
        mirror(root.left);
        mirror(root.right);
    }

    public static void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
