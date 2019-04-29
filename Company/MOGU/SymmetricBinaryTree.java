import sun.reflect.generics.tree.Tree;

/**
 * @author:leedom
 * @date: 4/29/19 10:09 PM
 * Description:蘑菇街现场面试,一面手撕代码:
 *          写一颗对称二叉树!
 *          刚开始自己当做满二叉树来解决,是有问题的.
 *      应该结合递归和迭代两个方法来解决该问题.需要熟练默写该段代码:
 *      1.这棵树是空的,True
 *      2.判断这颗树的左子树和右子树是否对称
 *      3.两颗树对称的条件:根节点相等,左子树的左子树和右子树的右子树对称,左子树的右子树和右子树的左子树对称
 * License: (C)Copyright 2019
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class SymmetricBinaryTree {
    public static boolean isSymmtric(TreeNode root) {
        if(root == null) {
            return true;
        }else {
            return isSymmtric(root.left, root.right);
        }
    }

    private static boolean isSymmtric(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        } else if(left == null || right == null) {
            return false;
        } else {
            return left.val == right.val && isSymmtric(left.left, right.right) && isSymmtric(left.right, right.left);
        }
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        System.out.println(isSymmtric(t1));
    }

}
