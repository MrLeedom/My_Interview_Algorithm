package offer;

/**
 * @author:leedom
 * @date:2019/7/7 18:35
 * Description:输入两棵二叉树A,B，判断B是不是A的子结构，我们约定空树不是任意一个树的子结构
 * License: (C)Copyright 2019
 */
public class Question30 {
    public static boolean hasSubTree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) {
            return false;
        }
        return isSubTreeWithRoot(root1, root2) || hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
    }

    public static boolean isSubTreeWithRoot(TreeNode root1, TreeNode root2) {
        //这一块的逻辑暂时还要思考，前面提到空树不是任意一个树的子结构，所以此处是否应该为false吗？？
        if(root2 == null) {
            return true;
        }
        if(root1 == null) {
            return false;
        }
        if(root1.value != root2.value) {
            return false;
        }
        return isSubTreeWithRoot(root1.right,root2.right) && isSubTreeWithRoot(root1.left, root2.left);
    }
}
