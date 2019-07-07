package offer;

/**
 * @author:leedom
 * @date:2019/7/7 18:53
 * Description: 对称二叉树
 *      请实现一个函数，判断一颗二叉树是否对称（注意，如果一个二叉树同此二叉树的镜像是同样的，便判定为对称）
 * License: (C)Copyright 2019
 */
public class Question32 {
    public static boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    public static boolean isSymmetrical(TreeNode left, TreeNode right) {
        if(left == null && right !=null) {
            return false;
        }
        if(left !=null && right == null) {
            return false;
        }
        if(left.value != right.value) {
            return false;
        }
        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }
}
