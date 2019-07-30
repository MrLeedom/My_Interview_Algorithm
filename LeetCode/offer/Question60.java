package offer;

/***************************************************************************
 @description :     二叉查找树的第 K 个结点
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-07-30 23:27  caoshipeng  create
 ****************************************************************************/
public class Question60 {
    private TreeNode ret;
    private int cnt = 0;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return ret;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null || cnt >= k)
            return;
        inOrder(root.left, k);
        cnt++;
        if (cnt == k)
            ret = root;
        inOrder(root.right, k);
    }
}
