package offer;

/**
 * @author:leedom
 * @date:2019/7/7 18:37
 * Description:树的基础模型结构
 * License: (C)Copyright 2019
 */
public class TreeNode {
    int value;
    TreeNode right;
    TreeNode left;

    public TreeNode() {
        this.value = 0;
        this.right = new TreeNode();
        this.left = new TreeNode();
    }

    public TreeNode(int val, TreeNode right, TreeNode left) {
        this.value = val;
        this.right = right;
        this.left = left;
    }
}
