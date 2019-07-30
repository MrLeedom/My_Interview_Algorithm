package offer;

/***************************************************************************
 @description :     平衡二叉树
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-07-30 23:29  caoshipeng  create
 ****************************************************************************/
public class Question62 {
    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null || !isBalanced)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1)
            isBalanced = false;
        return 1 + Math.max(left, right);
    }
}
