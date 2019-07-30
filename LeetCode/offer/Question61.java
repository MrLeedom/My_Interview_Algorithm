package offer;

/***************************************************************************
 @description :     二叉树的深度
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-07-30 23:28  caoshipeng  create
 ****************************************************************************/
public class Question61 {
    public int TreeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}
