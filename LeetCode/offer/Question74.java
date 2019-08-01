package offer;

/***************************************************************************
 @description :     树中两个节点的最低公共祖先
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-02 00:00  caoshipeng  create
 ****************************************************************************/
public class Question74 {
    /*二叉搜索树：二叉查找树中，两个节点 p, q 的公共祖先 root 满足 root.val >= p.val && root.val <= q.val。*/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root.value > p.value && root.value > q.value)
            return lowestCommonAncestor(root.left, p, q);
        if (root.value < p.value && root.value < q.value)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    /*普通二叉树：在左右子树中查找是否存在 p 或者 q，如果 p 和 q 分别在两个子树中，那么就说明根节点就是最低公共祖先。*/
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
